package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.HouseDealDto;

@Mapper
public interface HouseDealMapper {

	public List<HouseDealDto> searchAll();
	public HouseDealDto search(String no);
	public List<HouseDealDto> searchApt(String aptName);
	public List<HouseDealDto> searchDong(String dong);
	public List<HouseDealDto> searchType(String type);
}
