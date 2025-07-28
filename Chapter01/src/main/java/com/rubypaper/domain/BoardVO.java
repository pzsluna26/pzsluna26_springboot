package com.rubypaper.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString 
@AllArgsConstructor //필드들을 파라미터로 가지는 생성자 생성
@NoArgsConstructor //기본생성자 생성
@Builder
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	@Builder.Default //필드에 기본값을 유지하고 싶을 때 사용
	private Date createDate = new Date();
	private int cnt;
	

}
