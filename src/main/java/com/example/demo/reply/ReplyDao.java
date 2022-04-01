package com.example.demo.reply;

import java.util.List;

public interface ReplyDao {

	int getTotalCnt(ReplyDto dto);
	ReplyDto getView(long id);
	void insert(ReplyDto dto);
	void update(ReplyDto dto);
	void delete(ReplyDto dto);
}
