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

@WebServlet(name="userSignUpController", urlPatterns = {"/user/signup"})
public class UserSignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(UserSignUpController.class);
	
	private final UserService userService = UserService.INSTANCE;
	
	//TODO 회원가입에 필요한 요청 처리 메서드
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/signup.jsp")
		.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		User user = User.builder()
				.userid(userid)
				.password(password)
				.email(email)
				.build();
		
		userService.create(user);
		String url = req.getContextPath() + "/user/signin";  // 이렇게 하는게 더 안전함
		
		resp.sendRedirect(url);
		
	}
}
