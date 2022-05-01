package com.example.demo.sideprofile;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC) //기본생성자를 만들어준다
@AllArgsConstructor
@ToString
public class SideprofileDto {
	public String user_seq="";
	public String user_image1 ="";
	public String user_image2 ="";
	public String profile_short ="";
	public String user_name="";
}
