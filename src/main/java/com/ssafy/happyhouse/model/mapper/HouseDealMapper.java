package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.DongCodeDto;
import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

@Mapper
public interface HouseDealMapper {

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
