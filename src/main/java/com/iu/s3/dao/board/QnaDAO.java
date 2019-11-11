package com.iu.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s3.model.board.QnaVO;


@Repository
public class QnaDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	private static final String NAMESPACE = "qnaMapper.";
	
	
	public int qnaInsert(QnaVO qnaVO) throws Exception{
		return sqlsession.insert(NAMESPACE+"qnaInsert", qnaVO);
		
	}
	
	/*
	 * public List<QnaVO> qnaList() throws Exception{ return
	 * sqlsession.selectList(NAMESPACE+"qnaList"); }
	 */
}
