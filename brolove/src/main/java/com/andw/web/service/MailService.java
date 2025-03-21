package com.andw.web.service;

import java.util.List;

import com.andw.web.model.MailVo;

public interface MailService {
	
	List<MailVo> selectMailList() throws Exception;
	
	void insertMail(MailVo mailVo) throws Exception;
	
}

