package com.aim.model;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	MultipartFile[] userfiles;
	private int pages;
	private String password;
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public MultipartFile[] getUserfiles() {
		return userfiles;
	}

	public void setUserfiles(MultipartFile[] userfiles) {
		this.userfiles = userfiles;
	}
}
