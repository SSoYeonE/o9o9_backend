package com.example.demo.company.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.cand.domain.CandDto;
import com.example.demo.cand.domain.CandDto2;
import com.example.demo.company.domain.CompanyDto;


@Repository("companyDao")
public class CompanyDaoImpl implements CompanyDao{

	@Autowired
	SqlSessionTemplate sm;
	
	

	@Override
	public CompanyDto getView(long id) {
		return sm.selectOne("Company_getView",  id);
	}

	@Override
	public void insert(CompanyDto dto) {

		sm.insert("Company_insert", dto);
	}

	
	@Override
	public void update(CompanyDto dto) {
		sm.update("Company_update", dto);
		
	}

	@Override
	public List<CompanyDto> getList(CompanyDto dto) {
		// TODO Auto-generated method stub
		return sm.selectList("Company_getList", dto);
	}

	@Override
	public int getTotalCnt(CompanyDto dto) {
		// TODO Auto-generated method stub
		return sm.selectOne("Company_getTotal", dto);
	}

	@Override
	public void enroll(CandDto dto) {
		sm.insert("Cand_insert", dto);
		
	}

	@Override
	public List<CandDto2> getCandList(CompanyDto dto) {
		// TODO Auto-generated method stub
		
		System.out.println(dto.getSeq());
		return sm.selectList("Cand_getList", dto);
	}

	
	

}






