package com.briup.ssm.service.interfaces;

import java.util.List;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.github.pagehelper.PageInfo;

public interface IBookService {
	
	PageInfo<Book> findAllBookWithPage(int page,int row) throws EstoreCommonException;
	List<Book> listAllBooks() throws EstoreCommonException ;
	Book findById(Long id) throws EstoreCommonException;
	String findTypeByBook(Book book) throws EstoreCommonException;
}
