package com.iu.qna;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iu.board.BoardDTO;
import com.iu.file.FileDTO;
import com.iu.s4.AbstractTest;

public class QnaDAOTest extends AbstractTest {
	private QnaDAO qnaDAO;

	@Test
	public void test() {
		BoardDTO boardDTO;
		try {
			boardDTO = qnaDAO.selectOne(669);
			QnaDTO qnaDTO = (QnaDTO)boardDTO;

			System.out.println(qnaDTO.getNum());
			System.out.println(qnaDTO.getContents());

			for(FileDTO fileDTO: qnaDTO.getFileNames()){
				System.out.println("=================");
				System.out.println(fileDTO.getFileName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
