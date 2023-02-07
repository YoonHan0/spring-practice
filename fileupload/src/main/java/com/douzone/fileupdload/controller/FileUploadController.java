package com.douzone.fileupdload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {
	
	@RequestMapping({"", "/form"})	// url을 fileupload or fileupload/form으로 접근할 수 있게 Mapping
	public String form() {
		return "/WEB-INF/views/form.jsp";
	}
	
	@RequestMapping("/upload")	// fileupload/upload
	public String upload(
			@RequestParam("email") String email,			// @RequestParam(name)은 안 적어도 되지만 명시적으로 작성하기 위해서 
			@RequestParam("file") MultipartFile file) {		// MultipartFile을 사용할 때는 vo에 다 담는 것보다 받아올 때는 따로 받아오고 처리 후에 담는게 좋음

		// String url = fileuploadService.restore(file);
		return "WEB-INF/views/result.jsp";
	}
}
