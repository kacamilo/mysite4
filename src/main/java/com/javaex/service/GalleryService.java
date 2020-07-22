package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	private GalleryDao galleryDao;
	
	//리스트 (리스트만 출력)
	public List<GalleryVo>List() {
		System.out.println("galleryService/getList");
		
		return galleryDao.selectList();
	}
	
	//갤러리에 글쓰기
	public String addList (MultipartFile file, String comment, int userNo) {
		
		////////////////데이타 추출 ////////////////
		String saveDir = "c:\\Java Study\\upload";
		
		//원파일 이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName:" + orgName);
		
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName:" + exName);
		
		//저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName:" + saveName);
		
		//파일 경로
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath:" + filePath);
		
		//파일 사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize:" + fileSize);

		////////파일 서버에 복사 /////////////////////////////
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			
			bout.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//파일 --> 필요한 정보 추출 --> DB에 저장
		
	
		return saveName;
		
	}
	
}
