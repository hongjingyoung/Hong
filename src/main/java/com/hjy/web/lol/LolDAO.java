package com.hjy.web.lol;




import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class LolDAO {
		
	@Autowired
	SqlSession sqlSession;
		
	//로그인
	public int selectLogin(LolVO vo) {
		return sqlSession.selectOne("lol.selectLogin", vo);
	}
	//회원가입
	public int insertLogin(LolVO vo) {
		return sqlSession.insert("lol.insertLogin", vo);
	}
	//아이디 중복체크
	public String selectIdCheck(String id) {
		return sqlSession.selectOne("lol.selectIdCheck", id);
	}
	//회원탈퇴
	public int deleteMember(LolVO vo) {
		return sqlSession.delete("lol.deleteMember", vo);
	}
	//즐겨찾기 보기
	public List<BookMarkVO> selectBookMark(BookMarkVO bvo) {
		return sqlSession.selectList("lol.selectBookMark", bvo);
	}
	//즐겨찾기 추가
	public int insertBookMark(String id) {	
		return sqlSession.insert("lol.insertBookMark", id);
	}
	//즐겨찾기 삭제
	public int deleteBookMark(String id) {
		return sqlSession.delete("lol.deleteBookMark", id);
	}
}
