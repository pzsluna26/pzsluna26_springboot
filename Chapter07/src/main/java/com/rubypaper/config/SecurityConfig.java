package com.rubypaper.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(security->security
				.requestMatchers("/member/**").authenticated()
				.requestMatchers("/manager/**").hasAnyRole("MANAGER","ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll());
		http.csrf(cf->cf.disable());
		http.formLogin(form->{});
		
		//로그인에 사용할 url과 성공시 이동할 url 설정
		http.formLogin(form->form
						.loginPage("/login")
						.defaultSuccessUrl("/loginSuccess",true));
		
		//접근 권한 없음 페이지 처리
		http.exceptionHandling(ex->ex.accessDeniedPage("/accessDenied"));
		
		//로그아웃
		http.logout(logout->logout
				//현재 브라우저와 연결된 세션 강제 종료(삭제)
				.invalidateHttpSession(true)
				//세션 아이디가 저장된 쿠키 삭제
				.deleteCookies("JSESSIONID")
				//로그아웃 후 이동할 URL 지정
				.logoutSuccessUrl("/login"));
				
		return http.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
//	@Autowired
//	private DataSource dataSource;
//	
//	@Autowired
//	public void authentiate(AuthenticationManagerBuilder auth) throws Exception{
//		//1.(메모리)사용자 등록하기
//		auth.inMemoryAuthentication().withUser("member").password("{noop}abcd").roles("MEMBER");
//		auth.inMemoryAuthentication().withUser("manager").password("{noop}abcd").roles("MANAGER");		
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}abcd").roles("ADMIN");
//		
//		//2.(h2-데이터베이스)사용자 등록하기
//		String query1 = "select id username, concat('{noop}',password) password, true enabled from member where id=?";
//		String query2 = "select id, role from member where id=?";
//		auth.jdbcAuthentication().dataSource(dataSource)
//								.usersByUsernameQuery(query1) //username이라는 query날려라
//								.authoritiesByUsernameQuery(query2); //접근권한 query날려라
//	}
}
