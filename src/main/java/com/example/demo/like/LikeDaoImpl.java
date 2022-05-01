package com.example.demo.like;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("likeDao")  // repository == resource
public class LikeDaoImpl implements LikeDao {

	@Autowired
	SqlSessionTemplate sm;

	@Override
	public int getTotalCnt(LikeDto dto) {
		return sm.selectOne("Like_getTotal",dto);
	}

	@Override
	public LikeDto getView(LikeDto dto) {
		return sm.selectOne("Like_getView",dto);
	}	
	@Override
	public void insert(LikeDto dto) {
		sm.insert("Like_insert",dto);
	}

	@Override
	public void update(LikeDto dto) {
		sm.update("Like_update",dto);
		
	}

	@Override
	public void delete(LikeDto dto) {
		sm.delete("Like_delete",dto);
		
	}

	@Override
	public List<LikeDto> getList(LikeDto dto) {
		return sm.selectList("Like_getList",dto);
	}
	



}
