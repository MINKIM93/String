package com.spring.mb2replay.member;

import java.util.ArrayList;

import com.spring.mb2replay.member.*;

public interface MemberService {
	public int insertMember(MemberVO memberVO);
	public MemberVO selectMember(MemberVO memberVO);
	public ArrayList<MemberVO> getMemberlist();
	public int userCheck(MemberVO memberVO);
	public int deleteMember(MemberVO memberVO);
	
}

