package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.QnaDto;

@Mapper
public interface QnaMapper {
	List<QnaDto> findAllQna();
	
	QnaDto findQna(String no);
	
	void registQna(QnaDto qna);
	
	void updateQna(QnaDto qna);
	
	void deleteQna(String no);
	
	void registQnaReply(QnaDto qna);
	
	QnaDto getQnaReply(String no);
	
	void deleteQnaReply(String no);
}
