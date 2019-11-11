package com.iu.s3;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.s3.model.board.QnaVO;
import com.iu.s3.service.board.QnaService;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	@RequestMapping("qnaList")
	public void qnaList() throws Exception{
		
		
	}
	
	@RequestMapping("qnaWrite")
	public void qnaInsert(QnaVO qnaVO) throws Exception{
		
		int result = qnaService.qnaInsert(qnaVO);
		
	}
}
