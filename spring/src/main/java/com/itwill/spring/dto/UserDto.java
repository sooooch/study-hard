package com.itwill.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// model이다 나는
@Data //->게터 세터 투스트링 이퀄스앤ㄷ해쉬코드, 리콰이얼드아그스콘스트럭터
@Builder	//@AllArgsConstructor랑 같이 사용하삼
@AllArgsConstructor //모든 필드를 초기화할 수 있는 아규먼트들을 갖는 생성자
@NoArgsConstructor // 기본 생성자
public class UserDto {

	private String username;
	private String username1;
	private Integer age;
	
}

