package com.itwill.lab05.web;

import java.io.IOException;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.service.UserService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="userDetailsController", urlPatterns = "/user/udetails")
public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final UserService userservice = UserService.INSTANCE;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String userid = req.getParameter("userid");
		User user = userservice.read(userid);
		req.setAttribute("user", user);
		req.getRequestDispatcher("/WEB-INF/views/user/udetails.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req,resp);
	}

}
