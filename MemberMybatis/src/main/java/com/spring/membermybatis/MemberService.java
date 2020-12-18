package com.spring.membermybatis;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring.membermybatis.MemberVO;

public interface MemberService {
	public ArrayList<MemberVO> getMembers();
	public MemberVO getMember(String id);
	public void insertMember(MemberVO member);
	public void updateMember(MemberVO member);
	public void deleteMember(String id);
}
