package com.itwill.spring2.service;

import org.springframework.stereotype.Service;

import com.itwill.spring2.repository.PostDao;
import com.itwill.spring2.repository.UserDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
private final UserDao uerDao;
	
	
}