package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 반복되는 코드 => 함수를 정의해서 사용! => getMode() 정의
        String url = req.getRequestURI();
        System.out.println(url);*/

        String mode = getMode(req);
        //해당 주소가 입력되면 각 Form을 가져오는 조건식
        if (mode.equals("join")){
            joinForm(req, resp);
        } else if (mode.equals("login")){
            loginForm(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mode = getMode(req);
        if(mode.equals("join")){
            joinProcess(req, resp);
        }else if(mode.equals("login")){
            loginProcess(req, resp);
        }
    }

    private String getMode(HttpServletRequest req){
        String url = req.getRequestURI();
        String[] urls = url.split("/");// "/"을 기준으로 나눠 배열에 담음
        String mode = urls.length > 0 ? urls[urls.length - 1] : "";
        // 배열갯수-1 => 배열의 가장 마지막 요소

        return mode;
    }

    // 회원가입 양식
    private void joinForm(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>회원가입</h1>");
    }

    // 로그인 양식
    private void loginForm(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<h1>로그인</h1>");
    }

    // 회원가입 처리
    private void joinProcess(HttpServletRequest req, HttpServletResponse resp){

    }

    // 로그인 처리
    private void loginProcess(HttpServletRequest req, HttpServletResponse resp){

    }
}
