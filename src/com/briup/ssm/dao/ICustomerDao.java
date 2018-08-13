package com.briup.ssm.dao;


import java.util.List;

import com.briup.ssm.common.bean.Customer;
import com.briup.ssm.common.bean.Order;

public interface ICustomerDao  {
	public Customer findByName(String name);
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public List<Order> listAllOrder(Long cus_id);
}
