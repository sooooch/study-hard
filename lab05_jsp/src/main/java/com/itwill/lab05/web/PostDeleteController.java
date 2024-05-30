package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.Post;
import com.itwill.lab05.service.PostService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name="PostDeleteController" ,urlPatterns= {"/post/delete"})
public class PostDeleteController extends HttpServlet {
	private final PostService postService = PostService.INSTANCE;
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(PostDeleteController.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		log.debug("doGet()");
		
		// 쿼리 문자열에 포함된 요청 파라미터 id 값을 읽음
		int id = Integer.parseInt(req.getParameter("id"));
		log.debug("id={}",id);
		
		// TODO: 서비스 계층의 메서드를 호출해서 글 삭제 서비스를 실행
		postService.delete(id);
		
		// 목록 페이지로 이동(redirect)  주소가 바뀌니까 redirect   안 바뀌면 forward
		String url = req.getContextPath() + "/post/list";
		resp.sendRedirect(url);  // 리스트 페이지로 이동
		
		
	}
}
