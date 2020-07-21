package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value="/api/guestbook")
public class ApiGuestbookController {
	
	@Autowired
	private GuestbookService guestbookService;
	@ResponseBody
	@RequestMapping(value="/list")
	public List<GuestbookVo> list() {
		System.out.println("ApiGuestbookController/ajaxList");
		
		List<GuestbookVo> guestbookList = guestbookService.List();
		System.out.println(guestbookList.toString());
		return guestbookList;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public GuestbookVo write(@RequestBody GuestbookVo guestbookVo) {
		System.out.println("ApiGuestbookController/write");
		System.out.println(guestbookVo.toString());
		
		GuestbookVo vo = guestbookService.addGuestbook(guestbookVo);
		System.out.println("보내줄 vo: " + vo.toString());
		
		return vo;
		
	}
	
	@ResponseBody
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public int delete(GuestbookVo guestbookVo) {
		System.out.println("ApiGuestbookController/delete");
		System.out.println(guestbookVo.toString());
		
		int count = guestbookService.removeGuest(guestbookVo);
		System.out.println("test*************************************");
		return count;
	}
}
