package com.andw.web.dao;

import org.springframework.stereotype.Repository;

import com.andw.web.common.dao.AbstractDAO;
import com.andw.web.model.MemberVo;


@Repository("loginDao")
public class LoginDao extends AbstractDAO{
	
	public MemberVo selectMemberInfo(MemberVo vo) throws Exception {
		
		return (MemberVo)selectOne("member.selectMemberInfo", vo);
	}

}
