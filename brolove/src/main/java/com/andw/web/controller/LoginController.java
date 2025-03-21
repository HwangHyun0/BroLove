package com.andw.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.andw.web.HomeController;
import com.andw.web.model.MemberVo;
import com.andw.web.service.LoginService;


@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name="loginService")
	private LoginService loginService;
	
	@RequestMapping(value = "/login/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpServletRequest request, Model model) {
		if(request.getSession().getAttribute("loginInfo") != null) {
			model.addAttribute("msg", "이미 로그인 된 상태입니다.");
			model.addAttribute("url", "/admin/bro/baby.do");
			return "/view/common/redirect";
		}else {
			return "/view/admin/login/login";
		}
	}
	
	@RequestMapping(value="/login/handler/login.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String handlerLogin(HttpServletRequest request, Model model, MemberVo vo) throws Exception {
		//log.debug("id"+vo.getUser_id());
		MemberVo memberVo = loginService.selectMemberInfo(vo);
		if(memberVo == null) {
			model.addAttribute("msg", "입력정보를 확인해주세요.");
			model.addAttribute("url", "/login/login.do");
			return "/view/common/redirect";
		}else {
			model.addAttribute("msg", "로그인되었습니다.");
			model.addAttribute("url", "/admin/bro/baby.do");
			request.getSession().setAttribute("loginInfo", memberVo);
			return "/view/common/redirect";
		}
	}
	
	@RequestMapping(value="/login/handler/logout.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String handlerLogout(HttpServletRequest request, Model model, MemberVo vo) throws Exception {
		request.getSession().removeAttribute("loginInfo");
		
		model.addAttribute("msg", "로그아웃되었습니다.");
		model.addAttribute("url", "/login/login.do");
		
		return "/view/common/redirect";
	}
	
}
