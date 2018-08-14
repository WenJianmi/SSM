package com.briup.ssm.web.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.common.util.AlipayConfig;
import com.briup.ssm.service.interfaces.IOrderService;

import net.sf.json.JSONObject;


@Controller
public class AlipayController {
	
	@Autowired 
	IOrderService orderService;
	
	@RequestMapping(value="alipay/{orderid}")
	public void pay(@PathVariable Long orderid,HttpSession session,HttpServletResponse response){
		try {
			Customer customer = (Customer) session.getAttribute("customer");
			Order order = orderService.findById(orderid);
			String out_trade_no = ""+System.currentTimeMillis(); //订单编号
			/* (必选) 订单标题 */
			String subject = customer.getName()+order.getId()+"订单"; //订单名字
			/* (必选) 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] */
			String total_amount =new String(order.getCost().toString().getBytes("ISO-8859-1"),"UTF-8");  //订单总价钱
			
			AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, 
					AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
			AlipayTradePagePayRequest payRequest = new AlipayTradePagePayRequest();
			payRequest.setReturnUrl("http://localhost:8088/orderlist/order");
			payRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\"," 
					+ "\"total_amount\":\""+ "100.0" +"\"," 
					+ "\"subject\":\""+ subject +"\"," 
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			String form="";
			try {
				response.setContentType("text/html;charset=utf-8");
				form = alipayClient.pageExecute(payRequest).getBody();	
				order.setStatus("已付款");
				orderService.updateOrder(order);
				PrintWriter out = response.getWriter();				
				out.println(form);
				out.flush();
				out.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
