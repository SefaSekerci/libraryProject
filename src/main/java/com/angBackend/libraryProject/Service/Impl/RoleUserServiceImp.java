package com.angBackend.libraryProject.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.Entities.UserInf.RoleUser;
import com.angBackend.libraryProject.Repository.Repositories.RoleUserDao;
import com.angBackend.libraryProject.Service.Services.RoleUserService;

@Service
public class RoleUserServiceImp implements RoleUserService {

	private RoleUserDao roleuserDao;

	@Autowired
	public RoleUserServiceImp(RoleUserDao roleuserDao) {
		this.roleuserDao = roleuserDao;
	}

	@Override
	public List<RoleUser> getList() {
		return roleuserDao.getList();
	}

	@Override
	public void save(RoleUser object) {
		roleuserDao.save(object);
	}

	@Override
	public RoleUser update(RoleUser object) {
		roleuserDao.update(object);
		return getRecordbyId(object.getRoleuserId());
	}

	@Override
	public void delete(RoleUser object) {
		roleuserDao.delete(object);
	}

	@Override
	public RoleUser getRecordbyId(Long id) {
		return roleuserDao.getRecordbyId(id);
	}

	public RoleUserDao getRoleuserDao() {
		return roleuserDao;
	}

	public void setRoleuserDao(RoleUserDao roleuserDao) {
		this.roleuserDao = roleuserDao;
	}

}
