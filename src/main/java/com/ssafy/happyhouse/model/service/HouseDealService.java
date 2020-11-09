package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.HouseDealDto;

public interface HouseDealService {
	public List<HouseDealDto> searchAll();
	public HouseDealDto search(String no);
	public List<HouseDealDto> searchApt(String aptName);
	public List<HouseDealDto> searchDong(String dong);
	public List<HouseDealDto> searchType(String type);
}
