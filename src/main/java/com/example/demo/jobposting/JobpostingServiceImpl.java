package com.example.demo.jobposting;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

// MainboardServiceImpl mainboardService = new MainboardServiceImpl();
@Service("jobpostingService")
public class JobpostingServiceImpl implements JobpostingService {

	@Resource(name="jobpostingDao")
	JobpostingDao dao;

	
	@Override
	public int getTotalCnt(JobpostingDto dto) {
		
		return dao.getTotalCnt(dto);
	}

	@Override
	public void insert(JobpostingDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(JobpostingDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(JobpostingDto dto) {
		dao.delete(dto);
		
	}

	@Override
	public List<JobpostingDto> getList(JobpostingDto dto) {
		
		return dao.getList(dto);
	}

	@Override
	public JobpostingDto getView(String id) {
		return dao.getView(id);
	}
	
	
	

}
