package com.example.demo.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public MemberDto getInfo(MemberDto dto) {
		System.out.println("MemberDaoImpl Dto -----------------" + dto );
		return sm.selectOne("Member_getInfo", dto.getUser_id());
	}
	
	@Override
	public void insert(MemberDto dto) {
		sm.insert("Member_insert", dto);
	}

	@Override
	public MemberDto findId(MemberDto dto) {
		return sm.selectOne("Member_findId", dto);
	}

	@Override
	public MemberDto findPassword(MemberDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Member_findPassword", dto);
	}

	@Override
	public void update(MemberDto dto) {
		sm.update("Member_updateInfo", dto);
		
	}

	@Override
	public List<MemberDto> search(MemberDto dto) {
				
		return sm.selectList("Member_search", dto);
	}

	@Override
	public int getTotalCnt(MemberDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Member_getTotal", dto);
	}

	@Override
	public void levelchange(MemberDto dto) {
		sm.update("Member_levelchange", dto);
	}

	@Override
	public List<MemberDto> pendingList(MemberDto dto) {
		return sm.selectOne("Member_pendingList", dto);
	}

	@Override
	public int search_getTotalCnt(MemberDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Member_search_getTotal", dto);
	}
	
	
}