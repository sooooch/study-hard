package com.itwill.lab05.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class CharacterEncodingFilter extends HttpFilter{
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CharacterEncodingFilter.class);
    private String encoding;

    //WAS가 필터객체를 생성한후 필터초기화 작업 하기위해서 호출하는 메서드.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //web.xml에서 <filter>의 <param-name>값을 아규먼트로 전달하면.
        //<filter>의 <param-value> 값을 리턴해줌.
        encoding = filterConfig.getInitParameter("encoding");
        log.debug("init: encoding={}",encoding);
    }
    //필터체인(->서블릿)으로 진행하기 위해서 WAS가 호출하는 메서드.
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            //요청(request)객체의 문자열 인코딩 타입을 (UTRF-8)로 설정.
            request.setCharacterEncoding(encoding);

            //다음 필터체인을 진행..(-> 서블릿메서드(doGet,doPost)호출.
            chain.doFilter(request, response);

    }
}