package com.angBackend.libraryProject.Repository.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.angBackend.libraryProject.EntitySession;
import com.angBackend.libraryProject.Entities.BooksInf.BookType;
import com.angBackend.libraryProject.Entities.BooksInf.LentBooks;
import com.angBackend.libraryProject.Repository.Repositories.LentBookDao;

@Repository
public class LentBookImp implements LentBookDao {

	@Override
	@Transactional
	public void save(LentBooks object) {
		EntitySession.getSession().save(object);
	}

	@Override
	@Transactional
	public LentBooks update(LentBooks object) {
		EntitySession.getSession().update(object);
		return getRecordbyId(object.getLentid());
	}

	@Override
	@Transactional
	public void delete(LentBooks object) {
		EntitySession.getSession().delete(object);
	}

	@Override
	@Transactional
	public List<LentBooks> getList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select {b.*} from lentbooks b");
		SQLQuery query = EntitySession.getSession().createSQLQuery(sb.toString());
		query.addEntity("b", LentBooks.class);
		List<LentBooks> lentbooks = query.list();
		return lentbooks;
	}

	@Override
	@Transactional
	public LentBooks getRecordbyId(Long id) {
		return EntitySession.getSession().get(LentBooks.class, id);
	}

}
