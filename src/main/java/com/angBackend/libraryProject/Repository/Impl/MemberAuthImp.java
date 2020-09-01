package com.angBackend.libraryProject.Repository.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.angBackend.libraryProject.EntitySession;
import com.angBackend.libraryProject.Entities.MemberInf.MemberAuth;
import com.angBackend.libraryProject.Repository.Repositories.MemberAuthDao;

@Repository
public class MemberAuthImp implements MemberAuthDao {

	@Override
	@Transactional
	public void save(MemberAuth object) {
		EntitySession.getSession().save(object);
	}

	@Override
	@Transactional
	public MemberAuth update(MemberAuth object) {
		EntitySession.getSession().update(object);
		return getRecordbyId(object.getMemberauthId());
	}

	@Override
	@Transactional
	public void delete(MemberAuth object) {
		EntitySession.getSession().delete(object);
	}

	@Override
	@Transactional
	public List<MemberAuth> getList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select {b.*} from memberauth b");
		SQLQuery query = EntitySession.getSession().createSQLQuery(sb.toString());
		query.addEntity("b", MemberAuth.class);
		List<MemberAuth> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public MemberAuth getRecordbyId(Long id) {
		return EntitySession.getSession().get(MemberAuth.class, id);
	}

}
