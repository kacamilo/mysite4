package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileUploadService;

@Controller
@RequestMapping("/fileupload")
public class FileUploadController {
   
   @Autowired
   private FileUploadService fileUploadService;
   
   @RequestMapping("/form")
   public String form() {
      System.out.println("FileUploadController/form");
      
      return "fileupload/form";
   }
   
   @RequestMapping(value = "/upload", headers = "content-type=multipart/*")
   public String upload(@RequestParam("file") MultipartFile file, Model model) {
      System.out.println("FileUploadController/upload");
      
      System.out.println(file.getOriginalFilename());

      String saveName = fileUploadService.restore(file);
      
      System.out.println("5");
      
      model.addAttribute("saveName", saveName);
      
      System.out.println("5");
      
      return "fileupload/result";
   }
      
}
