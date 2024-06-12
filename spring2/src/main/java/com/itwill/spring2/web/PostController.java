package com.itwill.spring2.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.spring2.dto.PostCreateDto;
import com.itwill.spring2.dto.PostListDto;
import com.itwill.spring2.dto.PostSearchDto;
import com.itwill.spring2.dto.PostUpdateDto;
import com.itwill.spring2.repository.Post;
import com.itwill.spring2.service.PostService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor // final 필드들을 초기화하는 생성자
@Slf4j
@Controller
@RequestMapping("/post") //-> PostController 클래스의 모든 컨트롤러 메서드의 매핑 주소는 "/post"로 시작
public class PostController {
	
	private final PostService postService; // 생성자에 의한 의존성 주입

	@GetMapping("/list")
	public void list(Model model) {
		// 뷰: /WEB-INF/views/post/list.jsp
		log.debug("list()");
		
		// 서비스 컴포넌트의 메서드를 호출, 포스트 목록을 읽어옴 -> 뷰에 전달.
		List<PostListDto> list = postService.read();
		model.addAttribute("posts",list);  // posts에 list를 담아서 뷰로 전달
	}
	
	@GetMapping({"/details", "/modify"}) // 하는일이 같아서 밑에 로직을 안 쓰고 문자열 배열로 씀
	public void details(@RequestParam(name= "id")int id,Model model) {
		
		Post post = postService.detail(id);
		
		model.addAttribute("post",post);
		
	}
	
//	@GetMapping("/modify")
//	public void modifiy(@RequestParam(name= "id")int id,Model model) {
//		
//		Post post = postService.detail(id);
//		
//		model.addAttribute("post",post);
//	}
	
	
	
	@GetMapping("/create")
	public void create() {
		log.debug("create() GET");
		
		
	}
	
	@PostMapping("/create")
	public String create(PostCreateDto dto) {
		log.debug("Post: create(dto={})", dto);
		
		// 서비스 컴포넌트의 메서드를 호출해 데이터베이스에 새 글을 저장
		postService.create(dto);
		
		
		return "redirect:/post/list"; //포스트 목록 페이지로 리다이렉트
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam(name= "id")int id,Model model) {
		// 서비스 컴포넌트의 메서드를 호출해서
		postService.delete(id);
		return "redirect:/post/list";
		
	}
	
	@PostMapping("/update")
	public String update(PostUpdateDto dto) {
		postService.updete(dto);
		
		return "redirect:/post/details?id=" + dto.getId();
	}
	
	@GetMapping("/search")
	public String list(PostSearchDto dto,Model model) {
	
		
		// 서비스 컴포넌트의 메서드를 호출, 포스트 목록을 읽어옴 -> 뷰에 전달.
		List<PostListDto> list = postService.search(dto);
		model.addAttribute("posts",list);  // posts에 list를 담아서 뷰로 전달
		
		return "post/list";
	}
	
	
}
