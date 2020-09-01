package com.angBackend.libraryProject.Repository.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.angBackend.libraryProject.EntitySession;
import com.angBackend.libraryProject.Entities.MemberInf.MemberAuth;
import com.angBackend.libraryProject.Entities.UserInf.Roles;
import com.angBackend.libraryProject.Repository.Repositories.RolesDao;

@Repository
public class RolesImp implements RolesDao {

	@Override
	@Transactional
	public void save(Roles object) {
		EntitySession.getSession().save(object);
	}

	@Override
	@Transactional
	public Roles update(Roles object) {
		EntitySession.getSession().update(object);
		return getRecordbyId(object.getRoleid());
	}

	@Override
	@Transactional
	public void delete(Roles object) {
		EntitySession.getSession().delete(object);
	}

	@Override
	@Transactional
	public List<Roles> getList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select {b.*} from roles b");
		SQLQuery query = EntitySession.getSession().createSQLQuery(sb.toString());
		query.addEntity("b", Roles.class);
		List<Roles> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public Roles getRecordbyId(Long id) {
		return EntitySession.getSession().get(Roles.class, id);
	}

}
