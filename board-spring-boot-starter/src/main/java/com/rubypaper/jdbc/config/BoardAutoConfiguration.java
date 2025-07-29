package com.rubypaper.jdbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rubypaper.jdbc.util.JDBCConnectionManager;

//@Configuration
//public class BoardAutoConfiguration {
//	
//	@Bean
//	@ConditionalOnMissingBean //만약에 이타입의 객체가 존재하지않으면 이걸 만들어서 ioc컨테이너에 올려라
//	JDBCConnectionManager getJDBCConnectionManager() {
//		JDBCConnectionManager manager = new JDBCConnectionManager();
//		manager.setDriverClass("com.mysql.cj.jdbc.Drvier");
//		manager.setUrl("jdbc:mysql://localhost:3306/boot");
//		manager.setUsername("scott");
//		manager.setPassword("tiger");
//		return manager;
//	}
//}

@Configuration
@EnableConfigurationProperties(JDBCConnectionManagerProperties.class)
public class BoardAutoConfiguration {
	@Autowired
	private JDBCConnectionManagerProperties properties;

	@Bean
	@ConditionalOnMissingBean
	public JDBCConnectionManager getJDBCConnectionManager() {
		JDBCConnectionManager manager = new JDBCConnectionManager();
		manager.setDriverClass(properties.getDriverClass());
		manager.setUrl(properties.getUrl());
		manager.setUsername(properties.getUsername());
		manager.setPassword(properties.getPassword());
		return manager;
	}
}
