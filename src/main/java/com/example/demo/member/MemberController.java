package com.example.demo.member;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.FileUploadUtil;
import com.example.demo.company.domain.CompanyDto;
import com.example.demo.company.service.CompanyService;
import com.example.demo.profile.ProfileDto;
import com.example.demo.profile.ProfileService;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
public class MemberController {
	@Value("${fileUploadPath}") // src/main/resources/application.properies�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕 �뜝�떩�뼲�삕夷덂뜝占�
	String fileUploadPath;

	@Value("${domain}")
	String domain;

	@Resource(name = "memberService")
	MemberService memberService;
	
	@Resource(name = "profileService")
	ProfileService profileService;
	
	@Resource(name = "companyService")
	CompanyService companyService;

//	@RequestMapping(value="/member/login")
//	public String member_login()
//	{
//		return "member/member_login";
//	}

	@RequestMapping("/member/mypage/{user_id}")
	HashMap<String, Object> member_myinfo(@PathVariable("user_id") String user_id, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(user_id);
		HttpSession session = request.getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();

		if (user_id == null) {
			map.put("result", "fail");
			return map;
		}

		MemberDto dto = new MemberDto();
		dto.setUser_id(user_id);

		MemberDto resultDto = memberService.getInfo(dto);
		map.put("result", "success");
		map.put("info", resultDto);
		// model.addAttribute("memberDto", resultDto);
		return map;
	}

	@RequestMapping("/member/login_proc")
	public HashMap<String, Object> member_login_proc(@RequestBody String payload, HttpServletRequest request) {
		Map<String, Object> javaObject = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			javaObject = mapper.readValue(payload, Map.class);
		} catch (Exception e) {
			//System.out.println("payload �뜝�룞�삕�뜝�룞�삕");
		}

		System.out.println("javaObject: " + javaObject);
		System.out.println("userid:" + javaObject.get("user_id").toString());
		System.out.println("password:" + javaObject.get("user_password").toString());

		MemberDto paramDto = new MemberDto();
		paramDto.setUser_id(javaObject.get("user_id").toString());
		paramDto.setUser_password(javaObject.get("user_password").toString());

		System.out.println("login_proc:" + paramDto);
		HttpSession session = request.getSession();

		MemberDto resultDto = memberService.getInfo(paramDto);
		HashMap<String, Object> map = new HashMap<String, Object>();
		System.out.println(resultDto);

		if (resultDto == null) {
			map.put("msg", "해당하는 회원정보가 없습니다");
			map.put("result", "fail");
			map.put("flag", "2");
		} else {
			System.out.println(resultDto.getUser_password().equals(paramDto.getUser_password()));
			if (resultDto.getUser_password().equals(paramDto.getUser_password())) {
				System.out.println("111111111111111111111");
				map.put("result", "success");
				map.put("msg", "로그인 성공"); 
				map.put("flag", "1");
				map.put("user", resultDto);
				
				session.setAttribute("user_seq", resultDto.getUser_seq());
				session.setAttribute("user_id", resultDto.getUser_id());
				session.setAttribute("user_name", resultDto.getUser_name());
				session.setAttribute("user_mail", resultDto.getUser_mail());
				session.setAttribute("user_phone", resultDto.getUser_phone());
				session.setAttribute("user_level", resultDto.getUser_level());
				session.setAttribute("user_image1", resultDto.getUser_image1());
				session.setAttribute("user_image2", resultDto.getUser_image2());
				session.setAttribute("user_address1", resultDto.getUser_address1());
				session.setAttribute("user_address2", resultDto.getUser_address2());
				session.setAttribute("user_business", resultDto.getUser_business());
			}

			else {
				System.out.println("333333333333333");
				map.put("msg", "비밀번호가 틀렸습니다");
				map.put("result", "fail");
				map.put("flag", "3");
			}
		}

