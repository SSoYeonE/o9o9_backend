package com.example.demo.reply;

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
public class ReplyDto{
	private String reply_seq="";
	private String mboard_seq="";
	private String user_seq="";
	private String user_image1="";
	private String user_name="";
	private String reply="";
	private String rdate="";
	
	
}
