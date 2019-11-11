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
	
	@Test
	public void testqnaInsert() throws Exception{
		
		QnaVO qnaVO = new QnaVO();
		
		qnaVO.setTitle("testtitle");
		qnaVO.setWriter("testwriter");
		qnaVO.setContents("testcontents");
		
		int result = qnaDAO.qnaInsert(qnaVO);
		
		assertEquals(1, result);
	}

}
