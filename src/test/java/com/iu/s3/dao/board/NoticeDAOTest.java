package com.iu.s3.dao.board;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.NoticeVO;

public class NoticeDAOTest extends TestAbstractCase{
	@Inject
	private SqlSession sqlsession;
	
	@Inject
	private NoticeDAO noticeDAO;
	
	//@Test
	public void checkDAO() throws Exception{
		assertNotNull(noticeDAO);
	}
	
	//@Test
	public void noticeInsertTest() throws Exception{
		for(int i=50; i <100; i++) {
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setTitle("테스트"+i);
		noticeVO.setWriter("작성자"+i);
		noticeVO.setContents("테스트내용"+i);
		int result = noticeDAO.noticeInsert(noticeVO);
		}
		//assertEquals(1, result);
		
	}
	
	//@Test
	public void noticeDeleteTest() throws Exception{
		
		int num=1;
		
		num = noticeDAO.noticeDelete(num);
		
		assertEquals(1, num);
		
	}
	
	//@Test
	public void noticeSelectOneTest() throws Exception{
		int num=2;
		
		NoticeVO noticeVO = noticeDAO.noticeSelectOne(num);
		
		assertNotNull(noticeVO);
		
	}

	//@Test
	public void noticeListTest() throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		List<NoticeVO> ar = noticeDAO.noticeList(map);
		
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void noticeCountTest() throws Exception{
		
		int num = noticeDAO.noticeCount();
		assertEquals(106, num);
	}
	
	//@Test
	public void noticeUpdateTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setTitle("test33");
		noticeVO.setNum(2);
		noticeVO.setContents("test33");
		
		int result = noticeDAO.noticeUpdate(noticeVO);
		
		
		assertEquals(1, result);
	}
	//@Test
	public void noticeSelectP() throws Exception{
		
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO = noticeDAO.noticeSelectP(5);
		
		assertEquals(3, noticeVO.getNum());
		
	}
	
	//@Test
	public void noticeSelectN() throws Exception{
		
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO = noticeDAO.noticeSelectP(5);
		
		assertEquals(6, noticeVO.getNum());
		
	}
	
}
