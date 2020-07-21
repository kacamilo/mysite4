package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;


@Service
public class GuestbookService {

	@Autowired
	private GuestbookDao guestbookDao;
	
	//방명록 리스트 가져오기
	public List<GuestbookVo> List(){
		System.out.println("guestbookService/getList");
		
		return guestbookDao.selectList();
	}

	//방명록 글 저장
	public int addGuest(GuestbookVo guestbookVo){
		System.out.println("guestbookService/write");
		
		return guestbookDao.insert(guestbookVo);
	}
	
	//방명록 글 삭제
	public int removeGuest(GuestbookVo guestbookVo){
		System.out.println("guestbookService/remove");
		
		return guestbookDao.delete(guestbookVo);
	}
	
	//방명록 글 저장(ajax)
	public GuestbookVo addGuestbook(GuestbookVo guestbookVo) {
		
		int no = guestbookDao.insertSelectKey(guestbookVo); //연구해볼것
		System.out.println(guestbookVo.toString()); 	//no값이 있음		
		System.out.println("SelectKey로 받은 no값:" + no);
		
		return guestbookDao.SelectByNo(no);
	}
	
}
