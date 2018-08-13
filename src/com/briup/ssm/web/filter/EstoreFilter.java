package com.briup.ssm.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class EstoreFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	/** 
	* @Description: 过滤器
	* @param:请求,响应,FilterChain
	* @return：返回结果描述
	* @throws：异常描述
	*/
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)arg0;
		HttpSession session = request.getSession();
		Object object = session.getAttribute("customer");
		if (object != null) {
			arg2.doFilter(arg0, arg1);
		}else {
			HttpServletResponse response = (HttpServletResponse)arg1;
			response.sendRedirect("/ssm/login");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}


}
