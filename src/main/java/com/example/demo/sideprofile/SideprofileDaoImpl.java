package com.example.demo.sideprofile;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("sideprofileDao")
public class SideprofileDaoImpl implements SideprofileDao {

	@Autowired
	SqlSessionTemplate sm;

	@Override
	public SideprofileDto getView(SideprofileDto dto) {
		return sm.selectOne("Sideprofile_getView", dto);

	}

}
