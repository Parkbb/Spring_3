package com.iu.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.QnaVO;
import com.iu.s3.service.board.QnaService;
import com.iu.s3.util.Pager;

public class QnaServiceTest extends TestAbstractCase{

	@Inject
	private QnaService qnaservice;
	
	
	@Test
	public void qnaListTest() throws Exception{
		
		Pager pager = new Pager();
		
		pager.makePage(110);
		//List<QnaVO> ar = qnaservice.qnaList(pager);
		
		//assertNotEquals(0, ar.size());
		//assertEquals(1, (int)pager.getStartRow());
		//assertEquals(10, (int)pager.getLastRow());
		//assertEquals(1, (int)pager.getCurBlock());
		assertEquals(1, (int)pager.getStartNum());
		assertEquals(5, (int)pager.getLastNum());
		
	}
}
