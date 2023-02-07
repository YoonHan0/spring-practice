package com.douzone.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.fileupload.service.FileuploadService;

@Controller
public class FileUploadController {
	
	@Autowired
	private FileuploadService fileuploadService;
	
	@RequestMapping({"", "/form"})	// url을 fileupload or fileupload/form으로 접근할 수 있게 Mapping
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping("/upload")	// fileupload/upload
	public String upload(
			@RequestParam("email") String email,			// @RequestParam(name)은 안 적어도 되지만 명시적으로 작성하기 위해서 
			@RequestParam("file") MultipartFile file,
			Model model) {		// MultipartFile을 사용할 때는 vo에 다 담는 것보다 받아올 때는 따로 받아오고 처리 후에 담는게 좋음
		
		String url = fileuploadService.restore(file);
		if(url ==  null) {
			System.out.println("Controller Empty");
		}
		model.addAttribute("url", url);
		return "WEB-INF/views/result.jsp";
	}
}
