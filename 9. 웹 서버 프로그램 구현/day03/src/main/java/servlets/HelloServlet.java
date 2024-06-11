package servlets;


import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//HttpServlet -> jakarta ee API 문서 참조
public class HelloServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {//요청 전문 - 응답 전문
        //사용자가 찾는 url 주소와 해당하는 servlet 클래스를 연결해줘야 찾을 수 있다
        //System.out.println("안녕하세요!");
        System.out.println("doGet() - 요청마다 매번 실행");

        //모든 서블릿이 공유 가능한 초기 설정 값 - context-param
        String common1 = req.getServletContext().getInitParameter("common1");
        String common2 = req.getServletContext().getInitParameter("common2");
        System.out.printf("common1=%s, common2=%s%n", common1, common2);
    }

    /*
    @Override
    public void init() throws ServletException {
        System.out.println("init() - 객체 생성 이후 최초 한 번 실행");
    }
    */

    //설정을 위한 재료를 제공한다..?!
    @Override
    public void init(ServletConfig config) throws ServletException {
        //HelloServlet만 조회 가능
        String key1 = config.getInitParameter("key1");
        String key2 = config.getInitParameter("key2");
        System.out.printf("key1=%s, key2=%s%n", key1, key2);


//        String common1 = config.getInitParameter("common1");
//        String common2 = config.getInitParameter("common2");
//        System.out.printf("common1=%s, common2=%s", common1, common2);

    }

    @Override
    public void destroy() {
        System.out.println("destroy() - 객체 소멸 전 한번 실행");
    }
}
