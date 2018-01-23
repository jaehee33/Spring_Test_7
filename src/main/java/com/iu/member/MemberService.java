package com.iu.member;


import javax.inject.Inject;
import org.springframework.stereotype.Service;



@Service
public class MemberService {
	
	@Inject
	private MemberDAO memberDAO;
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberJoin(memberDTO);
	}
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberLogin(memberDTO);
	}
	public MemberDTO memberView(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberView(memberDTO);
	}
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberDelete(memberDTO);
	}
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		return memberDAO.memberUpdate(memberDTO);
	}
	

}
