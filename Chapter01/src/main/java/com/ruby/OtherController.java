package com.ruby;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

//패키지가 다르기 때문에 other안뜸
@Controller
public class OtherController {
	
	public OtherController() {
		System.out.println("===> OtherController 생성");
	}

}
