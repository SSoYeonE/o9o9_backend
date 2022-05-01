package com.example.demo.follow;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class FollowController {

	@Resource(name = "followService")
	FollowService service;

	// ÆÈ·Î¿ì ¹öÆ°À» Å¬¸¯ÇßÀ»¶§
	// ÆÈ·Î¿ì -> ÆÈ·ÎÀ×
	@RequestMapping("/follow/isfollow")
	HashMap<String, Object> isfollow(FollowDto dto) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", service.isFollow(dto));
		return map;
	}

	@RequestMapping("/follow/follow")
	HashMap<String, Object> follow(FollowDto dto) {

		service.follow(dto);
		HashMap<String, Object> map = new HashMap<String, Object>();// ¹è¿­ - {0, 1, 2,} ¸Ê - {key:value, key:value}
		map.put("result", "success");
		System.out.println("dto"+dto.getFollow_followee());
		System.out.println("dto"+dto.getFollow_follower());
		return map;
		
	}

	@RequestMapping("/follow/unfollow")
	HashMap<String, Object> unfollow(FollowDto dto) {

		service.unfollow(dto);
		HashMap<String, Object> map = new HashMap<String, Object>();// ¹è¿­ - {0, 1, 2,} ¸Ê - {key:value, key:value}
		map.put("result", "success");
		return map;
	}

	// http://localhost:9090/follow/followerlist?follower=test2
	@RequestMapping("/follow/followerlist")
	HashMap<String, Object> followerlist(String follower) {

		HashMap<String, Object> map = new HashMap<String, Object>();
		List<FollowDto> list = service.selectFollowerUserList(follower);

		if (list == null) {
			map.put("result", "fail");
		} else {
			map.put("result", "success");
			map.put("list", list);
		}
		return map;
	}

	@RequestMapping("/follow/followinglist")
	HashMap<String, Object> followeelist(String followee) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<FollowDto> list = service.selectFolloweeUserList(followee);

		if (list == null) {
			map.put("result", "fail");
		} else {
			map.put("result", "success");
			map.put("list", list);
		}
		return map;
	}

}
