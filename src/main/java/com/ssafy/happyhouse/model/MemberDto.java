package com.ssafy.happyhouse.model;

public class MemberDto {

	private String no;
	private String id;
	private String pwd;
	private String name;
	private String addr;
	private String tel;
	private String joindate;
	private String email;
	private String role;
	
	
	
	
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	
	public String getJoindate() {
		return joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	@Override
	public String toString() {
		return "MemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", addr=" + addr + ", tel=" + tel + "]";
	}
	
	

}
