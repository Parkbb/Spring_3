package com.iu.s3.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.s3.model.board.NoticeVO;

@Repository
public class NoticeDAO {
	
	@Inject
	private SqlSession sqlsession;
	private static final String NAMESPACE = "noticeMapper."; 
	
	
	public int noticeInsert(NoticeVO noticeVO) throws Exception{
		
		
		return sqlsession.insert(NAMESPACE+"noticeInsert", noticeVO);
		
	}
	
	public int noticeDelete(int num) throws Exception{
		
		return sqlsession.delete(NAMESPACE+"noticeDelete", num);
	}
	
	
	public NoticeVO noticeSelectOne(int num) throws Exception{
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		
		return sqlsession.selectOne(NAMESPACE+"noticeSelectOne", map);
	}
	
	public List<NoticeVO> noticeList() throws Exception{
		return sqlsession.selectList(NAMESPACE+"noticeList");
	}
	
	public int noticeUpdate(NoticeVO noticeVO) throws Exception{
		
		int result = sqlsession.update(NAMESPACE+"noticeUpdate", noticeVO);
		
		return result;
	}
	
	public int noticeHitup(NoticeVO noticeVO) throws Exception{
		
		noticeVO.setHit(noticeVO.getHit()+1);
		
		int result = sqlsession.update(NAMESPACE+"noticeHitup", noticeVO);
		
		return result;
	}
	
	public NoticeVO noticeSelectP(int num) throws Exception{
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		
		return sqlsession.selectOne(NAMESPACE+"noticeSelectP", map);
		
	}
	
	public NoticeVO noticeSelectN(int num) throws Exception{
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		
		return sqlsession.selectOne(NAMESPACE+"noticeSelectN", map);
		
		
	}
	
}
