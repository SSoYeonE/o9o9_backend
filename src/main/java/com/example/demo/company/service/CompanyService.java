package com.example.demo.company.service;

import java.util.List;

import com.example.demo.cand.domain.CandDto;
import com.example.demo.cand.domain.CandDto2;
import com.example.demo.company.domain.CompanyDto;


public interface CompanyService {
	
	public List<CompanyDto> getList(CompanyDto dto);
	CompanyDto getView(long id);
	void insert(CompanyDto dto);
	void update(CompanyDto dto);
	int getTotalCnt(CompanyDto dto);
	void enroll(CandDto dto);
	public List<CandDto2> getCandList(CompanyDto dto);
}