		return map;
	}

	@RequestMapping("/member/insert")
	public HashMap<String, String> member_insert(MultipartFile file1, MultipartFile file2, MemberDto dto) {
		// File Upload
		String uploadDir = fileUploadPath + "/image";

		if (file1 != null) {
			try {
				// �뜝�룞�삕�뜝�떥�슱�삕 �뜝�룞�삕�뜝�떦紐뚯삕�뜝�룞�삕 �뜝�룞�삕�솚�뜝�떬�뙋�삕(�뜝�룞�삕�뜝�떦紐뚯삕�뜝�룞�삕 �뜝�뙥釉앹삕�뜝�룞�삕 �뜝�룞�삕 �뜝�뙇湲곕븣�뜝�룞�삕�뜝�룞�삕)
				String filename1 = FileUploadUtil.upload(uploadDir, file1);
				dto.setUser_image1(domain + "/" + uploadDir + "/" + filename1);

				// String filename2=FileUploadUtil.upload(uploadDir, file2);
				// dto.setUser_image2(domain +"/"+ uploadDir + "/"+ filename2);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (file2 != null) {
			try {
				// �뜝�룞�삕�뜝�떥�슱�삕 �뜝�룞�삕�뜝�떦紐뚯삕�뜝�룞�삕 �뜝�룞�삕�솚�뜝�떬�뙋�삕(�뜝�룞�삕�뜝�떦紐뚯삕�뜝�룞�삕 �뜝�뙥釉앹삕�뜝�룞�삕 �뜝�룞�삕 �뜝�뙇湲곕븣�뜝�룞�삕�뜝�룞�삕)
				String filename2 = FileUploadUtil.upload(uploadDir, file2);
				dto.setUser_image2(domain + "/" + uploadDir + "/" + filename2);

				// String filename2=FileUploadUtil.upload(uploadDir, file2);
				// dto.setUser_image2(domain +"/"+ uploadDir + "/"+ filename2);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("dto = "+dto);

		///////////////// �뜝�떛諭꾩삕�뜝�룞�삕 �뜝�룞�삕�뜝�떥�벝�삕 end /////////////
		System.out.println("userid : " + dto.getUser_id());
		System.out.println("userseq before : " + dto.getUser_seq());
		memberService.insert(dto);
		System.out.println("userseq after: " + dto.getUser_seq());
		System.out.println("userLevel: " + dto.getUser_level());

		HashMap<String, String> map = new HashMap<String, String>();
		// �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕�뜝�떥�눦�삕�듃
		if(dto.getUser_level().equals("0")) {
			ProfileDto pDto = new ProfileDto();
			pDto.setUser_seq(Integer.parseInt(dto.getUser_seq()));
			profileService.insert(pDto);
			System.out.println("�씪諛섑쉶�썝�엯�땲�떎.");

		}else if (dto.getUser_level().equals("1")) {
			CompanyDto pDto = new CompanyDto();
			pDto.setUser_seq(Integer.parseInt(dto.getUser_seq()));
			companyService.insert(pDto);
			System.out.println("湲곗뾽�쉶�썝�엯�땲�떎.");
		}
			
		
		map.put("result", "success");
		return map;
	}

	@RequestMapping("/member/logout")
	public HashMap<String, String> member_logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate(); // �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕
								// �뜝�떦�뙋�삕 void�뜝�룞�삕 泥섇뜝�룞�삕�뜝�떦源띿삕 �뜝�뙥�뒗�벝�삕 �뜝�떥洹몄븘�슱�삕�뜝�떦紐뚯삕 �뜝�뙐�룞�삕 �뜝�떥源띿삕�뜝�룞�삕 李썲뜝�룞�삕�뜝�룞�삕 �뜝�룞�삕�뜝�룞�삕�뜝�떛琉꾩삕�듃 �뜝�떦怨ㅼ삕 �뜝�떦怨ㅼ삕 �뜝�떢�뼲�삕�뜝占�
		HashMap<String, String> map = new HashMap<String, String>();

		map.put("result", "success");
		return map;
	}

	@RequestMapping("/member/findid_proc")
	public HashMap<String, String> member_findid_proc(@RequestBody MemberDto dto) {
		MemberDto findDto = memberService.findId(dto);
		HashMap map = new HashMap<String, String>();
		if (findDto == null)
			map.put("result", "fail");
		else {
			map.put("result", findDto.getUser_id());
			map.put("user_seq", findDto.getUser_seq());
		}
		return map;
	}

	@RequestMapping("/member/findpass_proc")
	public HashMap<String, String> member_findpass_proc(@RequestBody MemberDto dto) {
		System.out.println(dto);
		MemberDto findDto = memberService.findPassword(dto);
		System.out.println(findDto);
		HashMap map = new HashMap<String, String>();
		if (findDto == null)
			map.put("result", "fail");
		else {
			map.put("result", findDto.getUser_password());
			map.put("user_seq", findDto.getUser_seq());
		}
		return map;
	}

	@RequestMapping("/member/update")
	public HashMap<String, String> member_update(MultipartFile file1, MultipartFile file2, MemberDto dto) {
		System.out.println(dto);
		System.out.println(file1.getOriginalFilename());
		System.out.println(file2.getOriginalFilename());
		// File Upload
		String uploadDir = fileUploadPath + "/image";

		if (file1 != null && !file1.getOriginalFilename().isBlank()) {
			try {
				// �뜝�룞�삕�뜝�떥�슱�삕 �뜝�룞�삕�뜝�떦紐뚯삕�뜝�룞�삕 �뜝�룞�삕�솚�뜝�떬�뙋�삕(�뜝�룞�삕�뜝�떦紐뚯삕�뜝�룞�삕 �뜝�뙥釉앹삕�뜝�룞�삕 �뜝�룞�삕 �뜝�뙇湲곕븣�뜝�룞�삕�뜝�룞�삕)
				String filename1 = FileUploadUtil.upload(uploadDir, file1);
				dto.setUser_image1(domain + "/" + uploadDir + "/" + filename1);

				// String filename2=FileUploadUtil.upload(uploadDir, file2);
				// dto.setUser_image2(domain +"/"+ uploadDir + "/"+ filename2);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (file2 != null && !file2.getOriginalFilename().isBlank()) {
			try {
				// �뜝�룞�삕�뜝�떥�슱�삕 �뜝�룞�삕�뜝�떦紐뚯삕�뜝�룞�삕 �뜝�룞�삕�솚�뜝�떬�뙋�삕(�뜝�룞�삕�뜝�떦紐뚯삕�뜝�룞�삕 �뜝�뙥釉앹삕�뜝�룞�삕 �뜝�룞�삕 �뜝�뙇湲곕븣�뜝�룞�삕�뜝�룞�삕)
				String filename2 = FileUploadUtil.upload(uploadDir, file2);
				dto.setUser_image2(domain + "/" + uploadDir + "/" + filename2);

				// String filename2=FileUploadUtil.upload(uploadDir, file2);
				// dto.setUser_image2(domain +"/"+ uploadDir + "/"+ filename2);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		memberService.update(dto);
		HashMap map = new HashMap<String, String>();
		map.put("result", "success");
		return map;
	}

	//http://localhost:9090/member/search/1 
	@RequestMapping("/member/search") 
	HashMap<String, Object> search(MemberDto dto)
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list",  memberService.search(dto));
		map.put("totalCnt", memberService.search_getTotalCnt(dto) );
		return map;
	}
	

		
	
	@RequestMapping("/member/levelchange")
	@ResponseBody
	public HashMap<String, Object> levelchange(MemberDto dto)
	{	
		memberService.levelchange(dto);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");	
		return map;
	}
	
	@RequestMapping("/member/pendingList") 
	HashMap<String, Object> pendingList(@PathVariable("pg")int pg, MemberDto dto)
	{

		dto.setStart((pg-1)*dto.getPageSize());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("totalCnt", memberService.getTotalCnt(dto));
		map.put("list",  memberService.pendingList(dto));
		
		return map;
	}

}