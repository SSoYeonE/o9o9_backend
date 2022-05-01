package com.example.demo.member;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService{

	@Resource(name="memberDao")
	MemberDao dao;
	
	@Override
	public MemberDto getInfo(MemberDto dto) {

		
		return dao.getInfo(dto);
	}

	@Override
	public void insert(MemberDto dto) {
		dao.insert(dto);
	}

	@Override
	public MemberDto findId(MemberDto dto) {
		// TODO Auto-generated method stub
		return dao.findId(dto);
	}

	@Override
	public MemberDto findPassword(MemberDto dto) {
		// TODO Auto-generated method stub
		return  dao.findPassword(dto);
	}

	@Override
	public void update(MemberDto dto) {
		dao.update(dto);	
	}

	
	@Override
	public List<MemberDto> search(MemberDto dto) {
		return dao.search(dto);
	}

	@Override
	public int getTotalCnt(MemberDto dto) {
		return dao.getTotalCnt(dto);
	}

	@Override
	public void levelchange(MemberDto dto) {
		dao.levelchange(dto);
		
	}

	@Override
	public List<MemberDto> pendingList(MemberDto dto) {
		return dao.pendingList(dto);
	}

	@Override
	public int search_getTotalCnt(MemberDto dto) {
		return dao.search_getTotalCnt(dto);
	}

	
}