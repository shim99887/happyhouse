package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;


	@Override
	public MemberDto login(Map<String, String> map) throws SQLException {
		if (map.get("id") == null || map.get("pwd") == null)
			return null;

		return loginDao.login(map);
	}

	@Override
	public boolean join(MemberDto dto) throws SQLException {
		if (dto.getId() == null || dto.getPwd() == null || dto.getName() == null 
				|| dto.getAddr() == null || dto.getTel() == null)
			return false;

		return loginDao.join(dto);
	}

	@Override
	public boolean delete(MemberDto memberDto) throws Exception {
		if (memberDto == null)
			return false;
		
		return loginDao.delete(memberDto);
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
}
