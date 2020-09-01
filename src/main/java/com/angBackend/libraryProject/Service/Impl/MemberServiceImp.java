package com.angBackend.libraryProject.Service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angBackend.libraryProject.Entities.MemberInf.Members;
import com.angBackend.libraryProject.Repository.Repositories.MemberDao;
import com.angBackend.libraryProject.Service.Services.MemberService;

@Service
public class MemberServiceImp implements MemberService {

	private MemberDao memberDao;

	@Autowired
	public MemberServiceImp(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override
	public List<Members> getList() {
		return memberDao.getList();
	}

	@Override
	public void save(Members object) {
		object.setDateCreated(new Date());
		object.setDateUpdated(new Date());
		object.setStatus(true);
		object.setCreateUserid(1L);
		memberDao.save(object);
	}

	@Override
	public Members update(Members object) {
		memberDao.update(object);
		return getRecordbyId(object.getMemberid());
	}

	@Override
	public void delete(Members object) {
		memberDao.delete(object);
	}

	@Override
	public Members getRecordbyId(Long id) {
		return memberDao.getRecordbyId(id);
	}

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
