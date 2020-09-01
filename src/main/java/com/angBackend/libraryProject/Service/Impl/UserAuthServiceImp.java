package com.angBackend.libraryProject.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.Entities.UserInf.UserAuth;
import com.angBackend.libraryProject.Repository.Repositories.UserAuthDao;
import com.angBackend.libraryProject.Service.Services.UserAuthService;

@Service
public class UserAuthServiceImp implements UserAuthService {

	private UserAuthDao userauthDao;

	@Autowired
	public UserAuthServiceImp(UserAuthDao userauthDao) {
		this.userauthDao = userauthDao;
	}

	@Override
	public List<UserAuth> getList() {
		return userauthDao.getList();
	}

	@Override
	public void save(UserAuth object) {
		userauthDao.save(object);
	}

	@Override
	public UserAuth update(UserAuth object) {
		userauthDao.update(object);
		return getRecordbyId(object.getUserauthId());
	}

	@Override
	public void delete(UserAuth object) {
		userauthDao.delete(object);
	}

	@Override
	public UserAuth getRecordbyId(Long id) {
		return userauthDao.getRecordbyId(id);
	}

	public UserAuthDao getUserauthDao() {
		return userauthDao;
	}

	public void setUserauthDao(UserAuthDao userauthDao) {
		this.userauthDao = userauthDao;
	}

}
