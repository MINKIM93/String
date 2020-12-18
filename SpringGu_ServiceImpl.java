package com.spring.springgu;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mapper.mapper;

@Service
public class ServiceImpl implements GuService{
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<EmpVO> getEmp()
	{
		mapper empMapper = sqlSession.getMapper(mapper.class);
		
		List<EmpVO> list = empMapper.getEmp();
		System.out.println(list);
		return list;
	}

}
