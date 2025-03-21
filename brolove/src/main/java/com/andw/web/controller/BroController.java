package com.andw.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.andw.web.common.util.FileUtil;
import com.andw.web.common.util.PageUtil;
import com.andw.web.model.BoardVo;
import com.andw.web.model.FileVo;
import com.andw.web.service.BoardService;
import com.andw.web.service.FileService;

@Controller
public class BroController {

	@Autowired
	FileUtil fileUtil;
	
	@Resource(name="boardService")
	private BoardService boardService;
	
	@Resource(name="fileService")
	private FileService fileService;
	
	
	private static final String VIEW_PATH = "/view/admin/bro/";
	
	
	@RequestMapping(value = "/admin/bro/baby.do", method = RequestMethod.GET)
	public String baby(HttpServletRequest request, Model model, BoardVo vo, @RequestParam(defaultValue="1") int curPage) throws Exception {
		if(request.getSession().getAttribute("loginInfo") == null) {
			model.addAttribute("msg", "로그인을 해주세요.");
			model.addAttribute("url", "/login/login.do");
			return "/view/common/redirect";
		}else {
			vo.setBoard_cd("01"); 									
			
			Integer listCnt = boardService.selectBoardCount(vo);	
			PageUtil pageUtil = new PageUtil();
			pageUtil.Pagination(listCnt, curPage);
			vo.setStart_num(pageUtil.getStartIndex());
			vo.setEnd_num(pageUtil.getPageSize());
			
			List<BoardVo> babyList = boardService.selectBoardList(vo);
			
			model.addAttribute("start_date", vo.getStart_date());
			model.addAttribute("end_date", vo.getEnd_date());
			model.addAttribute("pagination", pageUtil);
			model.addAttribute("babyList", babyList);
			
			return  VIEW_PATH + "baby";
		}
	}
	@RequestMapping(value = "/admin/bro/young.do", method = RequestMethod.GET)
	public String young(HttpServletRequest request, Model model, BoardVo vo, @RequestParam(defaultValue="1") int curPage) throws Exception {
		if(request.getSession().getAttribute("loginInfo") == null) {
			model.addAttribute("msg", "로그인을 해주세요.");
			model.addAttribute("url", "/login/login.do");
			return "/view/common/redirect";
		}else {
			vo.setBoard_cd("02"); 									
			
			Integer listCnt = boardService.selectBoardCount(vo);	
			PageUtil pageUtil = new PageUtil();
			pageUtil.Pagination(listCnt, curPage);
			vo.setStart_num(pageUtil.getStartIndex());
			vo.setEnd_num(pageUtil.getPageSize());
			
			List<BoardVo> babyList = boardService.selectBoardList(vo);
			
			model.addAttribute("start_date", vo.getStart_date());
			model.addAttribute("end_date", vo.getEnd_date());
			model.addAttribute("pagination", pageUtil);
			model.addAttribute("babyList", babyList);
			
			return  VIEW_PATH + "young";
		}
	}
	@RequestMapping(value = "/admin/bro/now.do", method = RequestMethod.GET)
	public String now(HttpServletRequest request, Model model, BoardVo vo, @RequestParam(defaultValue="1") int curPage) throws Exception {
		if(request.getSession().getAttribute("loginInfo") == null) {
			model.addAttribute("msg", "로그인을 해주세요.");
			model.addAttribute("url", "/login/login.do");
			return "/view/common/redirect";
		}else {
			vo.setBoard_cd("03"); 									
			
			Integer listCnt = boardService.selectBoardCount(vo);	
			PageUtil pageUtil = new PageUtil();
			pageUtil.Pagination(listCnt, curPage);
			vo.setStart_num(pageUtil.getStartIndex());
			vo.setEnd_num(pageUtil.getPageSize());
			
			List<BoardVo> babyList = boardService.selectBoardList(vo);
			
			model.addAttribute("start_date", vo.getStart_date());
			model.addAttribute("end_date", vo.getEnd_date());
			model.addAttribute("pagination", pageUtil);
			model.addAttribute("babyList", babyList);
			
			return  VIEW_PATH + "now";
		}
	}
	
	
	
