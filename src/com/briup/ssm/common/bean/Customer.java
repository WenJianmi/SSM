package com.briup.ssm.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * 顾客类

 * */
@Repository
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 主键
	 * */
	private Long id;
	/**
	 * 用户名
	 * */
	private String name;
	/**
	 * 密码
	 * */
	private String password;
	/**
	 * 邮编
	 * */
	private String zip;
	/**
	 * 居住城市
	 */
	private String city;
	/**
	 * 地址
	 * */
	private String address;
	/**
	 * 手机号
	 * */
	private String telephone;
	/**
	 * email
	 * */
	private String email;
	/**
	 * 关联关系 - 一对多
	 * */
	private List<Order> orders = new ArrayList<Order>();
	
	public Customer(){
		
	}
	public Customer(Long id, String name, String passwd, String zip,
			String address, String telephone, String email, List<Order> orders, String city) {
		this.id = id;
		this.name = name;
		this.password = passwd;
		this.zip = zip;
		this.city=city;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.orders = orders;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", password=" + password + ", zip=" + zip + ", city=" + city
				+ ", address=" + address + ", telephone=" + telephone + ", email=" + email + ", orders=" + orders + "]";
	}
	
	
}
