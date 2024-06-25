package com.itwill.spring2.web;

import java.io.IOException;
import java.net.URLEncoder;
import static com.itwill.spring2.filter.AuthenticationFilter.SESSION_ATTR_USER;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring2.dto.UserSigninDTO;
import com.itwill.spring2.dto.UserSignupDto;
import com.itwill.spring2.repository.User;
import com.itwill.spring2.service.PostService;
import com.itwill.spring2.service.UserService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드들을 초기화하는 생성자
@Controller
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;

	@GetMapping("/signup")
	public void signupForm() {
		log.debug("signupForm()");
		// 회원가입 페이지를 렌더링하는 뷰 이름 (signup.jsp)
	}
	// 회원가입
	@PostMapping("/signup")
	public String signup(UserSignupDto dto) {
		userService.UserSignup(dto);
		return "redirect:/"; // 회원가입 후 리다이렉트할 경로
	}

	// 사용자 아이디 중복체크 REST 컨트롤러
	@GetMapping("/checkid")
	@ResponseBody // 메서드 리턴 값이 클라이언트로 전달되는 데이터
	public ResponseEntity<String> checkId(@RequestParam(name = "userid") String userid) {
		log.debug("유저아이디는 이거다={}", userid);

		boolean rs = userService.checkUserid(userid);
		if (rs) {
			return ResponseEntity.ok("Y"); // 아이디가 중복이 아니다

		} else {

			return ResponseEntity.ok("N");   // 중복이다
		}

	}
	
	 @GetMapping("/signin")
	    public void signIn() {
	        log.debug("GET signIn()");
	    }
	    
	    @PostMapping("/signin")
	    public String signIn(UserSigninDTO dto, 
	            @RequestParam(name = "target", defaultValue = "") String target,
	            HttpSession session) throws IOException {
	        log.debug("POST signIn({})", dto);
	        
	        User user = userService.UserSignin(dto);
	        String targetPage = "";
	        if (user != null) { // 아이디와 비밀번호가 일치하는 사용자 있는 경우
	            // 세션에 로그인 사용자 아이디를 저장
	            session.setAttribute(SESSION_ATTR_USER, user.getUserid());
	            
	            // 로그인 성공 후 이동할 타겟 페이지
	            targetPage = (target.equals("")) ? "/" : target;
	            
	        } else { // 아이디와 비밀번호가 일치하는 사용자 없는 경우
	            targetPage = "/user/signin?result=f&target="
	                    + URLEncoder.encode(target, "UTF-8");
	        }
	        
	        return "redirect:" + targetPage;
	    }
	    
	// TODO: 로그아웃
	
	

}
