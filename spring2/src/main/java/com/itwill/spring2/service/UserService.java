package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.dto.UserSignupDto;
import com.itwill.spring2.repository.PostDao;
import com.itwill.spring2.repository.UserDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final 필드들을 초기화하는 아규먼트를 갖는 생성자
@Service
public class UserService {

	private final UserDao uerDao;

	public int UserSignup(UserSignupDto dto) {

		
		
		return 0;
	}

}