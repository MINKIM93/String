package com.spring.mapper;

import java.util.ArrayList;

import com.spring.membermybatis.MemberVO;

public interface MemberMapper {
	ArrayList<MemberVO> getMembers();
	int insertMember(MemberVO member);
	void updateMember(MemberVO member);
	void deleteMember(String id);
	int getCount();
	MemberVO getMember(String id);
}