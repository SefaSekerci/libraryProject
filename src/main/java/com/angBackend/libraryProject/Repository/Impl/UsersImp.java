package com.angBackend.libraryProject.Repository.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.angBackend.libraryProject.EntitySession;
import com.angBackend.libraryProject.Entities.UserInf.Users;
import com.angBackend.libraryProject.Repository.Repositories.UsersDao;

@Repository
public class UsersImp implements UsersDao {

	@Override
	@Transactional
	public void save(Users object) {
		EntitySession.getSession().save(object);
	}

	@Override
	@Transactional
	public Users update(Users object) {
		EntitySession.getSession().update(object);
		return getRecordbyId(object.getUserid());
	}

	@Override
	@Transactional
	public void delete(Users object) {
		EntitySession.getSession().delete(object);
	}

	@Override
	@Transactional
	public List<Users> getList() {
		StringBuilder sb = new StringBuilder();
		sb.append("select {b.*} from users b");
		SQLQuery query = EntitySession.getSession().createSQLQuery(sb.toString());
		query.addEntity("b", Users.class);
		List<Users> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public Users getRecordbyId(Long id) {
		return EntitySession.getSession().get(Users.class, id);
	}
	
//	public Users getRecordbyIasdd(Long id) {
//
////		Query query = session.createQuery("select m.name as employeeName, m.department.name as departmentName"
////				  + " from com.baeldung.hibernate.entities.DeptEmployee m");
////				query.setResultTransformer(Transformers.aliasToBean(Result.class));
////				List<Result> results = query.list();
////				Result result = results.get(0);
////				assertEquals("John Smith", result.getEmployeeName());
////				assertEquals("Sales", result.getDepartmentName());
//		
//		return EntitySession.getSession().get(Users.class, id);
//	}

}