	@RequestMapping(value = "/admin/bro/write.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeNotice(HttpServletRequest request, Model model, BoardVo vo, @RequestParam(defaultValue="1") int curPage) throws Exception {
		if(request.getSession().getAttribute("loginInfo") == null) {
			model.addAttribute("msg", "로그인을 해주세요.");
			model.addAttribute("url", "/login/login.do");
			return "/view/common/redirect";
		}else {
			String board = request.getParameter("cd");
			model.addAttribute("board", board);
			
			return VIEW_PATH + "write";
		}
	}
	
	@RequestMapping(value = "/admin/bro/handler/insert.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String insert(HttpServletRequest request, Model model, BoardVo vo, @RequestParam MultipartFile file1) throws Exception {
		if(request.getSession().getAttribute("loginInfo") == null) {
			model.addAttribute("msg", "로그인을 해주세요.");
			model.addAttribute("url", "/login/login.do");
			return "/view/common/redirect";
		}else {	
			String url ="";
			if(vo.getBoard_cd().equals("02")) {		
				url = "/admin/bro/young.do";
			}else if(vo.getBoard_cd().equals("03")) {
				url = "/admin/bro/now.do";
			}else {
				url = "/admin/bro/baby.do";
			}
			
			if (!file1.isEmpty()) {
				FileVo fileVo = new FileVo();
				Integer file_group_no = fileService.selectMaxFileGroupNo();								
				
				String rootDir = request.getSession().getServletContext().getRealPath("/"); 	
				String saveDir = "/upload/file"; 
				String renamedFileName = fileUtil.getRenamedFileName(file1);
				fileUtil.saveFile(file1, rootDir, saveDir, renamedFileName);
				String saveAllDir = "/" + saveDir + "/" + renamedFileName;
				String org_file_nm = file1.getOriginalFilename();
				
				fileVo.setFile_group_no(file_group_no);
				fileVo.setFile_path(saveDir);
				fileVo.setFile_seq(1);
				fileVo.setOrg_file_nm(org_file_nm.replaceAll("\'", "\''").replace("\"", "\\\""));
				fileVo.setRe_file_nm(renamedFileName.replaceAll("\'", "\''").replace("\"", "\\\""));
				vo.setVisual_file_group_no(file_group_no);  //채용첨부파일
				
				Integer result1 = fileService.insertFileGroup(fileVo);
				Integer result2 = fileService.insertFileGroupItem(fileVo);
			
				if(result1 < 1 || result2 < 1) {
					model.addAttribute("msg", "Error:fileUpload");
					model.addAttribute("url", url);
					return "/view/common/redirect";
				}
			}
			vo.setTitle(vo.getTitle().replaceAll("\'", "\''").replace("\"", "\\\""));
			vo.setDe_contents(vo.getDe_contents().replaceAll("\'", "\''").replace("\"", "\\\""));
			
			Integer result = boardService.insertBoardItem(vo);
			if(result >= 1) {
				model.addAttribute("msg", "저장되었습니다");
				model.addAttribute("url", url);
				return "/view/common/redirect";
			}else {
				model.addAttribute("msg", "Error:insertnotice");
				model.addAttribute("url", url);
				return "/view/common/redirect";
			}
		}
	}
	
	@RequestMapping(value = "/bro/baby.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String userbaby(HttpServletRequest request, Model model, BoardVo vo, @RequestParam(defaultValue="1") int curPage) throws Exception {
		
		vo.setBoard_cd("01"); 									
		vo.setFront_yn("Y");									
		
		Integer listCnt = boardService.selectBoardCount(vo);	//페이지 총 갯수
		PageUtil pageUtil = new PageUtil();
		pageUtil.Pagination(listCnt, curPage);
		
		vo.setStart_num(pageUtil.getStartIndex());
		vo.setEnd_num(pageUtil.getPageSize());
		
		List<BoardVo> babyList = boardService.selectBoardList(vo);
		
		FileVo fileVo = new FileVo();
		
		for (BoardVo boardItem : babyList) {
			fileVo.setFile_group_no(boardItem.getVisual_file_group_no());
			List<FileVo> visualFileList = fileService.selectFileGroupItem(fileVo);
			boardItem.setThumb_file_list(visualFileList);
		}
		
		model.addAttribute("start_date", vo.getStart_date());
		model.addAttribute("end_date", vo.getEnd_date());
		model.addAttribute("pagination", pageUtil);
		
		model.addAttribute("babyList", babyList);
		return "/view/bro/baby";
	}
	
	
	
	
}
