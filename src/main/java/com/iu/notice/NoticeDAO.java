package com.iu.notice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.iu.board.BoardDAO;
import com.iu.board.BoardDTO;
import com.iu.util.RowNum;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="noticeMapper.";
	
	@Override
	public List<BoardDTO> selectList(RowNum rowNum) throws Exception {

		
		return sqlSession.selectList(namespace+"selectList",rowNum);
	}

	@Override
	public BoardDTO selectOne(int num) throws Exception {
		
		return sqlSession.selectOne(namespace+"selectOne", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		System.out.println("Before: "+boardDTO.getNum());
		int result= sqlSession.insert(namespace+"insert", boardDTO);
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(namespace+"update", boardDTO);
	}

	@Override
	public int delete(int num) throws Exception {
		return sqlSession.delete(namespace+"delete", num);
	}

	@Override
	public int totalCount(RowNum rowNum) throws Exception {
		return sqlSession.selectOne(namespace+"selectOne", rowNum);
	}

	@Override
	public int hitUpdate(int num) throws Exception {
		return sqlSession.update(namespace+"hitUpdate", num);
	}

	@Override
	public int getNum() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+"getNum");
	}
	//private static final String namespace2="testMapper.";
	
	
	
	/*public int totalCount()throws Exception{
		return sqlSession.selectOne(namespace+"totalCount");
	}
	
	public List<NoticeDTO> selectList(int startRow, int lastRow)throws Exception{
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("startRow", startRow);
		map.put("lastRow", lastRow);
		map.put("kind", "title");
		map.put("search", "iu");
		
		return sqlSession.selectList(namespace+"selectList",map);
	}
	
	public NoticeDTO selectOne(int num) throws Exception{
		return sqlSession.selectOne(namespace+"selectOne", num); //파라미터는 1개만 넘길 수 있다.
	}
	
	public int insert(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.insert(namespace+"insert", noticeDTO);
	}
	
	public int delete(int num)throws Exception{
		return sqlSession.delete(namespace+"delete", num);
	}
	
	public int update(NoticeDTO noticeDTO) throws Exception{
		return sqlSession.update(namespace+"update", noticeDTO);
	}*/

}
