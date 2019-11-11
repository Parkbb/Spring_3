package com.iu.s3.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s3.dao.board.NoticeDAO;
import com.iu.s3.model.board.NoticeVO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.RowMaker;

@Service
public class NoticeService {
	
	@Inject
	private NoticeDAO noticeDAO;
	
	public int noticeHitup(NoticeVO noticeVO) throws Exception{
		
		return noticeDAO.noticeHitup(noticeVO);
	}
	
	
	public int noticeInsert(NoticeVO noticeVO) throws Exception{
		
		return noticeDAO.noticeInsert(noticeVO);
	}
	
	public int noticeDelete(int num)throws Exception{
		
		return noticeDAO.noticeDelete(num);
	}
	
	public int noticeUpdate(NoticeVO noticeVO) throws Exception{
		
		return noticeDAO.noticeUpdate(noticeVO);
		
	}
	
	public NoticeVO noticeSelectOne(int num) throws Exception{
		
		return noticeDAO.noticeSelectOne(num);
	}
	
	public List<NoticeVO> noticeList(Pager pager) throws Exception{
		
		RowMaker rowMaker = pager.makeRow();
		pager.makePager(noticeDAO.noticeCount());
		
		
		return noticeDAO.noticeList(rowMaker);
	}
}
