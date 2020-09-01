package com.angBackend.libraryProject.Repository.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.angBackend.libraryProject.EntitySession;
import com.angBackend.libraryProject.Entities.UserInf.RoleUser;
import com.angBackend.libraryProject.Entities.UserInf.UserAuth;
import com.angBackend.libraryProject.Repository.Repositories.UserAuthDao;

@Repository
public class UserAuthImp implements UserAuthDao {

	@Override
	@Transactional
	public void save(UserAuth object) {
		EntitySession.getSession().save(object);
	}

	@Override
	@Transactional
	public UserAuth update(UserAuth object) {
		EntitySession.getSession().update(object);
		return getRecordbyId(object.getUserauthId());
	}

	@Override
	@Transactional
	public void delete(UserAuth object) {
		EntitySession.getSession().delete(object);
	}

	@Override
	@Transactional
	public List<UserAuth> getList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select {b.*} from userauth b");
		SQLQuery query = EntitySession.getSession().createSQLQuery(sb.toString());
		query.addEntity("b", UserAuth.class);
		List<UserAuth> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public UserAuth getRecordbyId(Long id) {
		return EntitySession.getSession().get(UserAuth.class, id);
	}

}
