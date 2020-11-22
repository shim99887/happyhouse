package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.service.NoticeService;

@RestController
@RequestMapping("/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<NoticeDto>> findAllNotice() throws Exception {
		List<NoticeDto> notices = service.getAllNotice();
		if (notices.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<NoticeDto>>(notices, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<NoticeDto> findNoticeDetail(@PathVariable String no) throws Exception{
		NoticeDto notice = service.getNoticeDetail(no);
		if(notice == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<NoticeDto>(notice, HttpStatus.OK);
	}
	
 	@RequestMapping(value = "/regist", method = RequestMethod.POST)
   	public ResponseEntity<Integer> registNotice(@RequestBody NoticeDto notice) throws Exception {
 		System.out.println(notice);
   		service.registNotice(notice);
   		return new ResponseEntity<Integer>(0, HttpStatus.OK);
   	}
 	
 	@PutMapping
   	public ResponseEntity<Integer> updateNotice(@RequestBody NoticeDto notice) throws Exception {
 		System.out.println(notice);
   		service.updateNotice(notice);
   		return new ResponseEntity<Integer>(0, HttpStatus.OK);
   	}
 	
 	@DeleteMapping("/delete")
 	public  ResponseEntity<Integer> deleteNotice(@RequestParam String no) throws Exception {
 		System.out.println(no);
   		service.deleteNotice(no);
   		return new ResponseEntity<Integer>(0, HttpStatus.OK);
   	}

}
