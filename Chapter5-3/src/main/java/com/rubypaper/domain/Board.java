package com.rubypaper.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
//@ToString(exclude = "member")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
	private String content;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	
	@ToString.Exclude
	@JsonIgnore
//	@ManyToOne(fetch = FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name="mid")
	private Member member;

	public void setMember(Member member) {
		this.member = member;
		member.getBoardList().add(this);
	}
}