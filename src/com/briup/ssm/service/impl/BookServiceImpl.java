package com.briup.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.ssm.common.bean.Book;
import com.briup.ssm.common.exception.EstoreCommonException;
import com.briup.ssm.dao.IBookDao;
import com.briup.ssm.service.interfaces.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @Description 书本业务层
 * @author firename
 * @date 2018年8月13日 下午11:11:17
 * firename97@163.com
 */
@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	IBookDao bookDao;

	/** 
	* @Description: 通过页码查询书本信息
	* @param:页码
	* @return：封装页面书本对象
	* @throws：异常描述
	*/
	@Override
	public PageInfo<Book> findAllBookWithPage(int page, int row) throws EstoreCommonException {
		PageHelper.startPage(page, row);
		List<Book> allbook = bookDao.queryAll();
		return new PageInfo<>(allbook);
	}

	@Override
	public List<Book> listAllBooks() throws EstoreCommonException {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	* @Description: 通过书本id查询指定书籍
	* @param:书本id
	* @return：书本的信息
	* @throws：书本未查询到
	*/
	@Override
	public Book findById(Long id) throws EstoreCommonException {
		Book book = bookDao.queryById(id);
		if (book==null) {
			throw EstoreCommonException.getException(404);
		}
		return book;
	}

	@Override
	public String findTypeByBook(Book book) throws EstoreCommonException {
		// TODO Auto-generated method stub
		return null;
	}

}
