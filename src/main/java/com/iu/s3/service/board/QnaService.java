package com.iu.s3.service.board;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s3.dao.board.NoticeDAO;
import com.iu.s3.dao.board.QnaDAO;
import com.iu.s3.model.board.QnaVO;
import com.iu.s3.util.Pager;
import com.iu.s3.util.RowMaker;

@Service
public class QnaService {

	@Inject
	private QnaDAO qnaDAO;
	
	public int qnaInsert(QnaVO qnaVO) throws Exception{
		
		return qnaDAO.qnaInsert(qnaVO);
	}
	
	public List<QnaVO> qnaList(Pager pager) throws Exception{
		//DB rownum 계산
		pager.makeRow();
		pager.makePage(qnaDAO.qnaCount());
		return qnaDAO.qnaList(pager);
	}
}
