package com.example.demo.profile;

public interface ProfileDao {
	ProfileDto getView(long user_seq);
	void update(ProfileDto dto);
	void insert(ProfileDto dto);
}
