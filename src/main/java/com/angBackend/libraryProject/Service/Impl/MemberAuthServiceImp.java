package com.angBackend.libraryProject.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.Entities.MemberInf.MemberAuth;
import com.angBackend.libraryProject.Repository.Repositories.MemberAuthDao;
import com.angBackend.libraryProject.Service.Services.MemberAuthService;

@Service
public class MemberAuthServiceImp implements MemberAuthService {

	private MemberAuthDao memberAuthDao;

	@Autowired
	public MemberAuthServiceImp(MemberAuthDao memberAuthDao) {
		this.memberAuthDao = memberAuthDao;
	}

	@Override
	public List<MemberAuth> getList() {
		return memberAuthDao.getList();
	}

	@Override
	public void save(MemberAuth object) {
		memberAuthDao.save(object);
	}

	@Override
	public MemberAuth update(MemberAuth object) {
		memberAuthDao.update(object);
		return getRecordbyId(object.getMemberauthId());
	}

	@Override
	public void delete(MemberAuth object) {
		memberAuthDao.delete(object);
	}

	@Override
	public MemberAuth getRecordbyId(Long id) {
		return memberAuthDao.getRecordbyId(id);
	}

	public MemberAuthDao getMemberAuthDao() {
		return memberAuthDao;
	}

	public void setMemberAuthDao(MemberAuthDao memberAuthDao) {
		this.memberAuthDao = memberAuthDao;
	}

}
