package com.example.demo.sideprofile;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("sideprofileService")
public class SideprofilServiceImpl implements SideprofileService {

	@Resource(name = "sideprofileDao")
	SideprofileDao dao;

	@Override
	public SideprofileDto getView(SideprofileDto dto) {
		return dao.getView(dto);
	}

}
