package com.angBackend.libraryProject.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.Entities.BooksInf.Books;
import com.angBackend.libraryProject.Repository.Repositories.BookDao;
import com.angBackend.libraryProject.Service.Services.BookService;

@Service
public class BookServiceImp implements BookService {

	private BookDao bookDao;

	@Autowired
	public BookServiceImp(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Books> getList() {
		return bookDao.getList();
	}

	@Override
	public void save(Books object) {
		bookDao.save(object);
	}

	@Override
	public Books update(Books object) {
		bookDao.update(object);
		return getRecordbyId(object.getBookid());
	}

	@Override
	public void delete(Books object) {
		bookDao.delete(object);
	}

	@Override
	public Books getRecordbyId(Long id) {
		return bookDao.getRecordbyId(id);
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
