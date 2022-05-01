package com.example.demo.mainboard;

import com.example.demo.common.BaseDto;

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
public class MainboardDto extends BaseDto{
	private String mboard_seq="";
	private String user_seq="";
	private String user_image1="";
	private String user_name="";
	private String wdate="";
	private String contents="";
	private String contents_url="";
	private String view_yn ="";
	private String hashtag="";
	private String posting_type="";
	private String del_yn="";
	private String like_seq="";
	
	private String jobposting_seq="";
	private String start_date ="";
	private String end_date ="";
	private String company_name	 ="";
	private String work_area ="";	
	private String work_field ="";	
	private String work_condition ="";
	
	
}
