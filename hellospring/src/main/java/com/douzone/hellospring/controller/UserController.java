package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * 
 * @RequestMapping 클래스 + 메소드 매핑
 * 
 */
@Controller
@RequestMapping("/user")			// 공통적인 url mapping은 이렇게!!!
public class UserController {
	
//	@ResponseBody
//	@RequestMapping(value="/join")		// /user/join
//	public String join() {
//		return "<h1>UserController.join()</h1>";
//	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)		// GET방식으로 /user/join에 접근할 때
	public String join() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)		// POST방식으로 /user/join에 접근할 때 
																	// : form에서 submit하면 post로 넘어오니까 그때 실행됨
	public String join(UserVo userVo) {	// 절때로 null이 되지 않는다 -> Spring이 값을 어떻게든 넣으려고 해서
		System.out.println(userVo);
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public String update(@RequestParam(value = "n") String name) {
		
		/*
		 * 만약 n이라는 이름의 URL 파라미터가 없으면
		 * 400 error 발생
		 */
		return "<h1>UserController.update( " + name + " )</h1>";
	}
	
	@ResponseBody
	@RequestMapping("/update2")
	public String update2(@RequestParam(value = "n", required=true, defaultValue="") String name) {
		
		return "<h1>UserController.update( " + name + " )</h1>";
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public String list(@RequestParam(value = "p", required = true, defaultValue = "1") int pageNo) {
		return "<h1>UserController.list( " + pageNo + " )</h1>";
	}
}
