package com.iu.s3;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.iu.s3.dao.board.NoticeDAO;

public class SqlSessionTest extends TestAbstractCase{
	
	@Inject
	private SqlSession sqlsession;
	
	@Inject
	private NoticeDAO n;
	
	@Test
	public void sqlTest() {
		
		assertNotNull(sqlsession);
	}

}
