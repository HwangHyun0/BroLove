package com.andw.web.service;

import com.andw.web.model.MemberVo;

public interface LoginService {
	
	MemberVo selectMemberInfo(MemberVo vo) throws Exception;
	

}
