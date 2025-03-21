package com.andw.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.andw.web.dao.CareersDao;
import com.andw.web.model.CareersVo;

@Service("careersService")
public class CareersServiceImpl implements CareersService {
	
	@Resource
	private CareersDao careersDao;
	
	@Override
	public Integer selectCareersCount(CareersVo vo) throws Exception {

		return careersDao.selectCareersCount(vo);
	}
	
	@Override
	public List<CareersVo> selectCareersList(CareersVo vo) throws Exception {

		return careersDao.selectCareersList(vo);
	}
	
	@Override
	public Integer deleteCareers(CareersVo vo) throws Exception {

		return careersDao.deleteCareers(vo);
	}
	
	@Override
	public Integer insertCareers(CareersVo vo) throws Exception {
		
		return careersDao.insertCareers(vo);
	}

	@Override
	public CareersVo selectCareers(CareersVo vo) throws Exception {

		return careersDao.selectCareers(vo);
	}


}
