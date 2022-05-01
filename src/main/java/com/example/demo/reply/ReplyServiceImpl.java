package com.example.demo.reply;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

// MainboardServiceImpl mainboardService = new MainboardServiceImpl();
@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

	@Resource(name="replyDao")
	ReplyDao dao;
	
	@Override
	public int getTotalCnt(ReplyDto dto) {
		
		return dao.getTotalCnt(dto);
	}

	@Override
	public ReplyDto getView(long id) {
		
		return dao.getView(id);
	}

	@Override
	public void insert(ReplyDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public void update(ReplyDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(ReplyDto dto) {
		dao.delete(dto);
		
	}

	@Override
	public List<ReplyDto> getList(ReplyDto dto) {
		
		return dao.getList(dto);
	}
	

}
