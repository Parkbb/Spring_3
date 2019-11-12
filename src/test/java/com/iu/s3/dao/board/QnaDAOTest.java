package com.iu.s3.dao.board;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.iu.s3.TestAbstractCase;
import com.iu.s3.model.board.QnaVO;

public class QnaDAOTest extends TestAbstractCase{
	
	@Inject
	private SqlSession sqlSession;
	
	@Inject
	private QnaDAO qnaDAO;
	
	//@Test
	public void testsqlSession() throws Exception{
		
		assertNotNull(sqlSession);
	}
	
	//@Test
	public void testqnaInsert() throws Exception{
		
		for (int i = 0; i < 150; i++) {
			
		QnaVO qnaVO = new QnaVO();
		
		qnaVO.setTitle("testtitle"+i);
		qnaVO.setWriter("testwriter"+i);
		qnaVO.setContents("testcontents"+i);
		
		int result = qnaDAO.qnaInsert(qnaVO);
		Thread.sleep(50);
		}
		
		//assertEquals(1, result);
	}
	
	@Test
	public void testqnaCount() throws Exception{
		
		
		
		
	}

}
