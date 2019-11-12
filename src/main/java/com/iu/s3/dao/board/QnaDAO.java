package com.iu.s3.dao.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s3.model.board.QnaVO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.RowMaker;


@Repository
public class QnaDAO {
	
	@Inject
	private SqlSession sqlsession;
	
	private static final String NAMESPACE = "qnaMapper.";
	
	
	public int qnaInsert(QnaVO qnaVO) throws Exception{
		return sqlsession.insert(NAMESPACE+"qnaInsert", qnaVO);
		
	}
	
	public List<QnaVO> qnaList(Pager pager) throws Exception{ 
		
		return sqlsession.selectList(NAMESPACE+"qnaList", pager); 
	 
	}
	public int qnaCount(Pager pager) throws Exception{
		return sqlsession.selectOne(NAMESPACE+"qnaCount", pager);
	} 
}
