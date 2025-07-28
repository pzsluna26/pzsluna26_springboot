package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//메인클레스의 어노테이션 @SpringBootApplication 이거 덕분에 스캔대상인 아이들 사용가능
@SpringBootApplication

//@ComponentScan => 이제 otherController 콘솔에 출력됨
@ComponentScan(basePackages= {"com.rubypaper", "com.ruby"})
public class Chapter01Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter01Application.class, args);
	}

}
