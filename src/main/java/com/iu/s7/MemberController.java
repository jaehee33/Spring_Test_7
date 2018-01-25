package com.iu.s7;

import java.io.File;

import javax.inject.Inject;
import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;
import com.iu.util.FileSaver;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	
	@Inject
	private MemberService memberService;
	
	/*idCheck*/
	@RequestMapping(value="memberIdCheck")
	public ModelAndView memberIdCheck(String id)throws Exception{
		MemberDTO memberDTO = memberService.memberIdCheck(id);
		ModelAndView mv = new ModelAndView();
		int result = 1;
		if(memberDTO != null){
			result = 0;
		}
		mv.addObject("result", result);
		mv.setViewName("common/fileResult");
		return mv;
	}
	
	
	/*Logout*/
	@RequestMapping(value="memberLogout")
	public String memberLogout(HttpSession session){
		session.invalidate();
		return "redirect:../";
	}
	/*delete*/
	@RequestMapping(value="memberDelete")
	public String memberDelete(HttpSession session, RedirectAttributes ra)throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result =memberService.memberDelete(memberDTO, session);
		String message="Fail";
		if(result>0){
			System.out.println(result);
		message="success";
		session.invalidate();
		}
		ra.addFlashAttribute("message", message);
		return "redirect:../";
	}
	/*update*/
	@RequestMapping(value="memberUpdate", method=RequestMethod.GET)
	public void update(){
	}
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public ModelAndView update2(MemberDTO memberDTO, HttpSession session, MultipartFile f1)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = memberService.memberUpdate(memberDTO, f1, session);
		if(result>0){
			session.setAttribute("member", memberDTO);
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
	public String memberJoin(MemberDTO memberDTO, MultipartFile f1, HttpSession session) throws Exception{
		memberService.memberJoin(memberDTO, f1, session);
		return "redirect:../";
		//파라미터(id 정보 같은거)를 붙여서 보내고 싶으면 물음표를 쓰고 보내준다.
	}
	

}
