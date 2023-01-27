package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*
 * 
 * @RequestMapping 클래스 단독 매핑
 * Spring mvc 4.x 에서만 지원함 / 나는 5.3.25 version
 */

// @Controller
@RequestMapping("/guestbook/*")
public class GuestbookController {

	@ResponseBody
	@RequestMapping
	public String list() {
		return "<h1>GuestbookController.list()</h1>";
	}
	
	@ResponseBody
	@RequestMapping
	public String delete() {
		return "<h1>GuestbookController.delete()</h1>";
	}
}
