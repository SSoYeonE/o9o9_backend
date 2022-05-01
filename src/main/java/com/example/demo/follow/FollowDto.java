package com.example.demo.follow;

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
@NoArgsConstructor(access=AccessLevel.PUBLIC)  //�⺻�����ڸ� ������ش� 
@ToString
public class FollowDto extends BaseDto{
	    
	private String follow_seq = "";		//�ȷο� �ĺ�
	private String follow_follower = "";	// �� 
	private String follow_followee = "";  // ����
	private Date follow_regDate; // now(), follower, followee list ��½� �ֽż�����
	private String profile_short="";
	private String user_image1="";
	private String user_name="";
	private String user_level="";
	private String follower_seq="";
	private String followee_seq="";
	
	@Builder
	public FollowDto(String follow_seq, String follow_follower, String follow_followee, Date follow_regDate,
			String profile_short, String user_image1, String user_name, String user_level, String follower_seq,
			String followee_seq) {
		super();
		this.follow_seq = follow_seq;
		this.follow_follower = follow_follower;
		this.follow_followee = follow_followee;
		this.follow_regDate = follow_regDate;
		this.profile_short = profile_short;
		this.user_image1 = user_image1;
		this.user_name = user_name;
		this.user_level = user_level;
		this.follower_seq = follower_seq;
		this.followee_seq = followee_seq;
	}

	
}