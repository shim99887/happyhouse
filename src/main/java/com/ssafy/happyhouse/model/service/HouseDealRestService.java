package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

public interface HouseDealRestService {
	
	public List<HouseDealDto> findAllHouseDeal() throws Exception;
	
	public List<SidoGugunCodeDto> getSido() throws Exception;
	
	public  List<SidoGugunCodeDto> getGoon(String sido) throws Exception;
	
	public  List<String> getDong(String gugun) throws Exception;
}
