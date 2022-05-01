package com.example.demo.follow;

import java.util.List;

public interface FollowDao {
	
	void follow(FollowDto dto);   //ÆÈ·Î¿ì
	void unfollow(FollowDto dto); //¾ðÆÈ·Î¿ì
	boolean isFollow(FollowDto follow);  //ÆÈ·Î¿ì À¯¹«
	List<FollowDto> selectFollowerUserList(String follower);
	List<FollowDto> selectFolloweeUserList(String followee);
}
