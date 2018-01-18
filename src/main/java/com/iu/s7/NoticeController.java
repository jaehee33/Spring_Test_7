package com.iu.s7;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.board.BoardDTO;
import com.iu.notice.NoticeService;
import com.iu.util.ListData;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList")
	public ModelAndView selectList(ListData listData) throws Exception{
		System.out.println("search: "+listData.getSearch());
		System.out.println("kind: "+listData.getKind());
		System.out.println("curPage: "+listData.getCurPage());
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.selectList(listData);
		mv.addObject("list", ar);
		mv.addObject("page", listData);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardList");
		return mv;
		
	}
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String insert(Model model){
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String insert2(BoardDTO boardDTO) throws Exception{
		noticeService.insert(boardDTO);
		return "redirect:./noticeList";
		
		//common 방법
		/*int result = noticeService.insert(boardDTO);
		ModelAndView mv = new ModelAndView();
		String message="Fail";
		if(result>0){
			message="Success";
		}
		mv.addObject("message", message);
		mv.addObject("path", noticeList);
		mv.setViewName("common/result");*/
		
	}

}
