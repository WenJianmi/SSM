package com.briup.ssm.dao;


import java.util.List;

import com.briup.ssm.common.bean.Line;
import com.briup.ssm.common.bean.Order;

public interface IOrderDao  {
	public void saveOrder(Order order);
	public void saveLine(Line line);
	public Order findOrderById(Long id);
	public void deleteOrderById(Long id);
	public void deleteLineByOid(long oid);
}
