package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
@RequestMapping(value="/api/gallery")
public class ApiGalleryController {

	@Autowired
	private GalleryService galleryService;
	
	@ResponseBody
	@RequestMapping(value="/list")
	public List<GalleryVo> list() {
		System.out.println("ApiGuestbookController/ajaxList");
		
		List<GalleryVo> galleryList = galleryService.List();
		System.out.println(galleryList.toString());
		return galleryList;
	}
	
	
}
