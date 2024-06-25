package com.itwill.spring2.repository;

import com.itwill.spring2.dto.UserSigninDTO;

public interface UserDao {

	int insertUser (User user);   // 회원가입

	 User selectByUserid(String userid);   // 중복체크
	 
	 User logIn (UserSigninDTO dto);


}



