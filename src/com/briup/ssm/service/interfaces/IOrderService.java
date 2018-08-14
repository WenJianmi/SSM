package com.briup.ssm.service.interfaces;

import java.util.Collection;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.exception.EstoreCommonException;


public interface IOrderService {
	void saveOrder(Customer customer,Order order,Collection<Line> lines) throws EstoreCommonException;
	void deleteOrder(Long id) throws EstoreCommonException;
	Order findById(Long id) throws EstoreCommonException;
	void updateOrder(Order order)throws EstoreCommonException;
}
