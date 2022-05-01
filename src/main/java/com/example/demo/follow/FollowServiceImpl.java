package com.example.demo.follow;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("followService")
public class FollowServiceImpl implements FollowService{
	//FollowDaoImpl followDao = new FollowDaoImpl(); //followDao 객체 생성
	// followDao.selectFollowerUserList()
	// 객체 생성 어노테이션 : @Repository, @Service, @Controller -> @Component
	// 객체 주입 어노테이션 : @Resource, @Autowired
	

	@Resource(name="followDao")
	FollowDao dao;
	
	
	@Override
	public void follow(FollowDto dto) {
		dao.follow(dto);
		
	}


	@Override
	public void unfollow(FollowDto dto) {
		dao.unfollow(dto);
		
	}


	@Override
	public boolean isFollow(FollowDto follow) {
		return dao.isFollow(follow);
	}


	@Override
	public List<FollowDto> selectFollowerUserList(String follower) {
		return dao.selectFollowerUserList(follower);
	}


	@Override
	public List<FollowDto> selectFolloweeUserList(String followee) {
		return dao.selectFolloweeUserList(followee);
	}

}
