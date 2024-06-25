package com.itwill.spring2.repository;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor @Builder
public class User {
	
	private Integer id;  //PK
	private String userid;
	private String password;
	private String email;
	private Integer points;
}
