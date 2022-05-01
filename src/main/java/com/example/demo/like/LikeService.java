package com.example.demo.like;

import java.util.List;

public interface LikeService {
	
	List<LikeDto> getList(LikeDto dto);
	int getTotalCnt(LikeDto dto);
	LikeDto getView(LikeDto dto);
	void insert(LikeDto dto);
	void update(LikeDto dto);
	void delete(LikeDto dto);
}
