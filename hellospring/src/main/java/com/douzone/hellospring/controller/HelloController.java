package com.douzone.hellospring.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")		// hellospring/hello5
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) {		// nickname == ?nickname= 에 들어가는 값
		System.out.println("name: " + name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello3")
	public ModelAndView hello3(String name) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name);
		mav.setViewName("/WEB-INF/views/hello3.jsp");
		
		return mav;
	}
	
	@RequestMapping("/hello4")
	public String hello4(String name, Model model) {		
		model.addAttribute("name", name);
		return "/WEB-INF/views/hello3.jsp";
	}
	
	@ResponseBody				// 이 메소드가 return하는 값은 Response의 <body>에 붙어야 한다.
	@RequestMapping("/hello5")	// hellospring/hello5
	public String hello5() {		
		return "<h1>Hello Spring!!</h1>";
	}
	
	@RequestMapping("/hello6")		// 이렇게 보내면 ServletDispahch인가 거기서 sendredirect로 넘겨서 처리해줌
	public String hello6() {
		return "redirect:/hello";
	}
	
	/* 이렇게 Spring에서 Servlet을 사용 가능하지만 굳이 이렇게 하지말자! */
	@RequestMapping("/hello7")
	public void hello7(
			HttpServletRequest request,
			HttpServletResponse reponse,
			Writer out) {
			
		String name = request.getParameter("name");
		try {
			out.write("Hello " + name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
