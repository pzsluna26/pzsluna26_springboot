package edu.pnu.machine;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// 오류이유 ? 커피머신중 뭘 얘기하는지 모르겟따! => primary 로 우선순위 지정

@Component
@Primary
public class DripCoffeeMachine implements CoffeeMachine {
	@Override
	public String brew() {
		return "Drip Coffee Machine에서 커피를 추출합니다.";
	}
}
