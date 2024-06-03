package com.itwill.lab05.web;

import java.io.IOException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// 로그인
@WebServlet(name = "userSignInController", urlPatterns = { "/user/signin" })
public class UserSignInController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(UserSignInController.class);
	private final UserService userService = UserService.INSTANCE;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/signin.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 로그인 화면에서 사용자가
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");

		// 서비스 계층의 메서드를 호출해서 로그인 성공 여부를 판단
		User user = userService.signIn(userid, password);
		
		// 로그인 성공이면 타켓(target) 페이지, 그렇지 않으면 다시 로그인 페이지로 이동:
		String target = req.getParameter("target"); //signin 의 target
		log.debug("타겟 = {}",target);
		
		if (user != null ) { // 데이터베이스 users 테이블에서 일치하는 사용자 정보가 있는 경우
			// 세션에 로그인 정보 저장. 
			HttpSession session = req.getSession();
			session.setAttribute("signedInUser", user.getUserid());
			
			//  타겟 목적지(URL)로 이동.
			if (target == null || target.equals("")) {
			String url = req.getContextPath() + "/";    // 타겟 value 가 음슴 이니까 홈으로 ㄱㄱㄱ ㄱㄱ
			resp.sendRedirect(url);
			} else {
				resp.sendRedirect(target); //타겟이 있으니까 타겟으로 ㄱ
			}
			
		} else { // 테이블에서 일치하는 사용자 정보가 없는 경우
			// 다시 로그인 페이지로 이동
			String url1 = req.getContextPath() + "/user/signin?result=f&target=" + URLEncoder.encode(target,"UTF-8");
			resp.sendRedirect(url1);
		}

		

		
	}
}
