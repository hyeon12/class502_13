package filters;

import jakarta.servlet.*;

import java.io.IOException;

public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //한번만 호출되므로, 초기 정의 작업
        System.out.println("init()-객체 생성 직후 한번 호출");
        String key1 = filterConfig.getInitParameter("key1");
        String key2 = filterConfig.getInitParameter("key2");
        System.out.printf("key1=%s, key2=%s%n", key1, key2);
    }

    @Override
    public void destroy() {
        //자원해제나 정의작업
        System.out.println("destroy()-객체 소멸 직전 한번 호출");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //System.out.println("CommonFilter - 요청 전");

        chain.doFilter(new CommonRequestWrapper(request), response);

        //System.out.println("CommonFilter - 응답 후");
    }
}
