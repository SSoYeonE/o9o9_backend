package com.example.demo.profile;

public interface ProfileService {
	ProfileDto getView(long user_seq);	
	void update(ProfileDto dto);
	void insert(ProfileDto dto);
}
