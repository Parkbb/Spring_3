package com.iu.s3;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.s3.model.board.QnaVO;
import com.iu.s3.service.board.QnaService;
import com.iu.s3.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	@RequestMapping("qnaList")
	public void qnaList(Model model, Pager pager) throws Exception{
		
		List<QnaVO> ar = qnaService.qnaList(pager);
		
		model.addAttribute("List", ar);
		model.addAttribute("pager", pager);
	}
	
	@RequestMapping("qnaWrite")
	public void qnaInsert(QnaVO qnaVO) throws Exception{
		
		int result = qnaService.qnaInsert(qnaVO);
		
	}
}
