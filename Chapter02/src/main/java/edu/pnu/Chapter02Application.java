package edu.pnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// xml설정없이도 편하게 사용할 수 있게 해주는 어노테이션
@SpringBootApplication
public class Chapter02Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter02Application.class, args);
	}

}
