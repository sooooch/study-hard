package com.itwill.spring2.dto;

import com.itwill.spring2.repository.Post;

import lombok.Data;

//DTO(Data Transfer Object)
//뷰 <--> 컨트롤러, 컨트롤러 <--> 서비스 사이에서 데이터를 주고 받을 때 사용하는 객체
//   업데이트 요청의 요청 파라미터들을 저장하기 위한 DTO 

@Data
public class PostUpdateDto {
	private String title;
	private String content;
	private int id;

	public Post toEntity() {
		return Post.builder().id(id).title(title).content(content).build();

	}
}
