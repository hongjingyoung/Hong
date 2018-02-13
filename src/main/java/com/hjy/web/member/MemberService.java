package com.hjy.web.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MemberService {
	@Autowired
	MemberDAO dao;
	List<MembersVO> selectmembersList(){
		return dao.selectmembersList();
	}
	public MembersVO selectMembersOne(MembersVO vo) {	
		return dao.selectMembersOne(vo);
	}
	public int selectLogin(MembersVO vo) {
		return dao.selectLogin(vo);
	}
	//회원전체카운트
	public int selectTotalCountMembers() {
		return dao.selectTotalCountMembers();
	}
	//회원페이징
	public List<MembersVO> selectPagingMembers(MembersVO vo){
		return dao.selectPagingMembers(vo);
	}

}
