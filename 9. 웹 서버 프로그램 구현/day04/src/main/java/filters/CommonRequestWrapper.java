package filters;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper {

    public CommonRequestWrapper(ServletRequest request) {
        //원래 매개변수 HttpServletRequest -> 유연하게 사용하기 위해 매개변수의 자료형을 상위 클래스인 ServletRequest
        //super() 매개변수 -> 형변환
        super((HttpServletRequest) request);

        // 요청 전 공통 처리 부분
        System.out.println("요청 전 공통 처리 코드 .... ");
    }

    @Override
    public String getParameter(String name) {
        String value = super.getParameter(name);
        //상위 쪽 값을 가지고 와서 커스텀 가능하게...!! 기본 기능을 커스텀하기위해

        value = value == null ? value : "🌙" + value + "⭐";

        return value;
    }
}
