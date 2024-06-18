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

@WebServlet("/board/list/*")
public class BoardListController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardInfoService service = new BoardInfoService();
        List<BoardData> items = service.getList();

        req.setAttribute("items", items);

        req.setAttribute("addCss", new String[] {"board/style.css", "board/list.css"});
        req.setAttribute("addScript", List.of("board/common.js", "board/list.js"));
        //속성 설정은 RequestDispatcher 상단에 정의
        //출력 완료 되면 속성은 반영X

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/templates/board/list.jsp");
        //브라우저에서는 jsp 에 접근할 수 없지만, 서블릿쪽에서는 jsp 파일에 접근할 수 있어 보안 유지!!
        rd.forward(req, resp);

    }
}
