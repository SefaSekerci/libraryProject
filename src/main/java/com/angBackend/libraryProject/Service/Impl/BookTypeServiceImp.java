package com.angBackend.libraryProject.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.Entities.BooksInf.BookType;
import com.angBackend.libraryProject.Repository.Repositories.BookTypeDao;
import com.angBackend.libraryProject.Service.Services.BookTypeService;

@Service
public class BookTypeServiceImp implements BookTypeService {

	private BookTypeDao booktypeDao;

	@Autowired
	public BookTypeServiceImp(BookTypeDao booktypeDao) {
		this.booktypeDao = booktypeDao;
	}

	@Override
	public List<BookType> getList() {
		return booktypeDao.getList();
	}

	@Override
	public void save(BookType object) {
		booktypeDao.save(object);
	}

	@Override
	public BookType update(BookType object) {
		booktypeDao.update(object);
		return getRecordbyId(object.getBooktypeid());
	}

	@Override
	public void delete(BookType object) {
		booktypeDao.delete(object);
	}

	@Override
	public BookType getRecordbyId(Long id) {
		return booktypeDao.getRecordbyId(id);
	}

	public BookTypeDao getBooktypeDao() {
		return booktypeDao;
	}

	public void setBooktypeDao(BookTypeDao booktypeDao) {
		this.booktypeDao = booktypeDao;
	}

}
