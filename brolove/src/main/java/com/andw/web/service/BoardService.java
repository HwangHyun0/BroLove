package com.andw.web.service;

import java.util.List;

import com.andw.web.model.BoardVo;

public interface BoardService {
	Integer selectBoardCount(BoardVo vo) throws Exception;
	
	List<BoardVo> selectBoardList(BoardVo vo) throws Exception;
	
	Integer insertBoardItem(BoardVo vo) throws Exception;
	
	BoardVo selectBoardItem(BoardVo vo) throws Exception;
	
	Integer updateBoardItem(BoardVo vo) throws Exception;
	
	Integer deleteBoardItem(BoardVo vo) throws Exception;
	
	
}
