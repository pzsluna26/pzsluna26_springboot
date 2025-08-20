package com.rubypaper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//보안처리를 위해서 사용할 객체를 만들어놓고 스프링컨테이너에 저장

@Configuration
public class SecurityConfig {
	
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	//로그인을 강제하지 않음
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//CSRF 보호 기능을 off
		http.csrf(csrf->csrf.disable());
		
		//로그인 되어야 접근 가능
		http.authorizeHttpRequests(security->security
				//member로 시작하는 모든 URL 
				.requestMatchers("/member/**").authenticated()
				//manager로 시작하는 모든 URL에 MANAGER, ADMIN 권한을 가진 사용자만 접근 가능
				.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
				//admin이하 모든 URL에 ADMIN만 접근 가능
				.requestMatchers("/admin/**").hasRole("ADMIN")
				//그외는 모두 허용
				.anyRequest().permitAll());
		
		//로그인창 생성
		http.formLogin(login->login.loginPage("/login").defaultSuccessUrl("/loginSuccess"));
		
		//페이지 오류처리
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
		
		//로그아웃 처리
		http.logout(logout->logout.invalidateHttpSession(true).deleteCookies("JSESSIONID").logoutSuccessUrl("/login"));
		return http.build();
	}
}
