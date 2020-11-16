package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

@Mapper
public interface HouseDealRestMapper {

	public List<HouseDealDto> findAllHouseDeal() throws Exception;
	
	public List<SidoGugunCodeDto> getSido() throws Exception;
	
	public  List<SidoGugunCodeDto> getGoon(String sido) throws Exception;
	
	public List<Map<String, String>> getDong(String gugun) throws Exception;
}
