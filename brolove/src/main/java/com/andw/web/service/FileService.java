package com.andw.web.service;

import java.util.List;

import com.andw.web.model.FileVo;

public interface FileService {
	Integer selectMaxFileGroupNo() throws Exception;
	
	List<FileVo> selectFileGroupItem(FileVo vo) throws Exception;
	
	Integer insertFileGroup(FileVo vo) throws Exception;
	
	Integer insertFileGroupItem(FileVo vo) throws Exception;

}
