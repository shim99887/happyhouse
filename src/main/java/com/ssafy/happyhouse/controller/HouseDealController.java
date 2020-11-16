package com.ssafy.happyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.happyhouse.model.service.HouseDealService;

@Controller
@RequestMapping("/housedeal")
public class HouseDealController {
	@Autowired
	HouseDealService houseDealService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String searchAll(Model model) {
		model.addAttribute("list", houseDealService.searchAll());
		return "housedeal/test";
	}
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("no") String no, Model model) {
		try {
			model.addAttribute("list", houseDealService.search(no));
			return "housedeal/search";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 도중 오류 발견");
			return "error/error";
		}
	}
	
	@RequestMapping(value = "/searchApt", method = RequestMethod.GET)
	public String searchApt(@RequestParam("aptName") String aptName, Model model) {
		try {
			model.addAttribute("list", houseDealService.searchApt(aptName));
			return "housedeal/search";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 도중 오류 발견");
			return "error/error";
		}
	}
	@RequestMapping(value = "/searchDong", method = RequestMethod.GET)
	public String searchDong(@RequestParam("dong") String dong, Model model) {
		try {
			model.addAttribute("list", houseDealService.searchDong(dong));
			return "housedeal/search";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 도중 오류 발견");
			return "error/error";
		}
	}
	@RequestMapping(value = "/searchType", method = RequestMethod.GET)
	public String searchType(@RequestParam("type") String type, Model model) {
		try {
			model.addAttribute("list", houseDealService.searchType(type));
			return "housedeal/search";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "검색 도중 오류 발견");
			return "error/error";
		}
	}

}
