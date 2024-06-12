package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Post;

import lombok.Data;

@Data
public class PostSearchDto {
	
	private String category;
	private String keyword;
	
	

	
}
