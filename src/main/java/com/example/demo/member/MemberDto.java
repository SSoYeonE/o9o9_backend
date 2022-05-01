package com.example.demo.member;

import java.io.File;
import java.sql.Date;

import com.example.demo.common.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)		//�⺻������ ����
@ToString
public class MemberDto extends BaseDto{

	private String user_seq = "";		//�����ĺ���ȣ
	private String user_id = "";		//���̵�
	private String user_password = "";	//���
	private String user_name= "";		//�̸�
	private String user_image1="";			//����� �̹���
	private String user_image2="";			//����� ��� �̹���
	private String user_address1="";	//�� �ּ�1
	private String user_address2="";	//�� �ּ�2
	private String user_mail="";		//�̸���
	private String user_phone="";		//�� �ѹ�
	private Date user_wdate;			//���Գ���
	private String user_active;			//����� Ȱ������
	private String user_level="";		//����� ���
	private String user_business="";	//����� �����
	private String user_birth="";
	private String user_pending="";
	private String profile_short="";
	
	
	
	
	@Builder
	public MemberDto(String user_seq, String user_id, String user_password, String user_name, String user_image1,
			String user_image2, String user_address1, String user_address2, String user_mail, String user_phone,
			Date user_wdate, String user_active, String user_level, String user_business, String user_birth, String user_pending) {
		this.user_seq = user_seq;
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_image1 = user_image1;
		this.user_image2 = user_image2;
		this.user_address1 = user_address1;
		this.user_address2 = user_address2;
		this.user_mail = user_mail;
		this.user_phone = user_phone;
		this.user_wdate = user_wdate;
		this.user_active = user_active;
		this.user_level = user_level;
		this.user_business = user_business;
		this.user_birth = user_birth;
		this.user_pending = user_pending;
	}
	
	
	
}