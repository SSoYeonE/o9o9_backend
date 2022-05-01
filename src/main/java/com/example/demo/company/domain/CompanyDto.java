package com.example.demo.company.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.example.demo.common.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;
   
@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)  //기본생성자를 만들어준다 
@ToString
public class CompanyDto extends BaseDto{
	    
	private long seq=-1;
	private String srt="";//한줄소개글
	private String size=""; //회사규모
	private String day=""; //회사 창립일
	private int people=0; //사원수
	private String intro = "";//회사 소개글
	private String date = ""; //최종 수정시간
	private String name = ""; //회사 이름
	private String address1 = "";//user db
	private String address2 = "";//user db
	private String mail = "";//user db
	private String phone = "";//user db
	private String image1 = "";//user db
	private String image2 = "";//user db
	private String business = "";//user db
	private long user_seq = -1; //사용자 고유식별값
	
	@Builder
	public CompanyDto(long seq, String srt, String size, String day, int people, String intro, String date, String name,
			String address1, String address2, String mail, String phone, String image1, String image2, String business,
			long user_seq) {
		super();
		this.seq = seq;
		this.srt = srt;
		this.size = size;
		this.day = day;
		this.people = people;
		this.intro = intro;
		this.date = date;
		this.name = name;
		this.address1 = address1;
		this.address2 = address2;
		this.mail = mail;
		this.phone = phone;
		this.image1 = image1;
		this.image2 = image2;
		this.business = business;
		this.user_seq = user_seq;
	}
	
	
	
}
