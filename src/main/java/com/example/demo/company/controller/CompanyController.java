package com.example.demo.company.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.cand.domain.CandDto;
import com.example.demo.company.domain.CompanyDto;
import com.example.demo.company.service.CompanyService;



@CrossOrigin("*") //http:127.0.0.1 혹은 localhost
@RestController //jsp 호출 안하고 json 형태로 데이터를 보낸다.
public class CompanyController {
	
	@Value("${fileUploadPath}") //src/main/resources/application.properties 의 값을 읽어옴
	String fileUploadPath;
	
	@Value("${domain}")
	String domain;
	
	@Resource(name="companyService")
	CompanyService companyService;
	
	
	@RequestMapping("/company/list/{pg}")
	HashMap<String, Object> getList(@PathVariable("pg")int pg, CompanyDto dto)
	{
		//System.out.println("curpage  " + pg);
		dto.setStart((pg-1)*dto.getPageSize());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", companyService.getTotalCnt(dto));
		map.put("list",  companyService.getList(dto));
		
		return map;
	}
	
	
	@RequestMapping("/company/view/{seq}")
	CompanyDto getView(@PathVariable("seq")long seq)
	{		
		return	companyService.getView(seq);
	}
	
	// Map -> HashMap의 추상클래스  -- aixos 가 json 으로 보내는데 json 받으려면 
	//@RequestBody  가 있어야 한다 
	@RequestMapping("/company/insert")
	Map<String, String> insert(CompanyDto dto, HttpServletRequest req)
	{		
		System.out.println(dto.getSize());
		
		
		companyService.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	@RequestMapping("/apply/insert")
	Map<String, String> apply(CandDto dto, HttpServletRequest req)
	{				
		
		companyService.enroll(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	//http://apply//list?company=3
	///apply/list/3
	@RequestMapping("/apply/list")
	HashMap<String, Object> getList(CompanyDto dto)
	{
		//System.out.println("curpage  " + pg);
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list",  companyService.getCandList(dto));
		
		return map;
	}
    @RequestMapping("/company/update")
   	Map<String, String> update(MultipartFile file, CompanyDto dto, HttpServletRequest req)
   	{		
   		//System.out.println(dto.getSeq());
   		System.out.println(dto);
   		
   		//System.out.println("**********************************    "  +  dto.getId());
   		
   		companyService.update(dto);
   		Map<String, String> map = new HashMap<String, String>();
   		map.put("result", "success");
   		return map;
   	}
    
    
}






