package com.example.demo.cand.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.example.demo.common.BaseDto;

import lombok.AccessLevel;
import lombok.Builder;
   
@Setter
@Getter
@NoArgsConstructor(access=AccessLevel.PUBLIC)  //기본생성자를 만들어준다 
public class CandDto extends BaseDto{
	    
	private long cand_seq = 0;	
	private long jobposting_seq = 0;	
	private long user_seq = 0;	
	private String cand_date = "";	
	private long com_seq = 0;
	private String cand_confirm = "";
	
	
	@Builder
	public CandDto(long cand_seq, long jobposting_seq, long user_seq, String cand_date, long com_seq,
			String cand_confirm) {
		super();
		this.cand_seq = cand_seq;
		this.jobposting_seq = jobposting_seq; //공거글
		this.user_seq = user_seq; //지원자
		this.cand_date = cand_date; //지원날짜
		this.com_seq = com_seq; //지원한 회사
		this.cand_confirm = cand_confirm;//합격여부
	}	
	
	
	
}
