package com.example.demo.jobposting;

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
public class JobpostingDto {
	private String jobposting_seq="";
	private String mboard_seq ="";
	private String start_date ="";
	private String end_date ="";
	private String company_name	 ="";
	private String work_area ="";	
	private String work_field ="";	
	private String work_condition ="";
}
