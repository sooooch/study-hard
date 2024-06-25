package com.itwill.spring2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.itwill.spring2.dto.PostCreateDto;
import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.dto.PostSearchDto;
import com.itwill.spring2.dto.PostUpdateDto;
import com.itwill.spring2.repository.CommentDao;
import com.itwill.spring2.repository.Post;
import com.itwill.spring2.repository.PostDao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor // final 필드들을 초기화하는 아규먼트를 갖는 생성자
/*
 * = public PostService(PostDao postDao) { this.postDao = postDao; }
 */
@Service // 스프링 컨테이너에 서비스 컴포넌트로 등록.
public class PostService {

	// 애너테이션을 사용한 의존성 주입(DI: Dependency Injection)
	// @Autowired
	// private PostDao postDao;

	// 생성자에 의한 의존성 주입:
	// (1) final 필드 선언. (2) final 필드를 초기화하는 생성자 작성.
	private final PostDao postDao;
	private final CommentDao commentDao;

	public List<PostListDto> read() {
		log.debug("read()");

		List<Post> list = postDao.selectOrderByIdDesc();

//		List<PostListDto> result = new ArrayList<>();
//		for (Post p : list) {
//			result.add(PostListDto.fromEntity(p));
//		}       (아래랑 같은거임)
		
		return list.stream()
				.map(PostListDto::fromEntity)  // map((x) -> PostListDto.fromEntity(x))
				.toList();
	}
	
	public Post detail(int id) {
		
		Post dlist = postDao.selectById(id);
		return dlist;
	}
	
	
	public int create(PostCreateDto dto) {
		
		int newlist = postDao.insertPost(dto.toEntity());
		return newlist;
	}
	
	public int delete(int id) {
		log.debug("delete(id={})",id);
		// 게시물 지우기전에 제약조건 땜시 참조하고있는 댓글테이블의 postId를 먼저 지워야함
		commentDao.deleteByPostId(id);
		// 리포지토리 컴포넌트의 메서드를 호출해서 delete 쿼리를 실행
		int result = postDao.deletePost(id);
		
		log.debug("delete 결과 = {}",result);
		
		return result;		
	}
	

	
	public int updete(PostUpdateDto dto) {
		int result = postDao.updatePost(dto.toEntity());
		return result;
		
		
	}
	
	public List<PostListDto> search(PostSearchDto dto) {
		List<Post> list = postDao.search(dto);
		return list.stream()
				.map(PostListDto::fromEntity)  // map((x) -> PostListDto.fromEntity(x))
				.toList();
		
	}

}
