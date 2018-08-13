package com.briup.ssm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.briup.ssm.common.bean.Book;


/**
 * @Description
 * @author firename
 * @date 2018年8月1日 下午2:14:42
 * firename97@163.com
 */
public interface IBookDao  {
	public List<Book> queryAll();
	public Book queryById(Long id);
	public String findTypeByBook(Book book);
	public void updateDelBook(@Param("bookid") Long bookid,@Param("num") Integer num);
}
