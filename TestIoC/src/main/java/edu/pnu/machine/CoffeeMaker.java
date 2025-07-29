package edu.pnu.machine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

//스프링이 관리하는 객체(빈, Bean)**로 등록하는 애너테이션
//자동으로 ioc올라감
@Component
public class CoffeeMaker {
	// coffeemachine 에서 객체 가져옴
	//스프링이 **필요한 객체(Bean)**를 자동으로 찾아서 주입해주는 애너테이션
	//ioc컨테이너에서 들고와서 쓸 수 있음
	@Autowired
	private CoffeeMachine coffeeMachine;
	
	//스프링에서 의존성 주입(DI)이 끝난 뒤 자동으로 실행되는 메서드에 붙이는 애너테이션
	@PostConstruct
	public void makeCoffee() {
		System.out.println(coffeeMachine.brew());
	}
}
