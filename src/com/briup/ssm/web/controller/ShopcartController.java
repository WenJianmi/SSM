package com.briup.ssm.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.ShoppingCar;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.service.interfaces.IBookService;

/**
 * @Description 购物车展示
 * @author firename
 * @date 2018年8月13日 下午11:07:27
 * firename97@163.com
 */
@Controller
@RequestMapping("shopcart")
public class ShopcartController {
	
	@Autowired
	IBookService bookservice;
	
	/**   
	* @param:@param bookid 通过url获取的书本id
	* @param:@param session
	* @return：跳转的路径
	* @throws：删除失败
	*/
	@RequestMapping("delLine/{bookid}")
	public String delLine(@PathVariable Long bookid,HttpSession session){
		ShoppingCar shoppingcar  = (ShoppingCar) session.getAttribute("shoppingcar");
		shoppingcar.delete(bookid);
		session.setAttribute("shoppingcar", shoppingcar);
		session.setAttribute("msg", "删除成功");
		return "redirect:/shopcart";
	}
	
	/**   
	* @param:@param session
	* @return：跳转的路径
	* @throws：
	*/
	@RequestMapping("clear")
	public String clear(HttpSession session){
		ShoppingCar shoppingcar  = (ShoppingCar) session.getAttribute("shoppingcar");
		if (shoppingcar.getLines().size()==0) {
			session.setAttribute("msg", "购物车什么也没有");
			return "redirect:/shopcart";
		}
		shoppingcar.clear();
		session.setAttribute("shoppingcar",shoppingcar);
		session.setAttribute("msg", "清除成功");
		return "redirect:/shopcart";
	}
	
	/**   
	* @param:@param bookid 通过url获取的书本id
	* @param:@param requestn
	* @return：跳转的路径
	* @throws：异常描述
	*/
	@RequestMapping("saveUpdate/{bookid}")
	public String saveUpdate(HttpSession session,@PathVariable Long bookid,HttpServletRequest request){
		ShoppingCar shoppingcar  = (ShoppingCar) session.getAttribute("shoppingcar");
		int num = Integer.parseInt(request.getParameter("num"));
		shoppingcar.getLines().get(bookid).setNum(num);
		session.setAttribute("shoppingcar",shoppingcar);
		session.setAttribute("msg", "修改成功");
		return "redirect:/shopcart";
	}
	
	/**   
	* @param:@param bookid  通过url获取的书本id
	* @param:@param session
	* @return：跳转的路径
	* @throws：添加购物车出错
	*/
	@RequestMapping(value="addToCart")
	public String addtoShpcart(@RequestParam(value="bookid") Long bookid,HttpSession session){
		try {
			Book book = bookservice.findById(bookid);
			ShoppingCar shoppingcar  = (ShoppingCar) session.getAttribute("shoppingcar");
			if (shoppingcar==null) {
				shoppingcar = new ShoppingCar();
			} 
			Line line = new Line();
			line.setBook(book);
			shoppingcar.add(line);
			session.setAttribute("shoppingcar", shoppingcar);
			session.setAttribute("msg", "添加成功");
			return "redirect:/shopcart";
		} catch (EstoreCommonException e) {
			e.printStackTrace();
			session.setAttribute("msg", "添加出错，请重试");
			return "redirect:/index";
		}
	}
	

}
