package com.example.demo.like;

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
public class LikeDto {
	private String mboard_seq="";
	private String user_seq="";
	private String like_seq="";
	private String emoji="";
}
