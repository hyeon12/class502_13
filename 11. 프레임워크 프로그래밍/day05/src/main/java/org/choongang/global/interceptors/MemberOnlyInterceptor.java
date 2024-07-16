package org.choongang.global.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
//HandlerInterceptor 내부 - 디폴트 메서드(필요한 메서드만 꺼내 사용)
public class MemberOnlyInterceptor implements HandlerInterceptor {
    //회원 전용 페이지 인터셉터 (마이페이지를 만들자!)
    //preHandle() : 컨트롤 빈이 실행되기 전, "공통 처리" -> 공통 값을 유지하도록

    //시점에 대한 차이 구분 **

    //메서드 실행 이전
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("preHandle()");

        HttpSession session = request.getSession();
        if(session.getAttribute("member") != null){ // 로그인 상태인 경우
            return true; // 컨트롤러 빈 메서드 실행
        }

        response.sendRedirect(request.getContextPath() + "/member/login");

        return false; // 미로그인 상태
    }

    //메서드 실행 직후
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //컨트롤러 빈이 실행되면 modelAndView 가 반환
        modelAndView.addObject("message", "postHandle!");

        log.info("postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 정상적으로 처리되는 경우 Exception = null / 오류 생긴 경우 Exception throws
        log.info("afterCompletion()");
    }
}
