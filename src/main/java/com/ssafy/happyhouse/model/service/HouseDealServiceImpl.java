package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.DongCodeDto;
import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.mapper.HouseDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService{
	@Autowired
	private HouseDealMapper dao;

	@Override
	public List<HouseDealDto> searchAll() {
		return dao.searchAll();
	}

	@Override
	public HouseDealDto search(String no) {
		return dao.search(no);
	}

	@Override
	public List<HouseDealDto> searchApt(String aptName) {
		return dao.searchApt(aptName);
	}

	@Override
	public List<HouseDealDto> searchDong(String dong) {
		return dao.searchDong(dong);
	}

	@Override
	public List<HouseDealDto> searchType(String type) {
		return dao.searchType(type);
	}

	@Override
	public List<SidoGugunCodeDto> searchSido() {
		List<SidoGugunCodeDto> list = dao.searchSido();
		System.out.println(list);
		return list;
	}

	@Override
	public HouseDealDto searchDetail(String no) {
		return dao.searchDetail(no);
	}

	@Override
	public List<SidoGugunCodeDto> searchGugun() {
		return dao.searchGugun();
	}

	@Override
	public List<DongCodeDto> searchDongName() {
		return dao.searchDongName();
	}



}
