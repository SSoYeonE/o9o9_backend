package com.example.demo.mainboard;

import java.util.List;

public interface MainboardService {

	List<MainboardDto> getList(MainboardDto dto);
	int getTotalCnt(MainboardDto dto);
	MainboardDto getView(long id);
	void insert(MainboardDto dto);
	void update(MainboardDto dto);
	void delete(MainboardDto dto);
}
