package com.iu.s4;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.iu.notice.NoticeDAO;
import com.iu.notice.NoticeDTO;

public class ConnectionTest extends AbstractTest {
	
	@Inject
	NoticeDAO noticeDAO;

	@Test
	public void test() {
		try {
			NoticeDTO noticeDTO=noticeDAO.selectOne(1);
			System.out.println(noticeDTO.getTitle());
			System.out.println(noticeDTO.getContents());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
