package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	@Autowired
	private GalleryService galleryService;
	
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model){
		System.out.println("galleryController/ list");
		//서비스를 통해 모든 방명록 글 가져오기
		List<GalleryVo> galleryList = galleryService.List();
		
		//Dispacher Servlet-->jsp에 방명록 글 리스트 전달
		model.addAttribute("galleryList", galleryList);
		
		return "gallery/list";
	}
		
	
	
	// 사진 업로드하기
	@RequestMapping("/addList")
	public String addList (@RequestParam("file") MultipartFile file, String comment, int userNo, Model model) {
		System.out.println("GalleryController/addList");
		
		String  savename = galleryService.addList(file, comment, userNo);
		
		model.addAttribute(attributeValue)

		System.out.println(file.getOriginalFilename() + "," + comment);
		
		galleryService.addList(file, comment, userNo);
		
		return "redirect:/gallery/list";
		
	}
	
	//ajax 방명록
	@RequestMapping(value="/ajaxList")
	public String ajaxList() {
		System.out.println("galleryController/ajaxList");
		return "g/ajaxList";
	}
	
	
}
