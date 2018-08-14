package com.briup.ssm.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.service.interfaces.IBookService;
import com.github.pagehelper.PageInfo;


/**
 * @Description 首页界面展示
 * @author firename
 * @date 2018年8月13日 下午11:00:30
 * firename97@163.com
 */
@Controller
public class IndexController {

	@Autowired
	IBookService bookServiceImpl;
	
	/**   
	* @param:@param page 通过get请求获取的书本展示页面
	* @param:@param session
	* @return：页面跳转路径
	* @throws：书本查询出错
	*/
	@RequestMapping(value={"index","/"})
	public String showIndexPage(@RequestParam(value="page",required=false,defaultValue="1") int page,HttpSession session){
		try {
			PageInfo<Book> bookWithPage = bookServiceImpl.findAllBookWithPage(page, 4);
			session.setAttribute("pageInfo", bookWithPage);
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "查询失败");
		}	
		return "index";
	}
	
	/**   用户注销
	* @param:@param session
	* @return：页面跳转路径
	* @throws：异常描述
	*/
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:index";
	}
	
}
