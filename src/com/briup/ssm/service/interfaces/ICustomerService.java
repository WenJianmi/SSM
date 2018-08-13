package com.briup.ssm.service.interfaces;

import java.util.List;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Order;
import com.briup.ssm.common.exception.EstoreCommonException;

public interface ICustomerService {
	void register(Customer customer) throws EstoreCommonException;
	Customer login(String name,String password) throws  EstoreCommonException;
	void updateCustomer(Customer customer) throws  EstoreCommonException;
	List<Order> findOrdersByCid(long cid)throws  EstoreCommonException; 
	Customer checkName(String username) throws EstoreCommonException;
}
