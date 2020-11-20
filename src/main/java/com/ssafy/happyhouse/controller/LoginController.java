package com.ssafy.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.MemberDto;
import com.ssafy.happyhouse.model.service.LoginService;

/**
 * Servlet implementation class AuthController
 */
@Controller
@RestController
@RequestMapping("/user")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	private LoginService loginService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	
	@PostMapping("/regist")
	public ResponseEntity<Boolean> regist(@RequestBody Map<String, String> map) {
		System.out.println(map);
		HttpStatus status = HttpStatus.ACCEPTED;
		MemberDto dto = new MemberDto();
		dto.setId(map.get("id"));
		dto.setAddr(map.get("addr"));
		dto.setTel(map.get("tel"));
		dto.setEmail(map.get("email"));
		dto.setPwd(map.get("pwd"));
		dto.setJoindate(map.get("joindate"));
		dto.setName(map.get("name"));
		System.out.println(dto);
		boolean flag = false;
		
		try {
			flag = loginService.join(dto);
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		
		return new ResponseEntity<Boolean>(flag, status);
	}

	
	@PostMapping("/findpwd")
	public String findpwd(@RequestParam Map<String, String> map, Model model) {
		System.out.println(map);
		try {
			model.addAttribute("msg", loginService.findPwd(map.get("id")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "비밀번호 찾기 중 오류가 발생했습니다.");
		}
		return "index";
		
	}
	
	/**

	/**
	 * 로그아웃 요청(logout.do)을 처리하는 메소드
	*/
}
