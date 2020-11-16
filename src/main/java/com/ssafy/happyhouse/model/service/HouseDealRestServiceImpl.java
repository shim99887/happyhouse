package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.mapper.HouseDealRestMapper;

@Service
public class HouseDealRestServiceImpl implements HouseDealRestService{

	@Autowired
	private HouseDealRestMapper dao;
	
	@Override
	public List<HouseDealDto> findAllHouseDeal() throws Exception {
		// TODO Auto-generated method stub
		return dao.findAllHouseDeal();
	}
	
	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		// TODO Auto-generated method stub
		return dao.getSido();
	}
	
	@Override
	public  List<SidoGugunCodeDto> getGoon(String sido) throws Exception {
		// TODO Auto-generated method stub
		return dao.getGoon(sido.substring(0,2));
	}
	
	@Override
	public List<Map<String,String>> getDong(String gugun) throws Exception {
		List<Map<String, String>>map = dao.getDong(gugun);
		System.out.println(map);
		return map;
	}
}
