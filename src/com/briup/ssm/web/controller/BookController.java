package com.briup.ssm.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.service.interfaces.IBookService;

/**
 * @Description 针对书本的业务处理
 * @author firename
 * @date 2018年8月13日 下午10:47:45
 * firename97@163.com
 */
@Controller
public class BookController {
	
	@Autowired
	IBookService bookservice;
	
	/**   
	* @param:@param bookid 通过url路径获取书本id
	* @param:@param session 获取session
	* @return：返回页面路径
	* @throws：通过id查询书本为空
	*/
	@RequestMapping(value="bookDetail/{bookid}")
	public String showBook(@PathVariable Long bookid,HttpSession session){
		try {
			Book book = bookservice.findById(bookid);
			session.setAttribute("book", book);
			session.setAttribute("msg", "书本信息");
			return "redirect:/products";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", e.getMessage());
			return "redirect:/index";
		}
		
	}

}
