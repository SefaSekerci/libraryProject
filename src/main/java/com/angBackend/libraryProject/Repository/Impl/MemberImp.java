package com.angBackend.libraryProject.Repository.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.EntitySession;
import com.angBackend.libraryProject.Entities.MemberInf.Members;
import com.angBackend.libraryProject.Repository.Repositories.MemberDao;

@Service
public class MemberImp implements MemberDao {

	@Override
	@Transactional
	public void save(Members object) {
		EntitySession.getSession().save(object);
	}

	@Override
	@Transactional
	public Members update(Members object) {
		EntitySession.getSession().update(object);
		return getRecordbyId(object.getMemberid());
	}

	@Override
	@Transactional
	public void delete(Members object) {
		EntitySession.getSession().delete(object);
	}

	@Override
	@Transactional
	public List<Members> getList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select {b.*} from members b");
		SQLQuery query = EntitySession.getSession().createSQLQuery(sb.toString());
		query.addEntity("b", Members.class);
		List<Members> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public Members getRecordbyId(Long id) {
		return EntitySession.getSession().get(Members.class, id);
	}

}
