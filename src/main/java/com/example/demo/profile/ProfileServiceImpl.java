package com.example.demo.profile;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("profileService")
public class ProfileServiceImpl implements ProfileService{

	@Resource(name="profileDao")
	ProfileDao dao;
	
	@Override
	public ProfileDto getView(long user_seq) {
		return dao.getView(user_seq);
	}

	@Override
	public void update(ProfileDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void insert(ProfileDto dto) {
		dao.insert(dto);
		
	}

}
