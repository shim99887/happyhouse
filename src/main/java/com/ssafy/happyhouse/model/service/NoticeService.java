package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.NoticeDto;

public interface NoticeService {

	List<NoticeDto> getAllNotice();
	
	NoticeDto getNoticeDetail(String no);
	
	void deleteNotice(String no);
	
	void updateNotice(NoticeDto dto);
	
	void registNotice(NoticeDto dto);
}
