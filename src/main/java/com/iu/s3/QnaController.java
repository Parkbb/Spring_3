package com.iu.s3;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.model.board.QnaVO;
import com.iu.s3.service.board.QnaService;
import com.iu.s3.util.Pager;

import oracle.net.aso.q;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Inject
	private QnaService qnaService;
	
	@RequestMapping("qnaReply")
	public Model qnaReply (int num, Model model) {
		
		model.addAttribute("num", num);
		
		return model;
	}
	
	@RequestMapping(value = "qnaReply", method = RequestMethod.POST)
	public String qnaReply (QnaVO qnaVO) throws Exception{
		int result = qnaService.qnaReply(qnaVO);
		
		return "redirect:./qnaList";
	}
	
	@RequestMapping("qnaList")
	public void qnaList(Model model, Pager pager) throws Exception{
		
		List<QnaVO> ar = qnaService.qnaList(pager);
		
		model.addAttribute("List", ar);
		model.addAttribute("pager", pager);
		
	}
	
	@RequestMapping("qnaWrite")
	public void qnaWrite() throws Exception{
		
	}
	
	
	
	@RequestMapping(value = "qnaWrite", method = RequestMethod.POST)
	public ModelAndView qnaWrite(QnaVO qnaVO) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		int result = qnaService.qnaWrite(qnaVO);
		
		String msg = "글쓰기 실패";
		if(result > 0) {
			msg = "글쓰기 성공";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "qnaList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("qnaSelect")
	public Model qnaSelect(Model model, int num)throws Exception{
		
		model.addAttribute("dto", qnaService.qnaSelect(num));
		
		
		return model;
	}
	

}
