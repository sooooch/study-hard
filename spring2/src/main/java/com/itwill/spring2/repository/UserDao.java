package com.itwill.spring2.repository;

public interface UserDao {

	User selectByUseridAndPassword (User user);
}
