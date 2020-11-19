package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.HouseDealDto;
//lab.ssafy.com/sjbok090/happyhouse_spring.git
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
			List<HouseDealDto> list = houseDealService.searchDong(dong);
			model.addAttribute("list", list);
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
