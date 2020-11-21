package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public MemberDto findUserInfo(String id) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.findUserInfo(id);
	}
	
	@Override
	public MemberDto login(MemberDto dto) throws SQLException {

		return loginDao.login(dto);
	}

	@Override
	public boolean join(MemberDto dto) throws SQLException {
		if (dto.getId() == null || dto.getPwd() == null || dto.getName() == null 
				|| dto.getAddr() == null || dto.getTel() == null)
			return false;

		return loginDao.join(dto);
	}

	@Override
	public boolean delete(String id) throws Exception {
		return loginDao.delete(id);
	}

	@Override
	public boolean update(MemberDto memberDto) throws Exception {
		if (memberDto == null)
			return false;
		
		return loginDao.update(memberDto);
	}

	@Override
	public String findPwd(String id) throws Exception {
		return loginDao.findPwd(id);
	}
	
	@Override
	public List<MemberDto> findAllUserInfo() throws Exception {
		// TODO Auto-generated method stub
		return loginDao.findAllUserInfo();
	}
}
