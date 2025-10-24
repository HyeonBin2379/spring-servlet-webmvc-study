package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {

    private final TodoService todoService;

    public TodoModifyController() {
        this.todoService = TodoService.INSTANCE;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/modify doGet() 호출: 회원 정보 수정 화면 출력");
        Long tno = Long.parseLong(req.getParameter("tno"));
        try {
            TodoDTO todoDTO = todoService.get(tno);
            req.setAttribute("dto", todoDTO);
            req.getRequestDispatcher("/WEB-INF/todo/modify.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo modify error");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/modify doPost() 호출");
        Long tno = Long.parseLong(req.getParameter("tno"));
        String title = req.getParameter("title");
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"));
        boolean finished = req.getParameter("finished").equals("true");

        try {
            TodoDTO todoDTO = TodoDTO.builder()
                    .tno(tno)
                    .title(title)
                    .dueDate(dueDate)
                    .finished(finished)
                    .build();
            todoService.update(todoDTO);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo update error");
        }
    }
}
