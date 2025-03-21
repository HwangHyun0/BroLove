package com.andw.web.service;

import java.util.List;

import org.springframework.aop.ThrowsAdvice;

import com.andw.web.model.CareersVo;

public interface CareersService {
	
	Integer selectCareersCount(CareersVo vo) throws Exception;
	
	List<CareersVo> selectCareersList(CareersVo vo) throws Exception;
	
	Integer deleteCareers(CareersVo vo) throws Exception;
	
	Integer insertCareers(CareersVo vo) throws Exception;
	
	CareersVo selectCareers(CareersVo vo) throws Exception;
}
