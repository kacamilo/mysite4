package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	// 리스트 출력
	public List<GalleryVo>selectList(){
		System.out.println("galleryDao/selectList");
		
		return sqlSession.selectList("gallery.selectList");
	}
	
	public int insert(GalleryVo galleryVo) {
		System.out.println("galleryDao/insert");
		
		return sqlSession.insert("gallery.insert", galleryVo);
	}
	
	
	
	/*
	// 사진  가져오기 (ajax)
		public GalleryVo SelectByNo(int no) {
			return sqlSession.selectOne("gallery.selectByNo", no);
			
		}
	// 사진 저장(ajax)
	   public galleryVo selectByNo(int no){
	   return sqlSession.selectOne("gallery.selectByNo", no);	
	*/	
	
	
}
