package com.briup.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.common.util.MD5;
import com.briup.ssm.dao.ICustomerDao;
import com.briup.ssm.service.interfaces.ICustomerService;

/**
 * @Description 针对用户的业务处理
 * @author firename
 * @date 2018年7月31日 下午5:26:17
 * firename97@163.com
 */
@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao customerMapper;
	
	/** 
	* @Description: 用户注册
	* @param: customer 用户的注册信息
	* @return： 
	* @throws：用户信息为空
	*/
	@Override
	public void register(Customer customer) throws EstoreCommonException {
		if (customer ==null) {
			throw EstoreCommonException.getException(401);
		}
		customer.setPassword(MD5.getMD5Str(customer.getPassword()));
		customerMapper.saveCustomer(customer);
	
	}

	/** 
	* @Description: 登录验证
	* @param: name 登录的用户名 password 登录的密码
	* @return： 用户名密码正确后返回封装的用户信息，否则抛出异常
	* @throws：用户名密码不正确
	*/
	@Override
	public Customer login(String name, String password) throws EstoreCommonException {
		Customer customer = customerMapper.findByName(name);
		String password1= MD5.getMD5Str(password);
		if (customer==null || !customer.getPassword().equals(password1)) {
			throw EstoreCommonException.getException(402);
		}
		return customer;
	}

	/** 
	* @Description:更改用户信息
	* @param:用户信息
	* @return：返回结果描述
	* @throws：传入用户为null
	*/
	@Override
	public void updateCustomer(Customer customer) throws EstoreCommonException {
		if (customer==null) {
			throw new EstoreCommonException(500, "修改错误");
		}
		String password = MD5.getMD5Str(customer.getPassword());
		customer.setPassword(password);
		customerMapper.updateCustomer(customer);
	}

	
	/** 
	* @Description: 通过用户id查询订单列表
	* @param:用户id
	* @return：订单的list集合
	* @throws：未查询到订单异常
	*/
	@Override
	public List<Order> findOrdersByCid(long cid) throws EstoreCommonException {
		List<Order> listAllOrder = customerMapper.listAllOrder(cid);
		if (listAllOrder==null) {
			throw EstoreCommonException.getException(404);
		}
		return listAllOrder;
	}


	/** 
	* @Description: 检查用户名是否已存在
	* @param:用户名字
	* @return：用户信息
	* @throws：异常描述
	*/
	@Override
	public Customer checkName(String username) throws EstoreCommonException {
		Customer customer = customerMapper.findByName(username);
		if (customer == null) {
			return null;
		}
		return customer;
	}
	
	

}
