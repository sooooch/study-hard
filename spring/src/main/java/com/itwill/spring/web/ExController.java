package com.itwill.spring.web;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.spring.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // ->>>>>>> private static final Logger log = LoggerFactory.get ........ 이거임
@Controller  //-> 디스패쳐 서블릿에게 컨트롤러 컴포넌트임을 알려줌. ( servlet-context.xml 파일에서는 <context:component-scan.../>설정
                   // 컨트롤러 클래스에서는 @Controller 애너테이션 해야함
					// 디스패쳐 서블릿이 컨트롤러 객체를 생성, 관리.
public class ExController {

	@GetMapping("/")
	public String home(Model model) {
		log.debug("home()");
		
		LocalDateTime now = LocalDateTime.now();
		model.addAttribute("now",now);
		// Model 객체는 컨트롤러에서 뷰로 데이터를 전달할 때 사용.
		// request.setAttribute(name, object)와 비슷한 기능임.
		
		return "home";
		//-> 컨트롤러 메서드가 문자열을 리턴하면, 디스패쳐 서블릿이 뷰의 이름을 찾는 데 사용
		// 디스패쳐 서블릿이 뷰 리졸버를 이용해서 
		// <property name="prefix" value="/WEB-INF/views/"/>
    	// <property name="suffix" value=".jsp" />   이렇게 해놔서 /WEB-INF/views/home.jsp 이렇게 되는거임
	}
	
	@GetMapping("/example")
	public void controllerExample() {
		log.debug("controllerExample()");
		// 컨트롤러 메서드가 리턴 값이 없는 경우,
		// 요청 주소가 뷰의 이름이 됨.
	}
	
	
	@GetMapping("/ex1")
	public void ex1(@RequestParam(name= "username")String username,
	@RequestParam(name="age", defaultValue = "0") int age ,Model model){
		log.info("ex1(username= {}, age= {}",username,age);
		String inf = username+age;
		model.addAttribute("inf",inf);
		
		// 요청 파라미터 값들로 UserDto 객체를 생성:
		UserDto user = UserDto.builder().username(username).age(age).build();
		if (user.getUsername1() == null) {
			user.setUsername1("username1은 없다");
		}
		// UserDto 객체를 뷰로 전달
		model.addAttribute("user", user);
		
	}
	
	
	@PostMapping("/ex2")
	public String ex2(@ModelAttribute(name = "user")UserDto dto ) {
		log.debug("ex2(dto={})",dto);
		if (dto.getUsername() == null) {
			dto.setUsername("없다");
		}
		
		//->@ModelAttribute(name = "user")UserDto dto 선언은
		//model.addAttribute("user",dto); 코드 작성과 같은 효과.
		//컨트롤러에서 뷰로 전달하는 데이터
		
		return "ex1";
	}
	
	@GetMapping("/test")
	public void test () {
		log.debug("test()");
	}
	
	@GetMapping("/test2")
	public  String forward() {
		log.debug("forward()");
		
		return "forward:/test"; // 컨트롤러 메서드가 "forward:"으로 시작하는 문자열을 리턴 -> 포워드 방식 이동.
								// 포워드 방식의 페이지 이동 : 최초 요청 주소가 바뀌지 않음! (리퀘스트,리스폰스 그대로 유지가 됨)
	}
	
	@GetMapping("/test3")
	public String redirect() {
		log.debug("redirect()");
		
		return "redirect:/test"; // 컨트롤러 메서드가 "redirect:"으로 시작하는 문자열을 리턴 -> 리다이렉트 방식 이동
								// 리다이렉트 방식의 페이지 이동 : 최초 요청 주소가 바뀜!
	}
	
	@GetMapping("/rest1")
	@ResponseBody //-> 컨트롤러 메서드가 리턴하는 값이 뷰를 찾기 위한 문자열이 아니라,
					// 클라이언트로 직접 응답되는 데이터. 응답 패킷(response packet)의 몸통(body)에 포함되는 데이터
	public String rest1() {
		log.debug("rest1()");
		
		return"안녕하세요!";
	}
	
	@GetMapping("/rest2")
	@ResponseBody
	public UserDto rest2() {
		log.debug("rest2()");
		
		return UserDto.builder().username("길동홍").age(111).build();
		//-> REST 컨트롤러가 리턴한 자바 객체를 jackson-databind 라이브러리에서
		// JSON(JavaScript object Notation) 형식의 문자열로 변환하고,
		// 클라이언트로 응답을 보냄.
	}
	
	

}
