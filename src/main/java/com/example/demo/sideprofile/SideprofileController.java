package com.example.demo.sideprofile;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*") //http:127.0.0.1 È¤Àº localhost
@RestController  
public class SideprofileController {

	@Value("${domain}")
	String domain;
	
	@Resource(name="sideprofileService")
	SideprofileService service;
	
	@RequestMapping("/sideprofile/view/{user_seq}")
	SideprofileDto getView(@PathVariable("user_seq")int user_seq)
	{
		SideprofileDto dto = new SideprofileDto();
		dto.setUser_seq(user_seq+"");
		return service.getView(dto);
	}
}
