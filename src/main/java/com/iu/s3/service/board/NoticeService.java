package com.iu.s3.service.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s3.dao.board.NoticeDAO;
import com.iu.s3.model.board.NoticeVO;

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
	
	public Map<String, Object> noticeList(int curPage) throws Exception{
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		int startnum = (curPage-1)*10+1;
		int lastnum = curPage*10;
		
		map.put("startRow", startnum);
		map.put("lastRow", lastnum);
		List<NoticeVO> ar = noticeDAO.noticeList(map);
		int total = noticeDAO.noticeCount();
		
		int totalPage = total/10;
		
		if(total%10 != 0) {
			totalPage = totalPage + 1;
		}
		
		//totalBlock 갯수
		
		int totalBlock = totalPage /5;
		if(totalPage%5 !=0)
			totalBlock = totalBlock + 1;
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("totalPage", totalPage);
		map2.put("list", ar);
		
		return map2;
	}
}
