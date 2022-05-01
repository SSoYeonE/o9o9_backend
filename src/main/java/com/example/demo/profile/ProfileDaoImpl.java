package com.example.demo.profile;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("profileDao")
public class ProfileDaoImpl implements ProfileDao {


	@Autowired
	SqlSessionTemplate sm;

	@Override
	public ProfileDto getView(long user_seq) {

		return sm.selectOne("Profile_getView", user_seq);
	}

	@Override
	public void update(ProfileDto dto) {
		sm.update("Profile_update", dto);

	}

	@Override
	public void insert(ProfileDto dto) {
		sm.insert("Profile_insert", dto);

	}

}
