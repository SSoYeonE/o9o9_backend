package com.example.demo.like;

import java.util.List;

import com.example.demo.mainboard.MainboardDto;

public interface LikeDao {
	List<LikeDto> getList(LikeDto dto);
	int getTotalCnt(LikeDto dto);
	LikeDto getView(long id);
	void insert(LikeDto dto);
	void update(LikeDto dto);
	void delete(LikeDto dto);
}
