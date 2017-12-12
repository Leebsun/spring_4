package com.iu.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.s4.AbstractTest;
import com.iu.util.RowNum;

public class NoticeDAOTest extends AbstractTest {
	
	@Inject
	NoticeDAO noticeDAO;
	
	public void totalCount(RowNum rowNum)throws Exception{
		int result=noticeDAO.totalCount(rowNum);
		System.out.println(result);
	}
	
	

	public void test3()throws Exception{
		RowNum rowNum = new RowNum();
		List<BoardDTO> ar=noticeDAO.selectList(rowNum);
		for(BoardDTO noticeDTO : ar){
			System.out.println(noticeDTO.getNum());
			System.out.println(noticeDTO.getTitle());
		}
		assertTrue(ar.size()>0);
	}
	

	public void test() {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setWriter("iu");
		noticeDTO.setTitle("iu_test");
		noticeDTO.setContents("iu_contents");
		int result=0;
		try {
			result=noticeDAO.insert(noticeDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, 1);
	}
	

	public void test1(){
		int result=0;
		
		try {
			result=noticeDAO.delete(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, 1);
	}
	

	public void test2(){
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("iuiu");
		noticeDTO.setContents("leee");
		noticeDTO.setNum(3);
		int result=0;
		try {
			result=noticeDAO.update(noticeDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(result, 1);
	}
	
	@Test
	public void testtt(){
		try {
			this.test();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
