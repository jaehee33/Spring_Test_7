package com.iu.file;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class FileDAO {
	
	@Inject
	private SqlSession sqlsession;
	private final String NAMESPACE="FileMapper.";
	
	public int delete(int num) throws Exception{
		return sqlsession.delete(NAMESPACE+"delete", num);
	}
	public int deleteFn(int fn) throws Exception{
		return sqlsession.delete(NAMESPACE+"deleteFn", fn);
	}
	public int insert(FileDTO fileDTO) throws Exception{
		return sqlsession.insert(NAMESPACE+"insert", fileDTO);
	}
	public List<FileDTO> selectList(int num) throws Exception{
		return sqlsession.selectList(NAMESPACE+"selectList", num);
	}

}
