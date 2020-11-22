package com.ssafy.happyhouse.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.CoronaDto;

@RestController
@RequestMapping("/crawling")
public class CrawlingController {
	
	@GetMapping("/corona")
	ResponseEntity<CoronaDto> getCoronaInfo() throws IOException{
		String url = "http://ncov.mohw.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=";
		
		Document doc = Jsoup.connect(url).get();
		Elements content = doc.select("div ul li dl");
		System.out.println(content);
		
		return null;
	}
}
