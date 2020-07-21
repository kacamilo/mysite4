package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	@Autowired
	private SqlSession sqlSession;

	// 글전체 가져오기(리스트만 출력할때)
	public List<BoardVo> selectList() {
		System.out.println("boardDao/selectList");

		return sqlSession.selectList("board.selectList");
	}

	
	// 글전체 가져오기(검색기능 추가)
	public List<BoardVo> selectList2(String keyword) {
		System.out.println("boardDao/selectList2");

		return sqlSession.selectList("board.selectList2", keyword);
	}
	

	// 글쓰기
	public int insert(BoardVo boardVo) {
		System.out.println("boardDao/insert");

		
		return sqlSession.insert("board.insert", boardVo);
	}

	
	// 글 1개 가져오기
	public BoardVo select(int no) {
		System.out.println("boardDao/select");

		return sqlSession.selectOne("board.selcet", no);
	}

	
	// 조회수 업데이트
	public int updateHit(int no) {
		System.out.println("boardDao/updateHit");

		return sqlSession.update("board.updateHit", no);
	}
	
	
	// 글수정
	public int update(BoardVo boardVo) {
		System.out.println("boardDao/update");

		return sqlSession.update("board.update", boardVo);
	}
	
	
	// 글삭제
	public int delete(BoardVo boardVo) {
		System.out.println("boardDao/delete");

		return sqlSession.delete("board.delete", boardVo);
	}

	// 리스트 페이징
	public List<BoardVo> select2(int startRnum, int endRnum) {
		System.out.println("boardDao/select2");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startRnum", startRnum);
		map.put("endRnum", endRnum);
		return sqlSession.selectList("board.select2", map);
	}

	//토탈 카운트
	public int totalCount() {
		System.out.println("boardDao/totalCount");
		
		return sqlSession.selectOne("board.totalCount");
		
	}
}
