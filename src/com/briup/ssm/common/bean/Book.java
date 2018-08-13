package com.briup.ssm.common.bean;

import java.io.Serializable;
import java.util.Arrays;
/**
 * 书
 * */
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double price;
	private int tid;
	private String desc;
	private int num;
	private int status;
	private byte[] pic;
	public Book(){
		
	}
	
	public Book(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price + ", tid=" + tid + ", desc=" + desc + ", num="
				+ num + ", status=" + status + ", pic=" + Arrays.toString(pic) + "]";
	}

	public Book(Long id, String name, Double price, int tid, String desc, int num, int status, byte[] pic) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.tid = tid;
		this.desc = desc;
		this.num = num;
		this.status = status;
		this.pic = pic;
	}
	
}
