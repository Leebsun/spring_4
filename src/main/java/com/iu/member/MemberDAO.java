package com.iu.member;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE="memberMapper.";
	
	public void list()throws Exception{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("startRow", 1);
		map.put("endRow", 10);
		sqlSession.selectList(NAMESPACE+"list", map);
		
		System.out.println(map.get("list"));
		
		List<MemberDTO> ar = (List<MemberDTO>) map.get("list");
		
		for(MemberDTO member : ar){
			System.out.println("id:"+ member.getId());
			System.out.println("name:"+ member.getName());
			System.out.println("age:"+ member.getAge());
			System.out.println("========================");
		}
		
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public void delete()throws Exception{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("id", "T9");
		sqlSession.delete(NAMESPACE+"delete",map);
		
		Iterator<String> it=map.keySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	public MemberDTO login(MemberDTO memberDTO)throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
		
		
	}
	
	public List<MemberDTO> selectList()throws Exception{
		return sqlSession.selectList(NAMESPACE+"selectList");
		
	}

}
