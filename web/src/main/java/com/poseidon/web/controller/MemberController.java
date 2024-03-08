package com.poseidon.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poseidon.web.service.MemberService;
import com.poseidon.web.util.Util;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	Util util;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login2(@RequestParam Map<String, Object> map) {
		System.out.println(map);
		Map<String, Object> result = memberService.login(map);
		System.out.println(result);
		System.out.println(result.get("count"));
		
		Object countObject = result.get("count");
		
		if (countObject instanceof Integer) {
			System.out.println("Integer입니다.");
		} else if (countObject instanceof String) {
			System.out.println("String입니다.");
		} else if (String.valueOf(countObject) instanceof String) {
			System.out.println("String으로 형변환 하였습니다.");
		} else {
			System.out.println("둘 다 아닙니다.");
		}
		
		
		
		//자바 17에 추가된 기능
		String txt = """
				텍스트
				텍스트
				텍스트
				"""; //텍스트 블럭
		
		int key = 10;
		String res =  switch (key) {
		case 1, 2 -> "조건 걸립니다.";
			
		default -> "기본입니다.";

		};
		
		
		
		
		if (util.str2Int(String.valueOf(countObject)) == 1) {
			//로그인 성공한다면
			// 세션에 id랑 닉네임 넣는다. 
			// board로 이동
			
			System.out.println("로그인에 성공했습니다.");
			
			HttpSession session = util.getSession();
			session.setAttribute("mid", map.get("id"));
			session.setAttribute("mname", result.get("mname"));
			return "redirect:/freeboard";
			
		} else {
			//로그인 불가 -> 다시 로그인 화면으로 
			return "redirect:/login";
		}
		
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("mid") != null ) {
			session.removeAttribute("mid");
		}
		if(session.getAttribute("mname") != null) {
			session.removeAttribute("mname");
		}
		session.invalidate();
		
		return "redirect:/login";
	}
	

		
	
}
