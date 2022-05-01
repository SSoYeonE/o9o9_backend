package com.example.demo.mainboard;

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

import com.example.demo.common.FileUploadUtil;
import com.example.demo.jobposting.JobpostingDto;
import com.example.demo.jobposting.JobpostingService;
import com.example.demo.like.LikeDto;
import com.example.demo.like.LikeService;

@CrossOrigin("*") //http:127.0.0.1 혹은 localhost
@RestController   //jsp를 호출하지않고 json형태로 데이터를 보낸다
public class MainboardController {

	@Value("${fileUploadPath}") //src/main/resources/application.properies의 값을 읽어온다
	String fileUploadPath;
	
	@Value("${domain}")
	String domain;
	
	@Resource(name="mainboardService")
	MainboardService service;	
	
	@Resource(name="likeService")
	LikeService likeService;
	
	@Resource(name="jobpostingService")
	JobpostingService jobpostingService;	
	
	
	
	@RequestMapping("/mainboard/list/{pg}")  //페이지
	HashMap<String, Object> getList(@PathVariable("pg")int pg, MainboardDto dto)
	{
		System.out.println(dto.getKeyword());
		dto.setPageSize(3);
		dto.setStart((pg-1)*dto.getPageSize()); //페이지세팅
		//dto.setStart((pg-1)*3);
		System.out.println(dto.getPg() + " " + dto.getPageSize());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", service.getTotalCnt(dto));
		map.put("list", service.getList(dto));
		
		//map.put("jobview", jobpostingService.getView(dto.getMboard_seq()));
		
		return map;
	}
	
	@RequestMapping("/mainboard/view/{mboard_seq}")
	MainboardDto getView(@PathVariable("mboard_seq")long mboard_seq)
	{
		return service.getView(mboard_seq);
	}
	
	@RequestMapping("/mainboard/insert")
	Map<String, String> insert(MultipartFile file ,  MainboardDto dto, JobpostingDto jobDto, HttpServletRequest req)
	{		//파일업로드를 하려면 MultipartFile 가 필요하다
//		System.out.println(dto.getTitle());
//		System.out.println(dto.getWriter());
//		System.out.println(dto.getContents());
		System.out.println(dto);// 전송받은 데이터 확인
		System.out.println(file);
		
		dto.setHashtag("#"+dto.getHashtag()+"#");
		
		//fileupload/image
		String uploadDir = fileUploadPath+ "/image" ; // 파일이 업로드될 경로
		
		//http://localhost:9090/fileUpload/image/1582531436.jpeg
		if(file!=null)
		{
			try {
				//새로운 파일명을 반환한다(파일명이 중복될 수 있기때문에)
				String filename=FileUploadUtil.upload(uploadDir, file);
				dto.setContents_url(domain +"/"+ uploadDir + "/"+ filename);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		service.insert(dto);
		
		System.out.println(dto.getMboard_seq());
		
		LikeDto likeDto = new LikeDto();
		likeDto.setMboard_seq(dto.getMboard_seq());
		likeDto.setUser_seq(dto.getUser_seq());
		likeDto.setEmoji("like");
		
		likeService.insert(likeDto);
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("jobpostype-------------" + dto.getPosting_type());
		if(dto.getPosting_type().equals("1")) {
			System.out.println("채용공고 저장");
			jobDto.setMboard_seq(dto.getMboard_seq());
			jobpostingService.insert(jobDto);
		}
		map.put("result", "success");
		return map;
	}
	
	 @RequestMapping("/mainboard/delete/{mboard_seq}")
		Map<String, String> delete(@PathVariable("mboard_seq")long mboard_seq, HttpServletRequest req)
		{		
		 	System.out.println("깨아아앙아아아아아아아아");
			MainboardDto dto=new MainboardDto();
			dto.setMboard_seq(mboard_seq+"");
			service.delete(dto);
			Map<String, String> map = new HashMap<String, String>();
			map.put("result", "success");
			return map;
		}
		
	    
	    @RequestMapping("/mainboard/update")
	   	Map<String, String> update(MultipartFile file ,  MainboardDto dto,  JobpostingDto jobDto, HttpServletRequest req)
	   	{		
	   		System.out.println(dto);	   		
	   		
	   		String uploadDir = fileUploadPath+ "/image" ;
	   		
	   		//http://localhost:9090/user-photos/image/1582531436.jpeg
	   		if(file!=null)
	   		{
	   			try {
	   				String filename=FileUploadUtil.upload(uploadDir, file);
	   				
	   				dto.setContents_url(domain +"/"+ uploadDir + "/"+ filename);
	   				
	   			} catch (IOException e) {
	   				e.printStackTrace();
	   			}
	   		}
	   		
	   		//System.out.println("**********************************    "  +  dto.getId());
	   		
	   		service.update(dto);
	   		Map<String, String> map = new HashMap<String, String>();if(dto.getPosting_type().equals("1")) {
				System.out.println("채용공고 수정");
				jobDto.setMboard_seq(dto.getMboard_seq());
				jobpostingService.update(jobDto);
			}
			map.put("result", "success");
			return map;
	   	}
	
}
