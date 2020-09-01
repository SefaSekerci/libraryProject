package com.angBackend.libraryProject.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.Entities.BooksInf.LentBooks;
import com.angBackend.libraryProject.Repository.Repositories.LentBookDao;
import com.angBackend.libraryProject.Service.Services.LentBookService;

@Service
public class LentBookServiceImp implements LentBookService {

	private LentBookDao lentbookDao;

	@Autowired
	public LentBookServiceImp(LentBookDao lentbookDao) {
		this.lentbookDao = lentbookDao;
	}

	@Override
	public List<LentBooks> getList() {
		return lentbookDao.getList();
	}

	@Override
	public void save(LentBooks object) {
		lentbookDao.save(object);
	}

	@Override
	public LentBooks update(LentBooks object) {
		lentbookDao.update(object);
		return getRecordbyId(object.getLentid());
	}

	@Override
	public void delete(LentBooks object) {
		lentbookDao.delete(object);
	}

	@Override
	public LentBooks getRecordbyId(Long id) {
		return lentbookDao.getRecordbyId(id);
	}

	public LentBookDao getLentbookDao() {
		return lentbookDao;
	}

	public void setLentbookDao(LentBookDao lentbookDao) {
		this.lentbookDao = lentbookDao;
	}

}
