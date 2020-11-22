package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService{

	@Autowired
	private NoticeMapper dao;
	
	@Override
	public List<NoticeDto> getAllNotice() {
		// TODO Auto-generated method stub
		return dao.getAllNotice();
	}

	@Override
	public NoticeDto getNoticeDetail(String no) {
		// TODO Auto-generated method stub
		return dao.getNoticeDetail(no);
	}

	@Override
	public void deleteNotice(String no) {
		// TODO Auto-generated method stub
		dao.deleteNotice(no);
	}

	@Override
	public void updateNotice(NoticeDto dto) {
		// TODO Auto-generated method stub
		dao.updateNotice(dto);
	}

	@Override
	public void registNotice(NoticeDto dto) {
		// TODO Auto-generated method stub
		dao.registNotice(dto);
	}

}
