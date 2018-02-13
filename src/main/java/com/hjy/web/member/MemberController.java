package com.hjy.web.member;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@GetMapping("/members/memberList")
	public String membersList(Model model) {
		List<MembersVO> list = service.selectmembersList();
		model.addAttribute("list", list);
		return "members/memberList";
	}
	//json 출력방법
	@GetMapping("/member/memberJsonList")
	public ModelAndView memberJsonList() {
		ModelAndView mav = new ModelAndView("jsonView");
		List<MembersVO> list = service.selectmembersList();
		mav.addObject("list",list);
		
		
		return mav;
	}
	
	@GetMapping("/member/memberJsonOne")
	public ModelAndView memberJsonOne(@ModelAttribute MembersVO paramVO) {
		ModelAndView mav = new ModelAndView("jsonView");
		MembersVO vo = service.selectMembersOne(paramVO);
		mav.addObject("member", vo);
		return mav;
	}
	@GetMapping("/member/name")
	@ResponseBody
	public String name(@RequestParam("id")String id) {
		
		return id;
	}
	@GetMapping("/fileForm")
	public String FileForm() {
		return "members/FileForm";
	}
	@PostMapping("/fileupload")
	public String fileUpload(MultipartHttpServletRequest request , Model model) {
		MultipartFile file = request.getFile("file");
		try {
			byte[] bytes = file.getBytes();
			
			Path path = Paths.get("C:/eclipse_workspace/web.zip_expanded/web/src/main/resources/static/" + file.getOriginalFilename());
			Files.write(path, bytes);
		}catch(Exception e) {
			e.printStackTrace();
				
			}
				
		model.addAttribute("msg", "file upload success");
		return "members/FileSuccess";
		}
	
		@GetMapping("/members/loginForm")
		public String loginForm() {
			return "members/loginForm";
	}
		//@RequestMapping(value="/members/porcLogin", method = RequestMethod.Post) 아래post 랑같음
		@PostMapping("/members/procLogin")
		public ModelAndView procLogin(@ModelAttribute MembersVO vo, HttpSession session) {
			ModelAndView mav = new ModelAndView("jsonView");
			int result = service.selectLogin(vo);
			if(result > 0) {
				session.setAttribute("id", vo.getmId());
				mav.addObject("result","200");
				mav.addObject("desc","login success");
			}else {
				mav.addObject("result", "101");
				mav.addObject("desc", "login fail");
			}
			return mav;
		}
		@RequestMapping("/members/loginComplete")
		public String loginComplete() {
			return "members/loginComplete";
		}

	//회원 페이징 리스트
	@GetMapping("/member/selectPaingMemberList")
	public String selectPaingMemberList(@RequestParam("currPage") int currPage, Model model) {
		MembersVO vo = new MembersVO();
		vo.setTotalCount(service.selectTotalCountMembers());
		vo.setCurrPage(currPage);
		
		
		List<MembersVO> list = service.selectPagingMembers(vo);
		model.addAttribute("list",list);
		model.addAttribute("startPageNum", vo.getStartPageNum());
		model.addAttribute("lastPageNum", vo.getLastPageNum());
		model.addAttribute("currPage" , vo.getCurrPage());
		return "members/selectPaingMemberList";
	}
}
		
	

