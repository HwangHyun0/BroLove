package com.andw.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.andw.web.common.dao.AbstractDAO;
import com.andw.web.model.FileVo;

@Repository("fileDao")
public class FileDao extends AbstractDAO{
	
	public Integer selectMaxFileGroupNo() throws Exception {
		
		return (Integer)selectOne("file.selectMaxFileGroupNo");
	}
	
	public List<FileVo> selectFileGroupItem(FileVo vo) throws Exception{
		
		return (List<FileVo>)selectList("file.selectFileGroupItem", vo);
	}
	
	public Integer insertFileGroup(FileVo vo) throws Exception {
		
		return (Integer)insert("file.insertFileGroup", vo);
	}
	
	public Integer insertFileGroupItem(FileVo vo) throws Exception {
		
		return (Integer)insert("file.insertFileGroupItem", vo);
	}

}
