package com.example.demo.follow;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("followDao")

public class FollowDaoImpl implements FollowDao{
	
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public void follow(FollowDto dto) {
		sm.insert("follow", dto);
	}

	@Override
	public void unfollow(FollowDto dto) {
		sm.delete("unfollow", dto);
		
	}

	@Override
	public boolean isFollow(FollowDto follow) {
		// TODO Auto-generated method stub
		int res = sm.selectOne("isfollow", follow);
		if( res > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<FollowDto> selectFollowerUserList(String follower) {
		return sm.selectList("selectFollowerUserList", follower);
	}

	@Override
	public List<FollowDto> selectFolloweeUserList(String followee) {
		return sm.selectList("selectFolloweeUserList", followee);
	}

	

}
