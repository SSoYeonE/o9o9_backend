package com.example.demo.reply;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("replyDao")  // repository == resource
public class ReplyDaoImpl implements ReplyDao {

	@Autowired
	SqlSessionTemplate sm;
	


	@Override
	public int getTotalCnt(ReplyDto dto) {
		
		return sm.selectOne("Reply_getTotal",dto);
	}

	@Override
	public ReplyDto getView(long id) {
		return sm.selectOne("Reply_getView",id);
	}

	@Override
	public void insert(ReplyDto dto) {
		sm.insert("Reply_insert",dto);
		
	}

	@Override
	public void update(ReplyDto dto) {
		sm.update("Reply_update",dto);
		
	}

	@Override
	public void delete(ReplyDto dto) {
		sm.delete("Reply_delete",dto);
		
	}

	@Override
	public List<ReplyDto> getList(ReplyDto dto) {
		return sm.selectList("Reply_getList",dto);
	}



}
