package com.ssafy.happyhouse.model.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.MemberDto;

@Mapper
public interface LoginDao {
	
	/** id, pwd와 일치하는 MemberDto를 반환 */
	public MemberDto login(MemberDto dto) throws SQLException;
	
	/** 인자로 MemberDto를 생성하고, 생성 여부를 반환 */
	public boolean join(MemberDto memberDto) throws SQLException;
	
	/** 인자로 받은 MemberDto를 삭제하고, 성공 여부를 반환 */
	public boolean delete(MemberDto memberDto) throws SQLException;
	
	/** 인자로 받은 MemberDto를 수정하고, 성공 여부를 반환 */
	public boolean update(MemberDto memberDto) throws SQLException;
	
	public String findPwd(String id) throws SQLException;
	
	public MemberDto findUserInfo(String id) throws SQLException;
}
