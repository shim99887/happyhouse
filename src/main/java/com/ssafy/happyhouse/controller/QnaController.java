package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.QnaDto;
import com.ssafy.happyhouse.model.service.QnaService;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/qna")
public class QnaController {
	
	@Autowired
	QnaService qnaService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<QnaDto>> findAllQna() throws Exception {
		List<QnaDto> qnas = qnaService.findAllQna();
		if (qnas.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QnaDto>>(qnas, HttpStatus.OK);
	}
	
	@GetMapping("/detail/{no}")
	public ResponseEntity<QnaDto> findQna(@PathVariable String no) throws Exception{
		QnaDto qna = qnaService.findQna(no);
		if(qna == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<QnaDto>(qna, HttpStatus.OK);
	}
	
 	@RequestMapping(value = "/regist", method = RequestMethod.POST)
   	public ResponseEntity<Integer> registQna(@RequestBody QnaDto qna) throws Exception {
 		System.out.println(qna);
   		qnaService.registQna(qna);
   		return new ResponseEntity<Integer>(0, HttpStatus.OK);
   	}
 	
 	@PutMapping
   	public ResponseEntity<Integer> updateQna(@RequestBody QnaDto qna) throws Exception {
 		System.out.println(qna);
   		qnaService.updateQna(qna);
   		return new ResponseEntity<Integer>(0, HttpStatus.OK);
   	}
 	
 	@DeleteMapping("/delete")
 	public  ResponseEntity<Integer> deleteQna(@RequestParam String no) throws Exception {
 		System.out.println(no);
   		qnaService.deleteQna(no);
   		return new ResponseEntity<Integer>(0, HttpStatus.OK);
   	}
 	
 	@PostMapping("/reply/regist")
   	public ResponseEntity<Integer> registQnaReply(@RequestBody QnaDto qna) throws Exception {
 		System.out.println(qna);
   		qnaService.registQnaReply(qna);
   		return new ResponseEntity<Integer>(0, HttpStatus.OK);
   	}
 	
 	@GetMapping("/reply/detail/{no}")
   	public ResponseEntity<QnaDto> getQnaReply(@PathVariable String no) throws Exception {
		QnaDto qna = qnaService.getQnaReply(no);
		
		if(qna == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<QnaDto>(qna, HttpStatus.OK);
   	}
 	
 	@DeleteMapping("/reply/delete")
 	public  ResponseEntity<Integer> deleteQnaReply(@RequestParam String no) throws Exception {
 		System.out.println(no);
   		qnaService.deleteQnaReply(no);
   		return new ResponseEntity<Integer>(0, HttpStatus.OK);
   	}
}
