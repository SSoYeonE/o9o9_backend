package com.example.demo.mainboard;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

// MainboardServiceImpl mainboardService = new MainboardServiceImpl();
@Service("mainboardService")
public class MainboardServiceImpl implements MainboardService {

	@Resource(name="mainboardDao")
	MainboardDao dao;
	
	@Override
	public List<MainboardDto> getList(MainboardDto dto) {
		
		return dao.getList(dto);
	}

	@Override
	public int getTotalCnt(MainboardDto dto) {
		
		return dao.getTotalCnt(dto);
	}

	@Override
	public MainboardDto getView(long id) {
		
		return dao.getView(id);
	}

	@Override
	public void insert(MainboardDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public void update(MainboardDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(MainboardDto dto) {
		dao.delete(dto);
		
	}
	

}
