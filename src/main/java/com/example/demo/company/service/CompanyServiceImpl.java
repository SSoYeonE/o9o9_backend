package com.example.demo.company.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.cand.domain.CandDto;
import com.example.demo.cand.domain.CandDto2;
import com.example.demo.company.domain.CompanyDto;
import com.example.demo.company.repository.CompanyDao;




@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

	@Resource(name="companyDao")
	CompanyDao dao;
	
	public List<CompanyDto> getList(CompanyDto dto) {
		// TODO Auto-generated method stub
		return dao.getList(dto);
	}

	@Override
	public CompanyDto getView(long seq) {
		// TODO Auto-generated method stub
		return dao.getView(seq);
	}

	@Override
	public void insert(CompanyDto dto) {
		dao.insert(dto);
		
	}


	@Override
	public void update(CompanyDto dto) {
		dao.update(dto);
		
	}

	@Override
	public int getTotalCnt(CompanyDto dto) {
		// TODO Auto-generated method stub
		return dao.getTotalCnt(dto);
	}

	@Override
	public void enroll(CandDto dto) {
		// TODO Auto-generated method stub
		dao.enroll(dto);
	}

	@Override
	public List<CandDto2> getCandList(CompanyDto dto) {
		// TODO Auto-generated method stub
		return dao.getCandList(dto);
	}

	
}






