package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.guestbook.repository.GuestbookRepository;
import com.douzone.guestbook.vo.GuestbookVo;

@Controller
public class GuestbookController {
	
	
	private GuestbookRepository guestbookRepository = new GuestbookRepository();
	
	@RequestMapping("/")
	public String index(Model model) {
		List<GuestbookVo> list = guestbookRepository.findAll();
		model.addAttribute("list", list);
		return "/WEB-INF/views/index.jsp";
	}
	
	
	@RequestMapping(value="/deleteform", method=RequestMethod.GET)				// Delete Form
	public String deleteform(@RequestParam(value = "no") String no, Model model) {
		System.out.println("==================== no: " + no);
		model.addAttribute("no", no);
		return "/WEB-INF/views/deleteform.jsp";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)					// Delete
	public String delete(String no, String password) {
		guestbookRepository.deleteByNoAndPassword(Long.parseLong(no), password);
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)		 														
	public String add(String name, String password, String message, Model model) {		
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		
		guestbookRepository.insert(vo);
		
		return "redirect:/";
	}

}
