package com.andw.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.andw.web.common.dao.AbstractDAO;
import com.andw.web.model.CareersVo;

@Repository("careersDao")
public class CareersDao extends AbstractDAO{
	
	public Integer selectCareersCount(CareersVo vo){
		
		return (Integer)selectOne("careers.selectCareersCount", vo);
	}
	
	public List<CareersVo> selectCareersList(CareersVo vo){
		
		return (List<CareersVo>)selectList("careers.selectCareersList", vo);
	}
	
	public Integer deleteCareers(CareersVo vo){
		
		return (Integer)delete("careers.deleteCareers", vo);
		
	}
	
	public Integer insertCareers(CareersVo vo){
		
		return (Integer)insert("careers.insertCareers", vo);
	}
	
	public CareersVo selectCareers(CareersVo vo){
		
		return (CareersVo)selectOne("careers.selectCareers",vo);
	}

}
