package com.example.demo.like;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.domain.BoardDto;
import com.example.demo.common.FileUploadUtil;

@CrossOrigin("*") //http:127.0.0.1 혹은 localhost
@RestController   //jsp를 호출하지않고 json형태로 데이터를 보낸다
public class LikeController {

	
	@Value("${domain}")
	String domain;
	
	@Resource(name="likeService")
	LikeService service;	
	
	
	@RequestMapping("/like/view/{id}")
	LikeDto getView(@PathVariable("id")long id)
	{
		return service.getView(id);
	}
	
	@RequestMapping("/like/insert")
	Map<String, String> insert( LikeDto dto, HttpServletRequest req)
	{		

		System.out.println(dto);// 전송받은 데이터 확인
		
		service.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	 @RequestMapping("/like/delete/{like_seq}")
		Map<String, String> delete(@PathVariable("like_seq")long like_seq, HttpServletRequest req)
		{		
			LikeDto dto=new LikeDto();
			dto.setMboard_seq(like_seq+"");
			service.delete(dto);
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "success");
			return map;
		}
		
	    
	    @RequestMapping("/like/update")
	   	Map<String, String> update(MultipartFile file ,  LikeDto dto, HttpServletRequest req)
	   	{		
	   		service.update(dto);
	   		Map<String, String> map = new HashMap<String, String>();
	   		map.put("result", "success");
	   		return map;
	   	}
	
}
