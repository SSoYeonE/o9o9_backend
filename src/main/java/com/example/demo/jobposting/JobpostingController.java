package com.example.demo.jobposting;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*") //http:127.0.0.1 혹은 localhost
@RestController   //jsp를 호출하지않고 json형태로 데이터를 보낸다
public class JobpostingController {

	
	@Value("${domain}")
	String domain;
	
	@Resource(name="jobpostingService")
	JobpostingService service;	
	
	
	@RequestMapping("/jobposting/view/{id}")
	JobpostingDto getView(@PathVariable("id")long id)
	{
		return service.getView(id+"");
	}
	
	
	@RequestMapping("/jobposting/insert")
	Map<String, String> insert( JobpostingDto dto, HttpServletRequest req)
	{		

		System.out.println(dto);// 전송받은 데이터 확인
		
		service.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	 @RequestMapping("/jobposting/delete/{jobposting_seq}")
		Map<String, String> delete(@PathVariable("jobposting_seq")long jobposting_seq)
		{		
		 	//System.out.println(jobposting_seq);
			JobpostingDto dto=new JobpostingDto();
			dto.setJobposting_seq(jobposting_seq+"");
			service.delete(dto);
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "success");
			return map;
		}
		
	    
	    @RequestMapping("/jobposting/update")
	   	Map<String, String> update(JobpostingDto dto, HttpServletRequest req)
	   	{		
	    	System.out.println("update------------"+ dto);
	   		service.update(dto);
	   		Map<String, String> map = new HashMap<String, String>();
	   		map.put("result", "success");
	   		return map;
	   	}
	
}
