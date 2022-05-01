package com.example.demo.jobposting;

import java.util.List;

public interface JobpostingDao {
	List<JobpostingDto> getList(JobpostingDto dto);
	int getTotalCnt(JobpostingDto dto);
	void insert(JobpostingDto dto);
	void update(JobpostingDto dto);
	void delete(JobpostingDto dto);
	JobpostingDto getView(String id);
}
