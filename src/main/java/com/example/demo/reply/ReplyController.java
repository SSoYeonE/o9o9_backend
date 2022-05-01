package com.example.demo.reply;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*") //http:127.0.0.1 혹은 localhost
@RestController   //jsp를 호출하지않고 json형태로 데이터를 보낸다
public class ReplyController {

	
	@Value("${domain}")
	String domain;
	
	@Resource(name="replyService")
	ReplyService service;	
	
	
	@RequestMapping("/reply/list/{mboard_seq}")
	List<ReplyDto> getView(@PathVariable("mboard_seq")long mboard_seq)
	{
		ReplyDto dto=new ReplyDto();
		dto.setMboard_seq(mboard_seq+"");
		return service.getList(dto);
	}
	
	@RequestMapping("/reply/insert")
	Map<String, String> insert(ReplyDto dto, HttpServletRequest req)
	{		
		System.out.println(dto);// 전송받은 데이터 확인
		
		service.insert(dto);
		Map<String, String> map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}
	
	 @RequestMapping("/reply/delete/{reply_seq}")
		Map<String, String> delete(@PathVariable("reply_seq")long reply_seq, HttpServletRequest req)
		{		
			ReplyDto dto=new ReplyDto();
			dto.setReply_seq(reply_seq+"");
			service.delete(dto);
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "success");
			return map;
		}
		
    
    @RequestMapping("/reply/update")
   	Map<String, String> update(MultipartFile file ,  ReplyDto dto, HttpServletRequest req)
   	{		
   		System.out.println(dto);	   		
   		service.update(dto);
   		Map<String, String> map = new HashMap<String, String>();
   		map.put("result", "success");
   		return map;
   	}

		
}
