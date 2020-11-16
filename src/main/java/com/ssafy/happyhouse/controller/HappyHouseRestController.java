package com.ssafy.happyhouse.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseDealRestService;

@RestController
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RequestMapping("/api")
public class HappyHouseRestController {
	
	@Autowired
	private HouseDealRestService service;
	
	@RequestMapping(value = "/employee/all", method = RequestMethod.GET)
	public ResponseEntity<List<HouseDealDto>> findAllHouseDeal() throws Exception {
		List<HouseDealDto> housedeals = service.findAllHouseDeal();
		if (housedeals.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<HouseDealDto>>(housedeals, HttpStatus.OK);
	}
	
	@GetMapping(value = "/map/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> getSido() throws Exception{
		List<SidoGugunCodeDto> sido = service.getSido();
		if (sido.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SidoGugunCodeDto>>(sido, HttpStatus.OK);
	}
	
	@GetMapping(value = "/map/goon")
	public ResponseEntity<List<SidoGugunCodeDto>> getGoon(@RequestParam String sido) throws Exception{
		System.out.println(sido);
		 List<SidoGugunCodeDto> goon = service.getGoon(sido);
		System.out.println(goon);
		if (goon.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity< List<SidoGugunCodeDto>>(goon, HttpStatus.OK);
	}
	
	@GetMapping(value = "/map/dong")
	public ResponseEntity<List<String>> getDong(@RequestParam String gugun) throws Exception{
		System.out.println(gugun);
		 List<String> dong = service.getDong(gugun);
		System.out.println(dong);
		if (dong.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity< List<String>>(dong, HttpStatus.OK);
	}
	
}
