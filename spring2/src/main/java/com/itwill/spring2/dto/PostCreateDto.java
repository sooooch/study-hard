package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Post;

import lombok.Data;

//DTO(Data Transfer Object)
//뷰 <--> 컨트롤러, 컨트롤러 <--> 서비스 사이에서 데이터를 주고 받을 때 사용하는 객체

@Data
public class PostCreateDto {

	// 필드 이름을 요청 파라미터 이름과 같게 선언 & 기본 생성자 & setter
	private String title;
	private String content;
	private String author;
	
	public Post toEntity() {
		return Post.builder().title(title).content(content).author(author).build();
	}
}
