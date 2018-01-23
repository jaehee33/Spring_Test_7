package com.iu.s7;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.iu.notice.NoticeDAO;
import com.iu.notice.NoticeService;
import com.iu.qna.QnaDAO;
import com.iu.qna.QnaService;

import oracle.net.aso.n;
import oracle.net.aso.q;

public class TestSqlSession extends AbstractTest {
	
	@Inject
	private NoticeService noticeService;

	@Test
	public void test() {
		assertNotNull(noticeService);
	}

}
