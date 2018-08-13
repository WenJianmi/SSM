package com.briup.ssm.service.impl;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.dao.IBookDao;
import com.briup.ssm.dao.ILineDao;
import com.briup.ssm.dao.IOrderDao;
import com.briup.ssm.service.interfaces.IOrderService;

/**
 * @Description 订单业务逻辑
 * @author firename
 * @date 2018年8月13日 下午11:16:23
 * firename97@163.com
 */
@Service
public class OrderServiceImpl implements IOrderService {

	@Autowired
	IOrderDao orderDao;
	@Autowired
	IBookDao bookDao;
	
	/** 
	* @Description: 保存订单
	* @param:用户信息，订单信息，单个商品购买信息
	* @return：返回结果描述
	* @throws：用户为null
	*/
	@Override
	public void saveOrder(Customer customer, Order order, Collection<Line> lines) throws EstoreCommonException {
		if (customer!=null) {
			orderDao.saveOrder(order);
			System.out.println(order.getId());
			for (Line line : lines) {
				line.setOrder(order);
				orderDao.saveLine(line);
				bookDao.updateDelBook(line.getBook().getId(),line.getNum());
			}
		}
	}

	/** 
	* @Description: 删除指定订单
	* @param:订单id
	* @return：返回结果描述
	* @throws：订单id为null
	*/
	@Override
	public void deleteOrder(Long id) throws EstoreCommonException {
		if (id==null) {
			throw EstoreCommonException.getException(401);
		}
		orderDao.deleteLineByOid(id);
		orderDao.deleteOrderById(id);
	}

	/** 
	* @Description: 通过id查询指定订单
	* @param:订单id
	* @return：订单信息
	* @throws：参数为空
	*/
	@Override
	public Order findById(Long id) throws EstoreCommonException {
		if (id==null) {
			throw EstoreCommonException.getException(401);
		}
		Order orderById = orderDao.findOrderById(id);
		return orderById;
	}

}
