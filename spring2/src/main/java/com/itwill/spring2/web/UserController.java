package com.itwill.spring2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.spring2.repository.User;
import com.itwill.spring2.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor // final 필드들을 초기화하는 생성자
@Controller
@RequestMapping("/user")
public class UserController {

	
	@GetMapping("/signup")
public void signup(User user) {
	
		
		
}
	
	
	
}
