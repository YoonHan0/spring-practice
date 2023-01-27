package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@ResponseBody
	@RequestMapping({"/", "main", "/a/b/c/main"})
	public String main() {
		return "<h1>MainController.main()</h1>";
	}
}
