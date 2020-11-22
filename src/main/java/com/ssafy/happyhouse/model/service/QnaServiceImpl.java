package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.QnaDto;
import com.ssafy.happyhouse.model.mapper.QnaMapper;

@Service
public class QnaServiceImpl implements QnaService{

	@Autowired
	private QnaMapper dao;
	
	@Override
	public List<QnaDto> findAllQna() {
		return dao.findAllQna();
	}
	
	@Override
	public QnaDto findQna(String no) {
		// TODO Auto-generated method stub
		return dao.findQna(no);
	}
	
	@Override
	public void registQna(QnaDto qna) {
		dao.registQna(qna);
	}
	
	@Override
	public void updateQna(QnaDto qna) {
		// TODO Auto-generated method stub
		dao.updateQna(qna);
	}
	
	@Override
	public void deleteQna(String no) {
		// TODO Auto-generated method stub
		dao.deleteQna(no);
	}
	
	@Override
	public void registQnaReply(QnaDto qna) {
		// TODO Auto-generated method stub
		dao.registQnaReply(qna);
	}
	
	@Override
	public QnaDto getQnaReply(String no) {
		// TODO Auto-generated method stub
		return dao.getQnaReply(no);
	}
	
	@Override
	public void deleteQnaReply(String no) {
		// TODO Auto-generated method stub
		dao.deleteQnaReply(no);
	}
}
