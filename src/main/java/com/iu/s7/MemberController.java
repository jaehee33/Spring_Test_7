package com.iu.s7;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	/*Logout*/
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session){
		session.invalidate();
		return "redirect:../";
	}
	/*delete*/
	@RequestMapping(value="memberDelete")
	public String memberDelete(MemberDTO memberDTO, HttpSession session)throws Exception{
		memberDTO = (MemberDTO)session.getAttribute("member");
		memberService.memberDelete(memberDTO);
		return "redirect:../";
	}
	/*update*/
	@RequestMapping(value="memberUpdate", method=RequestMethod.GET)
	public ModelAndView update(MemberDTO memberDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
			memberDTO = memberService.memberView(memberDTO);
		if(memberDTO != null){
			session.setAttribute("m2", memberDTO);
			mv.addObject("message", "update success");
			mv.addObject("path", "./memberUpdate");
		}else{
			mv.addObject("message", "update fail");
			mv.addObject("path", "../");
		}
		mv.setViewName("common/result");
		return mv;
	}
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public ModelAndView update2(MemberDTO memberDTO, HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.memberUpdate(memberDTO);
		if(result>0){
			session.setAttribute("m2", memberDTO);
			mv.addObject("message", "update success");
		}else{
			mv.addObject("message", "update2 fail");
		}
		mv.addObject("path", "./memberView");
		mv.setViewName("common/result");
		return mv;
	}
	/*View*/
	@RequestMapping(value="memberView")
	public void memberView(){
	}
	
	/*Login*/
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public void memberLogin(){
	}
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberDTO = memberService.memberLogin(memberDTO);
		if(memberDTO!=null){
			session.setAttribute("member", memberDTO);
			mv.addObject("message", "Login success");
			mv.addObject("path", "../");
		}else{
			mv.addObject("message", "Login fail");
			mv.addObject("path", "./memberLogin");
		}
		mv.setViewName("common/result");
		return mv;
	} 
	
	/*Join*/
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void memberJoin(){
	}
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO) throws Exception{
		memberService.memberJoin(memberDTO);
		return "redirect:../";

	}
	

}
