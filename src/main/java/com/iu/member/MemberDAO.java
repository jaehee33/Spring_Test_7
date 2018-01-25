package com.iu.member;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE = "MemberMapper.";

	public int memberJoin(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"join", memberDTO);
	}
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"selectOne", memberDTO);
	}
	public int memberUpdate(MemberDTO memberDTO, MultipartFile f1) throws Exception{
		return sqlSession.update(NAMESPACE+"update", memberDTO);
	}
	public int memberDelete(MemberDTO memberDTO) throws Exception{
		return sqlSession.delete(NAMESPACE+"delete", memberDTO);
	}
	public MemberDTO memberIdCheck(String id) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"idcheck", id);
	}

}
