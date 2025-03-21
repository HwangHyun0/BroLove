package com.andw.web.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.andw.web.dao.MailDao;
import com.andw.web.model.MailVo;

//by영훈 21-06-18
@Service("mailService")
public class MailServiceImpl implements MailService {
	
	@Resource(name="mailDao")
	private MailDao mailDao;
	
	@Override
	public List<MailVo> selectMailList() {
		
		return  mailDao.selectMailList();
	}// MailServiceImpl 끝
	
	
	
	@Override
	public void insertMail(MailVo mailVo) throws Exception {
		System.out.println("mailinsert");
		
		mailDao.insertMail(mailVo);
		
	}

	
		
}
