package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.MemberDto;

public interface LoginService {

	/** id, pwd와 일치하는 MemberDto를 반환 */
	public MemberDto login(MemberDto dto) throws Exception;

	/** 인자로 MemberDto를 생성하고, 생성 여부를 반환 */
	public boolean join(MemberDto dto) throws Exception;

	/** 인자로 받은 MemberDto를 삭제하고, 성공 여부를 반환 */
	public boolean delete(String id) throws Exception;
	
	/** 인자로 받은 MemberDto를 수정하고, 성공 여부를 반환 */
	public boolean update(MemberDto memberDto) throws Exception;

	public String findPwd(String id) throws Exception;
	
	public MemberDto findUserInfo(String id) throws Exception;
	
	public List<MemberDto>findAllUserInfo() throws Exception;
}
