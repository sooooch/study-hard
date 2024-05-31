package com.itwill.lab05.web;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// 회원가입
@WebServlet(name="userSignUpController", urlPatterns = {"/user/signup"})
public class UserSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(UserSignUpController.class);
	
	private final UserService userService = UserService.INSTANCE;
	
	
	
	@Override  //할게여ㅛ
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/signup.jsp")
		.forward(req, resp);
	}
	
	@Override //했어요
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		// 회원가입 폼에서 제출된 userid, password, email 요청 파라미터 값을 읽음.	
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		User user = User.builder()
				.userid(userid)
				.password(password)
				.email(email)
				.build();
		
		 // 서비스 계층의 메서드를 호출해서 회원가입.
		userService.create(user);
		
		
		String url = req.getContextPath() + "/user/signin";  // 로그인 페이지로 ㄱㄱ
		resp.sendRedirect(url);
		
		
	}
}
