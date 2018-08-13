package com.briup.ssm.web.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.common.util.ResponseResult;
import com.briup.ssm.common.util.UtilsTool;
import com.briup.ssm.service.interfaces.ICustomerService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @Description 针对用户的视图处理
 * @author firename
 * @date 2018年8月13日 下午10:53:07
 * firename97@163.com
 */
@Controller
public class CustomerController {
	@Autowired
	ICustomerService custoermService;
	
	/**   
	* @param:@param customer 用户的注册信息
	* @param:@param session 用来发送消息
	* @return：页面跳转路径
	* @throws：用户注册异常
	*/
	@RequestMapping(value="saveCustomer")
	public String register(Customer customer,HttpSession session){
		try {
			System.out.println(customer);
			custoermService.register(customer);
			session.setAttribute("msg", "注册成功,请登录");
			return "redirect:login";
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", "注册失败"+e.getMessage());
			return "redirect:register";
		}
		
	}
	
	/**   
	* @param:@param username 通过url获取的用户名 用来验证用户名是否存在
	* @return：返回的json信息
	* @throws：用户名查询异常
	*/
	@RequestMapping(value="checkname/{username}")
	@ResponseBody
	public ResponseResult checkName(@PathVariable String username){
		System.out.println(username);
		if (!UtilsTool.isBlank(username)) {
				Customer customer;
				try {
					customer = custoermService.checkName(username);
				if (customer==null) {
					return new ResponseResult(200,"Y","该用户名可以注册");
				}
				return new ResponseResult(501,"N","该用户名已存在");
			} catch (EstoreCommonException e) {
				e.printStackTrace();
			}
		}
		return new ResponseResult(502,"N","用户名不能为空");
	}
	
	/**   
	* @param:@param customer 通过异步交互获取的用户登录信息
	* @param:@param session 
	* @param:@param request 
	* @return：返回json结果
	* @throws：用户名密码错误
	*/
	@RequestMapping(value="/login/login")
	@ResponseBody
	public ResponseResult login(@RequestBody Customer customer,HttpSession session){
		try {
			Customer login = custoermService.login(customer.getName(), customer.getPassword());
			ShoppingCar shoppingcar = new ShoppingCar();
			session.setAttribute("customer", login);
			session.setAttribute("shoppingcar", shoppingcar);
			session.setAttribute("password", customer.getPassword());
			session.setAttribute("msg", "登录成功");
			return new ResponseResult(200,"YES","登录成功");
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.removeAttribute("password");
			return new ResponseResult(402,"NO",e.getMessage());	
		}
	}
	
	/**   
	* @param:@param 通过post请求获取的用户信息 用来更改用户信息
	* @param:@param session
	* @return：跳转的路径
	* @throws：用户名修改错误
	*/
	@RequestMapping("/updateUser")
	public String updateUser(Customer customer,HttpSession session){
		try {
			Customer cus = (Customer) session.getAttribute("customer");
			customer.setId(cus.getId());
			custoermService.updateCustomer(customer);
			session.setAttribute("password",customer.getPassword());
			session.setAttribute("customer", customer);
			session.setAttribute("msg", "修改成功");
			return "redirect:/userinfo";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
			return "redirect:/login";
		}
	}
}
