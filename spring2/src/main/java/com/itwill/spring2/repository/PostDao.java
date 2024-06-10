package com.itwill.spring2.repository;

import java.util.List;

public interface PostDao {

	
	List<Post> selectOrderByIdDesc();
	
}
