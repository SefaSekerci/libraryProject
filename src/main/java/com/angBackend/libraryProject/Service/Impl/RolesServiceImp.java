package com.angBackend.libraryProject.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.Entities.UserInf.Roles;
import com.angBackend.libraryProject.Repository.Repositories.RolesDao;
import com.angBackend.libraryProject.Service.Services.RolesService;

@Service
public class RolesServiceImp implements RolesService {

	private RolesDao rolesDao;

	@Autowired
	public RolesServiceImp(RolesDao rolesDao) {
		this.rolesDao = rolesDao;
	}

	@Override
	public List<Roles> getList() {
		return rolesDao.getList();
	}

	@Override
	public void save(Roles object) {
		rolesDao.save(object);
	}

	@Override
	public Roles update(Roles object) {
		rolesDao.update(object);
		return getRecordbyId(object.getRoleid());
	}

	@Override
	public void delete(Roles object) {
		rolesDao.delete(object);
	}

	@Override
	public Roles getRecordbyId(Long id) {
		return rolesDao.getRecordbyId(id);
	}

	public RolesDao getRolesDao() {
		return rolesDao;
	}

	public void setRolesDao(RolesDao rolesDao) {
		this.rolesDao = rolesDao;
	}

}
