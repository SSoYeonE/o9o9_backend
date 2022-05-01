package com.example.demo.follow;

import java.util.List;

public interface FollowDao {
	
	void follow(FollowDto dto);   //�ȷο�
	void unfollow(FollowDto dto); //���ȷο�
	boolean isFollow(FollowDto follow);  //�ȷο� ����
	List<FollowDto> selectFollowerUserList(String follower);
	List<FollowDto> selectFolloweeUserList(String followee);
}
