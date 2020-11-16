package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.DongCodeDto;
import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

public interface HouseDealService {
	public List<HouseDealDto> searchAll();
	public HouseDealDto search(String no);
	public HouseDealDto searchDetail(String no);
	public List<HouseDealDto> searchApt(String aptName);
	public List<HouseDealDto> searchDong(String dong);
	public List<HouseDealDto> searchType(String type);
	public List<SidoGugunCodeDto> searchSido();
	public List<SidoGugunCodeDto> searchGugun();
	public List<DongCodeDto> searchDongName();
}
