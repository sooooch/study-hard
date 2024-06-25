package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.dto.UserSigninDTO;
import com.itwill.spring2.dto.UserSignupDto;
import com.itwill.spring2.repository.PostDao;
import com.itwill.spring2.repository.User;
import com.itwill.spring2.repository.UserDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor // final 필드들을 초기화하는 아규먼트를 갖는 생성자
@Service
@Slf4j
public class UserService {

	private final UserDao userDao;

		// 회원가입 서비스
	public int UserSignup(UserSignupDto dto) {

		int rs = userDao.insertUser(dto.toEntity());

		return rs;
	}
	
	
	// 아이디 중복 체크: true - 중복되지 않은 아이디(사용 사능한 아이디), false - 중복된 아이디	
	public boolean checkUserid(String userid) {
		log.debug("유저아이디:{}",userid);
		
		User user = userDao.selectByUserid(userid);
		if (user == null) { //userid가 일치하는 레코드가 없을 때(중복된 아이디가 없는 경우)
			return true;
		} else { // userid가 일치하는 레코드가 있을 때(아이디가 중복된 경우)
			return false;
			
		}
	}
	
	// 로그인
	public User UserSignin(UserSigninDTO u) {
		User rs = userDao.logIn(u);
		
		return rs;
	}
	
   
    
	
	

}