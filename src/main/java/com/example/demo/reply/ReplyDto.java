package com.example.demo.reply;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC) //�⺻�����ڸ� ������ش�
@AllArgsConstructor
@ToString
public class ReplyDto{
	private String reply_seq="";
	private String mboard_seq="";
	private String user_seq="";

	
	
}
