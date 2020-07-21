package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;

	// 리스트(리스트만 출력할때)
	public List<BoardVo> getBoardList() {
		System.out.println("boardService/list");

		return boardDao.selectList();
	}

	
	// 리스트(검색기능 추가)
	public List<BoardVo> getBoardList2(String keyword) {
		System.out.println("boardService/list2");

		return boardDao.selectList2(keyword);
	}


	// 글쓰기
	public int addBoard(BoardVo boardVo) {
		System.out.println("boardService/addBoard");

		
		return boardDao.insert(boardVo);
	}
	
	
	// 글가져오기
	public BoardVo getBoard(int no, String type) {
		System.out.println("boardService/getBoard");

		if("read".equals(type)) {//읽기 일때는 조회수 올림
			boardDao.updateHit(no);
			BoardVo boardVo = boardDao.select(no);
			return boardVo;
			
		}else { //수정 일때는 조회수 올리지 않음
			BoardVo boardVo = boardDao.select(no);
			return boardVo;
		}
		
	}
	
	
	// 글수정
	public int modifyBoard(BoardVo boardVo) {
		System.out.println("boardService/modifyBoard");

		return boardDao.update(boardVo);
	}
	

	// 글삭제
	public int removeBoard(BoardVo boardVo) {
		System.out.println("boardService/removeBoard");

		return boardDao.delete(boardVo);
	}

	// 리스트 페이징
	public Map<String, Object> list2(int crtPage) {
		System.out.println("boardService/list2");
		///////////////////////////////////	//	//
		// //////////////리스트 가져오기//////////////
		////////////////////////////////////////
		
		//페이지당 글갯수
		int listCnt = 5;
		
		//현재페이지 계산
		crtPage = (crtPage>0) ? crtPage : (crtPage=1); //crtPage 0보다 작으면 1page 처리(마이너스값 처리)
		// 아래 if문과 똑같은 문법(3항연산)
		/*
		if(crtPage>0) {
			crtPage = crtPage;
		} else {
			crtPage = 1;
		}
		*/
		
		
		//startRnum 시작 rownum
		int startRnum = (crtPage-1) * listCnt;		//1page --> 0 	+1 db에서 계산
		
		//endRnum	끝 rownum	
		int endRnum = startRnum + listCnt;			//1page --> 10	db에서 그대로 사용
		
		System.out.println("crtPage:" + crtPage);
		System.out.println("startRnum:" + startRnum);
		System.out.println("endRnum:" + endRnum);
		
		List<BoardVo> list = boardDao.select2(startRnum, endRnum);
		///////////////////////////////////	//	//
		// ////////////페이지 버튼 영역//////////////
		////////////////////////////////////////
		
		//전체글 갯수
		int totalCount = boardDao.totalCount();	
		
		//페이지당 버튼갯수
		int pageBtnCount = 5;
		
		//
		//1 --> 1~5(page)
		//2 --> 1~5(page)
		//3 --> 1~5(page)
		//4 --> 1~5(page)
		//5 --> 1~5(page)
		//6 --> 6~10(page)
		//10 --> 6~10(page)
		//11 --> 11~15(page)
		
		//마지막 버튼 번호
		int endPageBtnNo = (int)Math.ceil(crtPage/(double)pageBtnCount)*pageBtnCount;
										// 1(page) / 5(pageBtnCount) *5(pageBtnCount)
		
		//시작 버튼 번호
		int startPageBtnNo = endPageBtnNo - (pageBtnCount-1);
		
		//다음 화살표 유무(next)
		boolean next = false;
		if(endPageBtnNo * listCnt < totalCount) {
			next = true;
		}else {
			endPageBtnNo = (int)Math.ceil((totalCount)/(double)listCnt);
		}
		
		
		//이전 화살표 유무(prev)
		boolean prev = false;
		if(startPageBtnNo != 1) {
			prev = true;
		}
			
		Map<String, Object>pMap = new HashMap<String, Object>();
		pMap.put("prev", prev);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("next", next);
		pMap.put("boardList", list);
		
		return pMap;
	}


}
