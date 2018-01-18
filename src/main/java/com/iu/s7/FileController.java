package com.iu.s7;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iu.util.FileSaver;

@Controller
public class FileController {
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(MultipartFile f1[], HttpSession session) throws Exception{
		//service class로 session, file들을 넘겨준다.
		String filePath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(filePath);
		if(!f.exists()){
			f.mkdirs();
		}
		System.out.println(filePath); //upload 임시폴더 경로 아는 방법 
		//임시 이므로 사진 파일을 보여주고 싶으면 여기서 복사해서 업로드 폴더에 사진을 복붙한다.
		
		FileSaver fs = new FileSaver();
		
		for(MultipartFile file : f1){
			String s = fs.save(file, filePath);
			System.out.println(s); //이상한파일명으로 들어오게 됨
			System.out.println(file.getOriginalFilename());
		}
	}
	
	/*@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(MultipartHttpServletRequest request){
		List<MultipartFile> ar = request.getFiles("f1");
		for(int i=0; i<ar.size(); i++){
		//for(MultipartFile file : ar)
		  //System.out.println(file.getOriginalFilename());
			System.out.println(ar.get(i).getOriginalFilename());
		}
	
	}*/
	
	/*@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload2(MultipartHttpServletRequest request){
		Iterator<String> it = request.getFileNames();
		while(it.hasNext()){
			MultipartFile f = request.getFile(it.next());
		}
	}
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(FileDTO fileDTO){
		System.out.println(fileDTO.getF1().getOriginalFilename());
		System.out.println(fileDTO.getF2().getOriginalFilename());
	}
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(MultipartFile f1, MultipartFile f2){
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getOriginalFilename());
	}
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(MultipartHttpServletRequest request){
		MultipartFile f1 = request.getFile("f1");
		MultipartFile f2 = request.getFile("f2");
		System.out.println(f1.getOriginalFilename());
		System.out.println(f2.getOriginalFilename());
	}*/

}
