package com.example.demo.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.example.demo.common.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;

@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)
@ToString


public class ProfileDto extends BaseDto {
	
	private long profile_seq = -1;
	private long user_seq = -1;
	private String user_name = "";
	private String user_phone = "";
	private String user_birth = "";
	private String user_mail = "";
	private String user_image1 = "";
	private String profile_short = "";
	private String profile_degree1 = "";
	private String profile_degree2 = "";
	private String profile_career = "";
	private String profile_certificate = "";
	private String profile_skill = "";
	private String profile_filename1 = "";
	private String profile_filename2 = "";
	private String profile_filename3 = "";
	private String profile_introduction = "";
	
	@Builder
	public ProfileDto(long profile_seq, long user_seq, String user_name, String user_phone, String user_birth,
			String user_mail, String profile_short, String profile_degree1, String profile_degree2,
			String profile_career, String profile_certificate, String profile_skill, String profile_filename1,
			String profile_filename2, String profile_filename3, String profile_introduction) {
		super();
		this.profile_seq = profile_seq;
		this.user_seq = user_seq;
		this.user_name = user_name;
		this.user_phone = user_phone;
		this.user_birth = user_birth;
		this.user_mail = user_mail;
		this.profile_short = profile_short;
		this.profile_degree1 = profile_degree1;
		this.profile_degree2 = profile_degree2;
		this.profile_career = profile_career;
		this.profile_certificate = profile_certificate;
		this.profile_skill = profile_skill;
		this.profile_filename1 = profile_filename1;
		this.profile_filename2 = profile_filename2;
		this.profile_filename3 = profile_filename3;
		this.profile_introduction = profile_introduction;
	}
	

	
}
