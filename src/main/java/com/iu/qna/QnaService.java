package com.iu.qna;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.ListData;
import com.iu.util.PageMaker;

import oracle.net.aso.f;

@Service
public class QnaService implements BoardService {
	
	@Inject
	private QnaDAO qnaDAO;
	@Inject
	private FileDAO fileDAO;
	
	@Override
	public List<BoardDTO> selectList(ListData listData) throws Exception {
		int totalCount = qnaDAO.totalCount(listData);
		PageMaker pageMaker = new PageMaker();
		pageMaker.pageMaker(totalCount, listData);
		return qnaDAO.selectList(listData);
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		return qnaDAO.selectOne(num);
	}

	@Override
	public int insert(BoardDTO boardDTO, MultipartFile [] f1, HttpSession session) throws Exception {
		qnaDAO.insert(boardDTO);
		FileSaver fileSaver = new FileSaver();
		String filePath = session.getServletContext().getRealPath("resources/upload");
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
		List<String> names = fileSaver.save(f1, filePath);
		
		for(int i=0; i<names.size(); i++){
			FileDTO fileDTO = new FileDTO();
			fileDTO.setFname(names.get(i));
			fileDTO.setOname(f1[i].getOriginalFilename());
			fileDTO.setNum(boardDTO.getNum());
			fileDAO.insert(fileDTO);
		}
		return 1;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return qnaDAO.update(boardDTO); 
	}

	@Override
	public int delete(int num) throws Exception {
		return qnaDAO.delete(num);
	}
	public int replyin(BoardDTO boardDTO) throws Exception{
		qnaDAO.replyup(boardDTO);
		return qnaDAO.replyin(boardDTO);
	}

}
