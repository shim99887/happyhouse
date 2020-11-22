package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.QnaDto;

public interface QnaService {
	List<QnaDto> findAllQna();
	
	QnaDto findQna(String no);
	
	void registQna(QnaDto qna);
	
	void updateQna(QnaDto qna);
	
	void deleteQna(String no);
	
	void registQnaReply(QnaDto qna);
	
	QnaDto getQnaReply(String no);
	
	void deleteQnaReply(String no);
}
