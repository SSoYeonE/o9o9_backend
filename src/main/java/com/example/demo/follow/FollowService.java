package com.example.demo.follow;

import java.util.List;

public interface FollowService {

	public void follow(FollowDto dto) ;
	public void unfollow(FollowDto dto) ;
	public boolean isFollow(FollowDto follow);
	public List<FollowDto> selectFollowerUserList(String follower);
	public List<FollowDto> selectFolloweeUserList(String followee);
	

}
