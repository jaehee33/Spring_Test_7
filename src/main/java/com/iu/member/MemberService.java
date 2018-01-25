package com.iu.member;


import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.file.FileDAO;
import com.iu.util.FileSaver;



@Service
public class MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	@Inject
	private FileDAO fileDAO;
	
	public int memberJoin(MemberDTO memberDTO, MultipartFile f1, HttpSession session) throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload"); //저장하려면 세션 필요
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		FileSaver fileSaver = new FileSaver();
		memberDTO.setFname(fileSaver.save(f1, filePath));
		memberDTO.setOname(f1.getOriginalFilename());
		return memberDAO.memberJoin(memberDTO);
	}
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		System.out.println(memberDTO.getPw());
		return memberDAO.memberLogin(memberDTO);
	}
	public int memberDelete(MemberDTO memberDTO, HttpSession session) throws Exception{
		String filePath = session.getServletContext().getRealPath("resources/upload");
		System.out.println(filePath);
		File file = new File(filePath, memberDTO.getFname());
			file.delete(); //여기는 boolean 타입이 온다. 그걸로 제어할수 있다.
		return memberDAO.memberDelete(memberDTO);
	}
	public int memberUpdate(MemberDTO memberDTO, MultipartFile f1, HttpSession session) throws Exception{
		if(f1 != null){
			String filePath = session.getServletContext().getRealPath("resources/upload");
			File file = new File(filePath);
			if(file.exists()){
				file.mkdirs();
			}
			FileSaver fileSaver = new FileSaver();
			String fileName = fileSaver.save(f1, filePath);
			memberDTO.setFname(fileName);
			memberDTO.setOname(f1.getOriginalFilename());
		}else{
			memberDTO.setFname(((MemberDTO)session.getAttribute("member")).getFname());
			memberDTO.setOname(((MemberDTO)session.getAttribute("member")).getOname());	
		}
		return memberDAO.memberUpdate(memberDTO, f1);
	}
	public MemberDTO memberIdCheck(String id) throws Exception{
		return memberDAO.memberIdCheck(id);
	}
	

}
