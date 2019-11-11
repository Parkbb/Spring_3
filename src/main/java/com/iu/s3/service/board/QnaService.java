package com.iu.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iu.s3.dao.board.QnaDAO;
import com.iu.s3.model.board.QnaVO;

@Service
public class QnaService {

	@Inject
	private QnaDAO qnaDAO;
	
	public int qnaInsert(QnaVO qnaVO) throws Exception{
		
		return qnaDAO.qnaInsert(qnaVO);
	}
	
	//public List<QnaVO> qnaList() throws Exception{
		//return qnaDAO.qnaList();
	//}
}
