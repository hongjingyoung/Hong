package com.hjy.web.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	public List<MembersVO> selectmembersList(){
		return sqlSession.selectList("members.selectList");
	}
	public MembersVO selectMembersOne(MembersVO vo) {
		return sqlSession.selectOne("members.selectMembersOne", vo);
	}
	public int selectLogin(MembersVO vo) {
		return sqlSession.selectOne("members.selectLogin", vo);
	}
	//회원전체카운트
	public int selectTotalCountMembers() {
		return sqlSession.selectOne("members.selectTotalCountMembers");
	}
	//회원페이징
	public List<MembersVO> selectPagingMembers(MembersVO vo){
		return sqlSession.selectList("members.selectPagingMembers", vo);
	}
	
}
