package com.andw.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.andw.web.dao.BoardDao;
import com.andw.web.model.BoardVo;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Resource(name="boardDao")
	private BoardDao boardDao;
	
	@Override
	public Integer selectBoardCount(BoardVo vo) throws Exception {
		
		return boardDao.selectBoardCount(vo);
	}
	
	@Override
	public List<BoardVo> selectBoardList(BoardVo vo) throws Exception {
		
		return boardDao.selectBoardList(vo);
	}

	@Override
	public Integer insertBoardItem(BoardVo vo) throws Exception {
		
		return boardDao.insertBoardItem(vo);
	}

	@Override
	public BoardVo selectBoardItem(BoardVo vo) throws Exception {

		return boardDao.selectBoardItem(vo);
	}

	@Override
	public Integer updateBoardItem(BoardVo vo) throws Exception {
		
		return boardDao.updateBoardItem(vo);
	}

	@Override
	public Integer deleteBoardItem(BoardVo vo) throws Exception {

		return boardDao.deleteBoardItem(vo);
	}

}
