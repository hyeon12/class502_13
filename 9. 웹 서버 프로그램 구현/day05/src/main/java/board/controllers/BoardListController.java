package board.controllers;

import board.entities.BoardData;
import board.services.BoardInfoService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

//게시글 목록 컨트롤러 - 서블릿클래스
@WebServlet("/board/list/*") //게시판 주소, * = 게시글 아이디(번호)
public class BoardListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //(1) 사용자가 처리하고 나면? 처리한 데이터를 화면에 보여줘야함
        BoardInfoService service = new BoardInfoService();
        List<BoardData> items = service.getList();

        //(2) 속성을 뷰에 넘겨줘서 출력하기 위한 것이 목적이므로
        // setAttribute 을 통해 속성이 뷰로 넘어간다..!
        req.setAttribute("items", items);

        //뷰에 대한 부분 정의
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/board/list.jsp");
        //경로는 webapp가 기준(/)!
        rd.forward(req, resp); //버퍼치환 -> 기존버퍼 교체
    }
}
