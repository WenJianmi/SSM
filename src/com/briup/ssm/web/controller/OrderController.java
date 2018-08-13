package com.briup.ssm.web.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.service.interfaces.ICustomerService;
import com.briup.ssm.service.interfaces.IOrderService;

/** 
 * @Description 订单页面的展示
 * @author firename
 * @date 2018年8月13日 下午11:04:14
 * firename97@163.com
 */
@Controller
@RequestMapping("orderlist")
public class OrderController {
	
	@Autowired
	IOrderService orderservice;
	@Autowired
	ICustomerService customerservice;

	/**   
	* @param:@param session
	* @param:@param payway 支付方式
	* @return：跳转的路径
	* @throws：保存订单出错
	*/
	@RequestMapping(value="saveOrder")
	public String saveOrder(HttpSession session,@RequestParam String payway){
		Customer customer = (Customer) session.getAttribute("customer");
		ShoppingCar shoppingcar  = (ShoppingCar) session.getAttribute("shoppingcar");
		Map<Long, Line> lines = shoppingcar.getLines();
		Collection<Line> values = lines.values();
		Order order = new Order();
		order.setStatus("未支付");
		order.setCost(shoppingcar.getCost());
		order.setPayway(payway);
		order.setCustomer(customer);
		order.setOrderDate(new Date());
		try {
			orderservice.saveOrder(customer, order, values);
			return "redirect:/index";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "登录异常，请重新登录");
			return "redirect:/login";
		}
	
	}
	
	/**   展示订单列表
	* @param:@param session
	* @return：跳转的路径
	* @throws： 订单列表查询出错
	*/
	@RequestMapping("order")
	public String listOrder(HttpSession session){
		try {
			Customer customer = (Customer) session.getAttribute("customer");
			List<Order> orders = customerservice.findOrdersByCid(customer.getId());
			session.setAttribute("orders", orders);
			session.setAttribute("msg", "订单列表");
			return "order";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
			return "order";
		}
	}
	
	/**   查询详细的订单信息
	* @param:@param orderid 通过url获取的订单id
	* @param:@param session
	* @return：跳转的路径
	* @throws：订单查询出错
	*/
	@RequestMapping(value="orderInfo/{orderid}")
	public String orderinfo(@PathVariable Long orderid,HttpSession session){
		try {
			Order order = orderservice.findById(orderid);
			session.setAttribute("msg", "订单信息");
			session.setAttribute("orderlines", order);
			return "redirect:/orderinfo";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			return "redirect:/order";
		}
	}
}
