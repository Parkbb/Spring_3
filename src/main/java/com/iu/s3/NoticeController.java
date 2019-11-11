package com.iu.s3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s3.model.board.NoticeVO;
import com.iu.s3.service.board.NoticeService;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	//list : /notice/noticeList GET
	//WEB-INF/views/notice/noticeList.jsp
	@RequestMapping("noticeList")
	public void noticeList(Model model, @RequestParam(defaultValue = "1") int curPage) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = noticeService.noticeList(curPage);
		
		List<NoticeVO> ar = (List<NoticeVO>)map.get("list");
		int totalPage = (Integer)map.get("totalPage");
		
		model.addAttribute("List", ar);
		model.addAttribute("totalPage", totalPage);
	}
	
	@RequestMapping("noticeSelect")
	public ModelAndView noticeSelect(int num) throws Exception{
		
		NoticeVO noticeVO = noticeService.noticeSelectOne(num);
	
		
		ModelAndView mv = new ModelAndView();
		
		if(noticeVO != null) {
			mv.addObject("dto", noticeVO);

			mv.setViewName("/notice/noticeSelect");
			
		}else {
			mv.addObject("msg", "없는 글입니다");
			mv.addObject("path", "noticeList");
			mv.setViewName("common/common_result");
		}
		
		noticeService.noticeHitup(noticeVO);
		return mv;
		
	}
	
	
	@RequestMapping(value =  "noticeUpdate" ,method = RequestMethod.GET)
	public ModelAndView noticeUpdate(int num) throws Exception{
		
		NoticeVO noticeVO = noticeService.noticeSelectOne(num);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("dto", noticeVO);
		mv.setViewName("/notice/noticeUpdate");
		
		return mv;
	}
	
	@RequestMapping(value = "noticeUpdate", method = RequestMethod.POST)
	public ModelAndView noticeUpdate(NoticeVO noticeVO) throws Exception{
		
		int result = noticeService.noticeUpdate(noticeVO);
		ModelAndView mv = new ModelAndView();
		String msg = "수정 실패";
		if(result >0) {
			msg = "수정 성공";
			
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeWrite")
	public void noticeWrite() {
		
	}
	
	@RequestMapping(value = "noticeWrite", method = RequestMethod.POST)
	public ModelAndView noticeWrite(NoticeVO noticeVO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.noticeInsert(noticeVO);
		
		String msg = "글쓰기 실패";
		if(result > 0) {
			msg = "글쓰기 성공";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
	}
	
	@RequestMapping("noticeDelete")
	public ModelAndView noticeDelete(int num) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		int result = noticeService.noticeDelete(num);
		
		String msg = "삭제 실패";
		if(result>0) {
			msg = "삭제 성공";
		}
		mv.addObject("msg", msg);
		mv.addObject("path", "noticeList");
		mv.setViewName("common/common_result");
		
		return mv;
		
	}
}
