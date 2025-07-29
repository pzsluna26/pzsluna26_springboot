package edu.pnu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rubypaper.jdbc.util.JDBCConnectionManager;

//@Configuration
public class BoardConfiguration {
	// 충돌오류(사용자정의 객체 & 자동설정빈객체) : 이미등록된 객체
	// 오류해결 :board-spring-boot-starter 의 BoardAutoConfiguration 에 @conditionalOnMissingbean 으로 해결
//	@Bean
	JDBCConnectionManager getJDBCConnectionManager() {
	JDBCConnectionManager manager = new JDBCConnectionManager();
	manager.setDriverClass("org.h2.Driver");
	manager.setUrl("jdbc:h2:tcp://localhost/~/test");
	manager.setUsername("sa");
	manager.setPassword("");
	return manager;
	}
}
