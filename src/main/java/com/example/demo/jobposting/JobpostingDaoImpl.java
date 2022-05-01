package com.example.demo.jobposting;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("jobpostingDao")  // repository == resource
public class JobpostingDaoImpl implements JobpostingDao {

	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<JobpostingDto> getList(JobpostingDto dto) {
		return sm.selectList("Jobposting_getList",dto);
	}

	@Override
	public int getTotalCnt(JobpostingDto dto) {
		return sm.selectOne("Jobposting_getTotal",dto);
	}


	@Override
	public void insert(JobpostingDto dto) {
		sm.insert("Jobposting_insert",dto);
		
	}

	@Override
	public void update(JobpostingDto dto) {
		sm.update("Jobposting_update",dto);
		
	}

	@Override
	public void delete(JobpostingDto dto) {
		sm.delete("Jobposting_delete",dto);
		
	}

	@Override
	public JobpostingDto getView(String id) {
		return sm.selectOne("Jobposting_getView",id);
	}


}

	
	




