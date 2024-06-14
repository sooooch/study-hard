package com.itwill.spring2.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class CommentDaoTest {
	@Autowired // 의존성 주입(DI)
	private CommentDao commentDao;

	//@Test
	public void selectByPostId() {
		Assertions.assertNotNull(commentDao);
		List<Comment> co = commentDao.selectByPostId(11);
		for (Comment c : co) {
			log.debug(c.toString());
		}

	}
	
	//@Test
	public void testInsert() {
		Comment comment = Comment.builder().postId(11).username("aaaa").ctext("안녕하세요").build();
		int result = commentDao.insert(comment);
		Assertions.assertEquals(1,result);
		
	}
	
	//@Test
	public void update() {
		Comment comment = Comment.builder().ctext("수정했다잉").id(2).build();
		int rs = commentDao.update(comment);
		Assertions.assertEquals(1,rs);
		
	}
	//@Test
	public void deleteById() {

		int rs = commentDao.deleteById(3);
		Assertions.assertEquals(1,rs);
		
	}
	@Test
	public void selectCommentCount() {
		
		int co = commentDao.selectCommentCount(14);
		
			log.debug("${co} =",co);
	
		
	}

}