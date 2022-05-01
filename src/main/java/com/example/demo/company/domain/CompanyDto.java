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
@NoArgsConstructor(access=AccessLevel.PUBLIC)  //�⺻�����ڸ� ������ش� 
@ToString
public class CompanyDto extends BaseDto{
	    
	private long seq=-1;
	private String srt="";//���ټҰ���
	private String size=""; //ȸ��Ը�
	private String day=""; //ȸ�� â����
	private int people=0; //�����
	private String intro = "";//ȸ�� �Ұ���
	private String date = ""; //���� �����ð�
	private String name = ""; //ȸ�� �̸�
	private String address1 = "";//user db
	private String address2 = "";//user db
	private String mail = "";//user db
	private String phone = "";//user db
	private String image1 = "";//user db
	private String image2 = "";//user db
	private String business = "";//user db
	private long user_seq = -1; //����� �����ĺ���
	
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
