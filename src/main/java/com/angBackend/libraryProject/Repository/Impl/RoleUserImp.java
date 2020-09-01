package com.angBackend.libraryProject.Repository.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.angBackend.libraryProject.EntitySession;
import com.angBackend.libraryProject.Entities.UserInf.RoleUser;
import com.angBackend.libraryProject.Entities.UserInf.Roles;
import com.angBackend.libraryProject.Repository.Repositories.RoleUserDao;

@Repository
public class RoleUserImp implements RoleUserDao {

	@Override
	@Transactional
	public void save(RoleUser object) {
		EntitySession.getSession().save(object);
	}

	@Override
	@Transactional
	public RoleUser update(RoleUser object) {
		EntitySession.getSession().update(object);
		return getRecordbyId(object.getRoleuserId());
	}

	@Override
	@Transactional
	public void delete(RoleUser object) {
		EntitySession.getSession().delete(object);
	}

	@Override
	@Transactional
	public List<RoleUser> getList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select {b.*} from roleuser b");
		SQLQuery query = EntitySession.getSession().createSQLQuery(sb.toString());
		query.addEntity("b", RoleUser.class);
		List<RoleUser> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public RoleUser getRecordbyId(Long id) {
		return EntitySession.getSession().get(RoleUser.class, id);
	}

}
