package com.spring.membermybatis;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.MemberMapper;

@Service
public class ServiceImpl implements MemberService {

	@Autowired 
	private SqlSession sqlSession;
	
	@Override
	public ArrayList<MemberVO> getMembers(){
		ArrayList<MemberVO> memberList = new ArrayList<MemberVO>();
		MemberMapper memberMapper = 
				sqlSession.getMapper(MemberMapper.class);
		memberList = memberMapper.getMembers(); 
		System.out.println(memberMapper.getCount());
		return memberList;
	}
	
	@Override
	public void insertMember(MemberVO member) {
		MemberMapper memberMapper = 
				sqlSession.getMapper(MemberMapper.class);
		int res = memberMapper.insertMember(member); 
		System.out.println("res=" + res);
	}

	@Override
	public MemberVO getMember(String id) { 
		MemberVO member = new MemberVO(); //객체생성
		MemberMapper memberMapper = 
				sqlSession.getMapper(MemberMapper.class);
		//member = memberMapper.getMember(id);
		member = memberMapper.getMember(id); // vo -> hashmap // Hashmap 이용
		
		return member;								
	}
	
	@Override
	public void updateMember(MemberVO member) {
		MemberMapper memberMapper = 
				sqlSession.getMapper(MemberMapper.class);
	}
	@Override
	public void deleteMember(String id) {
		MemberMapper memberMapper = 
				sqlSession.getMapper(MemberMapper.class);
		memberMapper.deleteMember(id);
		
	}
	
	}//class
