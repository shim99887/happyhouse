package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.NoticeDto;

@Mapper
public interface NoticeMapper {
	
	List<NoticeDto> getAllNotice();
	
	NoticeDto getNoticeDetail(String no);
	
	void deleteNotice(String no);
	
	void updateNotice(NoticeDto dto);
	
	void registNotice(NoticeDto dto);
}
