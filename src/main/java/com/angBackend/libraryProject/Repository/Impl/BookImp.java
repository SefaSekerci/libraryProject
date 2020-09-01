package com.angBackend.libraryProject.Repository.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.angBackend.libraryProject.EntitySession;
import com.angBackend.libraryProject.Entities.BooksInf.Books;
import com.angBackend.libraryProject.Repository.Repositories.BookDao;

@Repository
public class BookImp implements BookDao {

	@Override
	@Transactional
	public void save(Books object) {
		EntitySession.getSession().save(object);
	}

	@Override
	@Transactional
	public Books update(Books object) {
		EntitySession.getSession().update(object);
		return getRecordbyId(object.getBookid());
	}

	@Override
	@Transactional
	public void delete(Books object) {
		EntitySession.getSession().delete(object);
	}

	@Override
	@Transactional
	public List<Books> getList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select {b.*} from books b");
		SQLQuery query = EntitySession.getSession().createSQLQuery(sb.toString());
		query.addEntity("b", Books.class);
		List<Books> books = query.list();
		return books;
	}

	@Override
	@Transactional
	public Books getRecordbyId(Long id) {
		return EntitySession.getSession().get(Books.class, id);
	}

}
