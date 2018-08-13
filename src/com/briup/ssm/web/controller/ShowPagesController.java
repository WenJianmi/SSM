package com.briup.ssm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.ssm.common.bean.ShoppingCar;

/**
 * @Description 页面重定向到这完成试图渲染
 * @author firename
 * @date 2018年8月13日 下午11:10:21
 * firename97@163.com
 */
@Controller
public class ShowPagesController {

	@RequestMapping("login")
	public String toLogin(){
		return "login";
	}
	
	@RequestMapping("register")
	public String toRegister(){
		return "register";
	}
	
	
	@RequestMapping("products")
	public String toProducts(){
		return "productDetail";
	}
	
	@RequestMapping("orderinfo")
	public String toOrderinfo(){
		return "orderinfo";
	}
	
	@RequestMapping("shopcart")
	public String toShopcart(){
		return "shopcart";
	}
	
	@RequestMapping("userinfo")
	public String toUserinfo(){
		return "userinfo";
	}
	
	@RequestMapping("confirmOrder")
	public String toConfirm(HttpSession session){
		ShoppingCar shoppingcar  = (ShoppingCar) session.getAttribute("shoppingcar");
		if (shoppingcar.getLines().size()==0) {
			session.setAttribute("msg", "你的购物空空如也");
			return "redirect:index";
		}
		return "confirmOrder";
	}
}
