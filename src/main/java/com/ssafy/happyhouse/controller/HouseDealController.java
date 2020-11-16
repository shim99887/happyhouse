package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.HouseDealDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseDealService;

@Controller
@RequestMapping("/housedeal")
public class HouseDealController {
	@Autowired
	HouseDealService houseDealService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET,  headers = { "Content-type=application/json" })
	public String searchAll(Model model) {
		System.out.println(houseDealService.searchSido());
		model.addAttribute("list", houseDealService.searchAll());
		model.addAttribute("sidos", houseDealService.searchSido());
//		model.addAttribute("guguns", houseDealService.searchGugun());
//		model.addAttribute("dongs", houseDealService.searchDongName());
		return "housedeal/test";
	}

	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("no") String no, Model model) {
		try {
			model.addAttribute("list", houseDealService.search(no));
			return "housedeal/test";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 도중 오류 발견");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/searchApt", method = RequestMethod.GET,  headers = { "Content-type=application/json" })
	public String searchApt(@RequestParam("aptName") String aptName, Model model) {
		try {
			model.addAttribute("list", houseDealService.searchApt(aptName));
			return "housedeal/test";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 도중 오류 발견");
			return "error/error";
		}
	}
	@RequestMapping(value = "/searchDong", method = RequestMethod.GET,  headers = { "Content-type=application/json" })
	public String searchDong(@RequestParam("dong") String dong, Model model) {
		try {
			System.out.println(dong);
			List<HouseDealDto> deals = houseDealService.searchDong(dong);
			System.out.println(deals);
			model.addAttribute("list", houseDealService.searchDong(dong));
			return "housedeal/test";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 도중 오류 발견");
			return "error/error";
		}
	}
	@RequestMapping(value = "/searchType", method = RequestMethod.GET,  headers = { "Content-type=application/json" })
	public String searchType(@RequestParam("type") String type, Model model) {
		try {
			model.addAttribute("list", houseDealService.searchType(type));
			return "housedeal/test";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 도중 오류 발견");
			return "error/error";
		}
	}

	@RequestMapping(value = "/searchDetail", method = RequestMethod.GET)
	public String searchDetail(@RequestParam("no") String no, Model model) {
		try {
			model.addAttribute("detail", houseDealService.searchDetail(no));
			return "housedeal/test";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 도중 오류 발견");
			return "error/error";
		}
	}
}
