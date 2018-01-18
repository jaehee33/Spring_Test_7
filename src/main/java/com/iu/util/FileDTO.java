package com.iu.util;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
	
	private String id;
	private MultipartFile f1;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MultipartFile getF1() {
		return f1;
	}
	public void setF1(MultipartFile f1) {
		this.f1 = f1;
	}

}
