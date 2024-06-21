package org.choongang.global.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/*") //모든 페이지에 공통적으로 유입될 필터 /*
public class CommonFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //모든 요청에 공통으로 응답할 필터
        chain.doFilter(new CommonRequestWrapper(request), response);
    }
}
