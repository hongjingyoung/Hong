package com.hjy.web.lol;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LolService {
	@Autowired
	LolDAO dao;
	

	public int selectLogin(LolVO vo) {
		return dao.selectLogin(vo);
	}
	public int insertLogin(LolVO vo) {
		return dao.insertLogin(vo);
	}
	public String selectIdCheck(String id) {
		return dao.selectIdCheck(id);
	}
	public int deleteMember(LolVO vo) {
		return dao.deleteMember(vo);
	}
	public List<BookMarkVO> selectBookMark(BookMarkVO bvo) {
		return dao.selectBookMark(bvo);
	}
	public int insertBookMark(String id) {	
		return dao.insertBookMark(id);
	}
	public int deleteBookMark(String id) {
		return dao.deleteBookMark(id);
	}

}
