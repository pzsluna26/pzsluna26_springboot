package com.rubypaper.controller;
import com.rubypaper.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rubypaper.domain.Member;

//로그인 처리를 위한 view 반환
@Controller
public class LoginController {

    private final MemberService memberService;

    LoginController(MemberService memberService) {
        this.memberService = memberService;
    }

	@GetMapping("/login")
	public void login() {
	}
	
	@GetMapping("/loginSuccess")
	public void loginSuccess() {
		System.out.println("loginSuccess요청");
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
		System.out.println("accessDenied");
	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	
	@PostMapping("/join")
	public String joinProc(Member member) {
		memberService.save(member);
		return "/welcome";
	}
}
