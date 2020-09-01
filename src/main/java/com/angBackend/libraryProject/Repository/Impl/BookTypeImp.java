package com.angBackend.libraryProject.Repository.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.angBackend.libraryProject.EntitySession;
import com.angBackend.libraryProject.Entities.BooksInf.BookType;
import com.angBackend.libraryProject.Repository.Repositories.BookTypeDao;

@Repository
public class BookTypeImp implements BookTypeDao {

	@Override
	@Transactional
	public void save(BookType object) {
		EntitySession.getSession().save(object);
	}

	@Override
	@Transactional
	public BookType update(BookType object) {
		EntitySession.getSession().update(object);
		return getRecordbyId(object.getBooktypeid());
	}

	@Override
	@Transactional
	public void delete(BookType object) {
		EntitySession.getSession().delete(object);
	}

	@Override
	@Transactional
	public List<BookType> getList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select {b.*} from booktype b");
		SQLQuery query = EntitySession.getSession().createSQLQuery(sb.toString());
		query.addEntity("b", BookType.class);
		List<BookType> booktypes = query.list();
		return booktypes;
	}

	@Override
	@Transactional
	public BookType getRecordbyId(Long id) {
		return EntitySession.getSession().get(BookType.class, id);
	}

}
