package com.iu.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileSaver {
	
	public List<String> save(MultipartFile [] f1, String filePath) throws Exception{
		List<String> fileNames = new ArrayList<>();
		for(MultipartFile f : f1){
			String fileName = this.save(f, filePath);
			fileNames.add(fileName);
		}
		return fileNames;
	}
	
	public String save(MultipartFile f1, String filePath) throws Exception{
		// 1. 저장경로 (있을수도 있고 없을수도 있는건 서비스에서 해준다.)
		// 1. 저장할 파일명 생성
		String fileName = f1.getOriginalFilename();
		System.out.println(fileName);
		fileName=fileName.substring(fileName.lastIndexOf("."));
		fileName=UUID.randomUUID().toString()+fileName;
		
		File file = new File(filePath, fileName);
		
		f1.transferTo(file);
		return fileName;
	}

}
