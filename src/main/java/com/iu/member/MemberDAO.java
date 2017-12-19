package com.iu.member;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="memberMapper.";
	
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
		
		
	}
	
	public List<MemberDTO> selectList()throws Exception{
		return sqlSession.selectList(NAMESPACE+"selectList");
		
	}

}
