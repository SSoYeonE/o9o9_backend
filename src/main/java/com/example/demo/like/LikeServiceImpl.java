package com.example.demo.like;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

// MainboardServiceImpl mainboardService = new MainboardServiceImpl();
@Service("likeService")
public class LikeServiceImpl implements LikeService {

	@Resource(name="likeDao")
	LikeDao dao;

	
	@Override
	public int getTotalCnt(LikeDto dto) {
		// TODO Auto-generated method stub
		return dao.getTotalCnt(dto);
	}

	@Override
	public LikeDto getView(LikeDto dto) {
		return dao.getView(dto);
	}

	@Override
	public void insert(LikeDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(LikeDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(LikeDto dto) {
		dao.delete(dto);
		
	}

	@Override
	public List<LikeDto> getList(LikeDto dto) {
		
		return dao.getList(dto);
	}
	
	
	

}
