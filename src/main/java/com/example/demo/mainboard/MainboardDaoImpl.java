package com.example.demo.mainboard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mainboardDao")  // repository == resource
public class MainboardDaoImpl implements MainboardDao {

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<MainboardDto> getList(MainboardDto dto) {
		
		return sm.selectList("Mainboard_getList",dto);
	}

	@Override
	public int getTotalCnt(MainboardDto dto) {
		
		return sm.selectOne("Mainboard_getTotal",dto);
	}

	@Override
	public MainboardDto getView(long id) {
		return sm.selectOne("Mainboard_getView",  id);
	}

	@Override
	public void insert(MainboardDto dto) {
		sm.insert("Mainboard_insert",dto);
		
	}

	@Override
	public void update(MainboardDto dto) {
		sm.update("Mainboard_update",dto);
		
	}

	@Override
	public void delete(MainboardDto dto) {
		sm.delete("Mainboard_delete",dto);
		
	}



}
