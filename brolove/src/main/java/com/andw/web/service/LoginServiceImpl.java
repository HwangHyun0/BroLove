package com.andw.web.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.andw.web.dao.LoginDao;
import com.andw.web.model.MemberVo;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Resource(name="loginDao")
	private LoginDao dao;
	
	@Override
	public MemberVo selectMemberInfo(MemberVo vo) throws Exception {
		MemberVo memberVo = dao.selectMemberInfo(vo);
		
		return memberVo;
	}

}
