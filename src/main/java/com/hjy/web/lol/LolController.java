package com.hjy.web.lol;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;





@Controller
public class LolController {
	@Autowired
	LolService service;
															//메인페이지
	@GetMapping("lol/myMain")
	public String myMain() {
		
		return "lol/MyMain";
	}
															//로그인창
	@GetMapping("/lol/loginForm")
	public String loginForm() {
		return "lol/loginForm";
	}
	
																//로그인
	@PostMapping("/lol/procLogin")
	public ModelAndView procLogin(@ModelAttribute LolVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		int result = service.selectLogin(vo);
		if(result > 0) {
			session.setAttribute("lId", vo.getlId());
			mav.addObject("result","200");
			mav.addObject("desc","login success");
		}else {
			mav.addObject("result", "101");
			mav.addObject("desc", "login fail");
		}
		return mav;
	}
	
	@RequestMapping("/lol/loginComplete")
	public String loginComplete() {
		return "lol/loginComplete";
	}
															//로그아웃
	@RequestMapping(value="/")
	public ModelAndView logOut(ModelAndView mav, HttpSession session) {
		String page = "redirect:/";
		session.removeAttribute("id");
		mav.setViewName(page);
		return mav;
	}
																//회원가입창
	@GetMapping("/lol/memberShip")
	public String memberShip() {
		return "lol/memberShip";
	}
	@PostMapping("/lol/memberShip2")
	public LolVO memberShip2(@ModelAttribute LolVO vo) {
		ModelAndView mav = new ModelAndView("jsonView");
		int result = service.insertLogin(vo);
		if(result == 0) {
			mav.addObject("result","200");
			mav.addObject("desc","use");
		}else {	
			mav.addObject("result","201");
			mav.addObject("desc","not use");
		}
		return vo;
	}
																//회원가입 아이디 중복체크
	@PostMapping("/lol/loginCheck")
	public ModelAndView loginCheck(@RequestParam("userIdSearch") String id) {
		ModelAndView mav = new ModelAndView("jsonView");
		String result = service.selectIdCheck(id);
		if(result == null) {
			mav.addObject("result","200");
			mav.addObject("desc","use");
		}else {
			mav.addObject("result","201");
			mav.addObject("desc","not use");
		}
		return mav;
	}
																		//회원탈퇴
	@GetMapping("/lol/memberLeave")
	public String memberLeave() {
		return "lol/memberLeave";
	}	
	@PostMapping("/lol/memberLeave2")
	public ModelAndView memberLeave(@ModelAttribute LolVO vo, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		int result = service.deleteMember(vo);
		if(result > 0) {
			mav.addObject("result","200");
			mav.addObject("desc","use");
		}else {
			mav.addObject("result","201");
			mav.addObject("desc","not use");
		}
		return mav;
	}
																		//즐겨찾기페이지
	@GetMapping("/lol/bookMark")
	public String bookMark(@ModelAttribute BookMarkVO bvo, HttpSession session) {
			
		return "/lol/bookMark";
	}
	@PostMapping("/lol/bookMark2")
	public ModelAndView bookMark2(@ModelAttribute BookMarkVO bvo, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		List<BookMarkVO> result = service.selectBookMark(bvo);
		return mav;
	}
	
																		//즐겨찾기등록
	@PostMapping("/lol/insertBookMark")
	public ModelAndView insertBookMark(@ModelAttribute String vo,  HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		int result = service.insertBookMark(vo);
		if(result == 0) {
			mav.addObject("result","200");
			mav.addObject("desc","use");
		}else {
			mav.addObject("result","201");
			mav.addObject("desc","not use");
		}
		return mav;
	}
																	//즐겨찾기 삭제
	@PostMapping("/lol/deleteBookMark")
	public ModelAndView deleteBookMark(@ModelAttribute String vo, HttpSession session) {
		ModelAndView mav = new ModelAndView("jsonView");
		int result = service.deleteBookMark(vo);
		if(result > 0) {
			mav.addObject("result","200");
			mav.addObject("desc","use");
		}else {
			mav.addObject("result","201");
			mav.addObject("desc","not use");
		}
		return mav;
	}
	//api 소환사검색
	@GetMapping("/lol/api/summoners")
	public String summoners(@RequestParam("userName") String userName) {
		
		String apiUrl = "https://kr.api.riotgames.com/lol/summoner/v3/summoners/by-name/"+userName+"?api_key=RGAPI-c0c1d5dd-81db-434a-b517-fc78810671b0";
		HttpURLConnection conn = null;
		BufferedReader in = null;
		JSONParser jp = new JSONParser();
		try {
				
			URL url = new URL(apiUrl);
		
			conn = (HttpURLConnection) url.openConnection(); //브라우저창에서 위에 주소입력한 후, 엔터친것과 같은 효과
			conn.setRequestMethod("GET");
						
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			String result = "";
			
			while ((inputLine = in.readLine()) != null) {
				result += inputLine;
			}
			
			try {
				System.out.println("result == " + result);
				JSONObject jo = (JSONObject) jp.parse(result);
				System.out.println("accountId =====" + jo.get("accountId"));
				System.out.println("accountId =====" + jo.get("summonerLevel"));


			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.disconnect();
			}
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "";
	}
	//전적검색
	@GetMapping("/lol/api/userMatch")
	public String Match(@RequestParam("userMatch") String userMatch) {
		
		
		String userApi = "https://kr.api.riotgames.com/lol/match/v3/matchlists/by-account/"+userMatch+"?api_key=RGAPI-c0c1d5dd-81db-434a-b517-fc78810671b0";
		HttpURLConnection conn = null;
		BufferedReader in = null;
		JSONParser jp = new JSONParser();
		try {
			
			URL url = new URL(userApi);
		
			conn = (HttpURLConnection) url.openConnection(); //브라우저창에서 위에 주소입력한 후, 엔터친것과 같은 효과
			conn.setRequestMethod("GET");
						
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			String result = "";
			
			while ((inputLine = in.readLine()) != null) {
				result += inputLine;
			}
			
			try {
				System.out.println("result == " + result);
				JSONObject jo = (JSONObject) jp.parse(result);
				System.out.println("gameId =====" + jo.get("gameId"));
				System.out.println("accountId =====" + jo.get("summonerLevel"));
				System.out.println("champion =====" + jo.get("champion"));
				System.out.println("queue =====" + jo.get("queue"));
				System.out.println("season =====" + jo.get("season"));
				System.out.println("timestamp =====" + jo.get("summonerLevel"));
				System.out.println("role =====" + jo.get("role"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null) {
				conn.disconnect();
			}
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
		return "";
		}
}