package com.ssafy.happyhouse.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.http.HttpStatus;
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
		Elements content = doc.select("div.caseTable");
		
		CoronaDto corona = new CoronaDto();
		
		Elements el = content.select("div");
		
		corona.setTotalCnt(el.get(0).select("ul li dl dd").get(0).html());
		
		
		corona.setTodayCnt(el.get(0).select("ul li").get(1).select("dl dd ul li p").get(0).html());
		corona.setTodayFromKorea(el.get(0).select("ul li").get(1).select("dl dd ul li p").get(1).html());
		corona.setTodayFromAbroad(el.get(0).select("ul li").get(1).select("dl dd ul li p").get(2).html());
		
		corona.setFreeTotal(el.get(2).select("ul li dl dd").get(0).html());
		corona.setTodayFree(el.get(2).select("ul li dl dd span").html());
		
		corona.setIsolateTotal(el.get(3).select("ul li dl dd").get(0).html());
		corona.setIsolateToday(el.get(3).select("ul li dl dd span").get(0).html());
		
		corona.setDeadTotal(el.get(4).select("ul li dl dd").get(0).html());
		corona.setDeadToday(el.get(4).select("ul li dl dd span").get(0).html());
		
		
		return new ResponseEntity<CoronaDto>(corona, HttpStatus.ACCEPTED);
	}
}
