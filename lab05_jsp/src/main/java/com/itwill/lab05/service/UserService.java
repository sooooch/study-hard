package com.itwill.lab05.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itwill.lab05.repository.User;
import com.itwill.lab05.repository.UserDao;

// 서비스(비즈니스) 계층 싱글턴 객체
// 서비스는 컨트롤러가 이용
public enum UserService {
	INSTANCE;
	
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	private final UserDao userDao = UserDao.INSTANCE;
	
	
	//  회원가입에 필요한 메서드 userDao.insert()  호츌
	public int create(User user) {
		int result = userDao.insert(user);
		
		return result;
	}
	
	// 로그인에 필요한 메서드 userDao.selectByUseridAndPassword() 호출
	public User signIn(String userid, String password) {
		log.debug("signIn(userId={},password={})",userid,password);
		
		User dto = User.builder().userid(userid).password(password).build();	
		User user = userDao.selectByUseridAndPassword(dto);
		log.debug("로그인결과 = {}",user);
		
	
		
		
		return user;
	
	}
	
}
