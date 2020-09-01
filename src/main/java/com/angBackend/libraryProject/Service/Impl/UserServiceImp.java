package com.angBackend.libraryProject.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.Entities.UserInf.Users;
import com.angBackend.libraryProject.Repository.Repositories.UsersDao;
import com.angBackend.libraryProject.Service.Services.UserService;

@Service
public class UserServiceImp implements UserService {

	private UsersDao userDao;

	@Autowired
	public UserServiceImp(UsersDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Users> getList() {
		return userDao.getList();
	}

	@Override
	public void save(Users object) {
		userDao.save(object);
	}

	@Override
	public Users update(Users object) {
		userDao.update(object);
		return getRecordbyId(object.getUserid());
	}

	@Override
	public void delete(Users object) {
		userDao.delete(object);
	}

	@Override
	public Users getRecordbyId(Long id) {
		return userDao.getRecordbyId(id);
	}

	public UsersDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UsersDao userDao) {
		this.userDao = userDao;
	}

}
