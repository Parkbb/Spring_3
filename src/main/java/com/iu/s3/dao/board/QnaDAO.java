package com.iu.s3.dao.board;

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
}
