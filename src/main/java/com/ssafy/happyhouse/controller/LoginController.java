//package com.ssafy.happyhouse.controller;
//
//import java.util.Map;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.ssafy.happyhouse.model.MemberDto;
//import com.ssafy.happyhouse.model.service.LoginService;
//
///**
// * Servlet implementation class AuthController
// */
//@Controller
//public class LoginController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	@Autowired
//	private LoginService loginService;
//
//	/**
//	 * @see HttpServlet#HttpServlet()
//	 */
//	public LoginController() {
//		super();
//	}
//
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session, HttpServletResponse response) {
//		try {
//			System.out.println(map);
//			MemberDto memberDto = loginService.login(map);
//			if(memberDto != null) {
//				session.setAttribute("userinfo", memberDto);
//				
//				Cookie cookie = new Cookie("ssafy_id", memberDto.getId());
//				cookie.setPath("/");
//				if("saveok".equals(map.get("idsave"))) {
//					cookie.setMaxAge(60 * 60 * 24 * 365 * 40);//40년간 저장.
//				} else {
//					cookie.setMaxAge(0);
//				}
//				response.addCookie(cookie);
//				
//			} else {
//				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 로그인해 주세요.");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
//			return "error/error";
//		}
//		return "index";
//	}
//	
//	@PostMapping("/join")
//	public String join(@RequestParam Map<String, String> map, Model model){
//		System.out.println(map);
//		MemberDto member = new MemberDto();
//		member.setId(map.get("id").toString());
//		member.setPwd(map.get("pwd").toString());
//		member.setName(map.get("name").toString());
//		member.setTel(map.get("tel").toString());
//		member.setAddr(map.get("addr").toString());
//		System.out.println(member);
//		try {
//			loginService.join(member);
//		} catch (Exception e) {
//			e.printStackTrace();
//			System.out.println("문제 발생");
//			model.addAttribute("msg", "회원가입 중 문제가 발생했습니다.");
//			return "error/error";
//		}
//		System.out.println("잘 넘어옴");
//		return "redirect:/";
//	}
//	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		session.removeAttribute("userinfo");
//		return "redirect:/";
//	}
//	
//	@GetMapping("/mypage")
//	public String myPage() {
//		return "member-info";
//	}
//	
//	@GetMapping("/modifyForm")
//	public String modifyForm() {
//		return "member-info-modify";
//	}
//	
//	@PostMapping("/update")
//	public String modify(@RequestParam Map<String, String> map, Model model, HttpSession session) {
//		
//		System.out.println(map);
//		
//		MemberDto member = new MemberDto();
//		member.setId(map.get("id").toString());
//		member.setPwd(map.get("pwd").toString());
//		member.setName(map.get("name").toString());
//		member.setTel(map.get("tel").toString());
//		member.setAddr(map.get("addr").toString());
//		
//		try {
//			loginService.update(member);
//			MemberDto memberDto = loginService.login(map);
//			session.setAttribute("userinfo", memberDto);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			model.addAttribute("msg", "회원정보 수정 중 문제가 발생했습니다.");
//			return "error/error";
//		}
//		
//		
//		return "redirect:/mypage";
//	}
//	
//	@PostMapping("/delete")
//	public String delete(HttpSession session, Model model) {
//		
//		System.out.println(session.getAttribute("userinfo"));
//		
//		try {
//			loginService.delete((MemberDto)session.getAttribute("userinfo"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			model.addAttribute("msg", "회원 탈퇴 중 오류가 발생했습니다");
//			
//		}
//		session.removeAttribute("userinfo");
//		return "redirect:/";
//	}
//	
//	@PostMapping("/findpwd")
//	public String findpwd(@RequestParam Map<String, String> map, Model model) {
//		System.out.println(map);
//		try {
//			model.addAttribute("msg", loginService.findPwd(map.get("id")));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			model.addAttribute("msg", "비밀번호 찾기 중 오류가 발생했습니다.");
//		}
//		return "index";
//		
//	}
//	
//	/**
//
//	/**
//	 * 로그아웃 요청(logout.do)을 처리하는 메소드
//	*/
//}
