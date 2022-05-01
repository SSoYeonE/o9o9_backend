package com.example.demo.profile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.FileDownload;
import com.example.demo.common.FileUploadUtil;

@CrossOrigin("*") //http:127.0.0.1 혹은 localhost
@RestController  // jsp를 호출하지 않고 json 형태로 데이터를 보낸다
public class ProfileController {
	
	@Value("${fileUploadPath}")  //scr/main/resources/application.properties 의 값을 읽어온다
	String fileUploadPath;
	
	@Value("${domain}")
	String domain;
	
	@Resource(name="profileService")
	ProfileService profileService;
	
	@RequestMapping("/profile/view/{user_seq}")
	ProfileDto getView(@PathVariable("user_seq")long user_seq)
	{		
		return	profileService.getView(user_seq);
	}
	
    @RequestMapping("/profile/insert")
   	Map<String, String> insert(MultipartFile file1 ,  MultipartFile file2, MultipartFile file3, ProfileDto dto, HttpServletRequest req)
   	{		
    	System.out.println("file1-------"+ file1);
    	System.out.println("file2-------"+ file2);
    	System.out.println("file3-------"+ file3);
   		

   		String uploadDir = fileUploadPath+ "/image" ;
   		
   		//http://localhost:9090/user-photos/image/1582531436.jpeg
   		if(file1!= null && !file1.getOriginalFilename().isBlank()) {		
   		
   			try {
   				String filename=FileUploadUtil.upload(uploadDir, file1);

   				dto.setProfile_filename1(filename);
   				
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		
   		if(file2!= null && !file2.getOriginalFilename().isBlank()) {		
   			try {
   				String filename=FileUploadUtil.upload(uploadDir, file2);
   				dto.setProfile_filename2(filename);

   				
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		if(file3!= null &&  !file3.getOriginalFilename().isBlank()) {		
   			try {
   				String filename=FileUploadUtil.upload(uploadDir, file3);
   				dto.setProfile_filename3(filename);

   				
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		//System.out.println("**********************************    "  +  dto.getId());
   		System.out.println(dto);
   		profileService.insert(dto);
   		
   		Map<String, String> map = new HashMap<String, String>();
   		map.put("result", "success");
   		return map;
   	}
	
	
    @RequestMapping("/profile/update")
   	Map<String, String> update(MultipartFile file1 ,  MultipartFile file2, MultipartFile file3, ProfileDto dto, HttpServletRequest req)
   	{		
   		System.out.println(dto);

   		String uploadDir = fileUploadPath+ "/image" ;
   		
   		//http://localhost:9090/user-photos/image/1582531436.jpeg
   		if(file1!= null && !file1.getOriginalFilename().isBlank())	
   		{
   			try {
   				String filename=FileUploadUtil.upload(uploadDir, file1);

   				dto.setProfile_filename1(domain +"/"+ uploadDir + "/"+ filename);
   				
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		
   		if(file2!= null && !file2.getOriginalFilename().isBlank())		
   		{
   			try {
   				String filename=FileUploadUtil.upload(uploadDir, file2);
   				dto.setProfile_filename2(domain +"/"+ uploadDir + "/"+ filename);

   				
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		if(file3!= null &&  !file3.getOriginalFilename().isBlank())	
   		{
   			try {
   				String filename=FileUploadUtil.upload(uploadDir, file3);
   				dto.setProfile_filename3(domain +"/"+ uploadDir + "/"+ filename);

   				
   			} catch (IOException e) {
   				e.printStackTrace();
   			}
   		}
   		//System.out.println("**********************************    "  +  dto.getId());
   		
   		profileService.update(dto);
   		Map<String, String> map = new HashMap<String, String>();
   		map.put("result", "success");
   		return map;
   	}
    
    // http://localhost:9090/profile/download/image?file=CompanyControlle(5).java
    @RequestMapping("profile/download/image")
    public void download(String file, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        System.out.println(file);
        FileDownload.download(fileUploadPath+"/image",  file, httpServletResponse);

        
    }
	
}
