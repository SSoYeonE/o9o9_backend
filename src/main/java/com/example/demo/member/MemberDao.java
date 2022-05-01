package com.example.demo.member;

import java.util.List;

public interface MemberDao {
	
	MemberDto getInfo(MemberDto dto);
	void insert(MemberDto dto);
	MemberDto findId(MemberDto dto);
	MemberDto findPassword(MemberDto dto);
	void update(MemberDto dto);
	
	// 사용자 페이지
	public List<MemberDto> search(MemberDto dto);
	public int search_getTotalCnt(MemberDto dto);
	
	// 관리자 페이지
	public List<MemberDto> pendingList(MemberDto dto);
	public int getTotalCnt(MemberDto dto);
	void levelchange(MemberDto dto);
}