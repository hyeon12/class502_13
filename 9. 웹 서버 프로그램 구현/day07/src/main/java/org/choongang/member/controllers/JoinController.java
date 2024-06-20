package org.choongang.member.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.choongang.global.exceptions.CommonException;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.MemberServiceProvider;

import java.io.IOException;
import java.io.PrintWriter;

import static org.choongang.global.MessageUtil.alertError;
import static org.choongang.global.MessageUtil.go;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //회원가입 양식

        //버퍼 출력
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/member/join.jsp");
        rd.forward(req, resp); //새로운 요청 응답 처리
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //회원가입 처리 서비스 (MVC 연동)
        try {
            JoinService service = MemberServiceProvider.getInstance().joinService();
            //요청데이터 -> 서비스 내(JoinService)에서 변환작업 (RequestJoin form)
            //값을 조회해서 각각 DTO 에 넣자
            service.process(req);
            go(req.getContextPath() + "/member/login", "parent", resp);
            //resp.sendRedirect(req.getContextPath() + "/member/login");
        } catch (CommonException e) {
            alertError(e, resp);
        }
    }
}