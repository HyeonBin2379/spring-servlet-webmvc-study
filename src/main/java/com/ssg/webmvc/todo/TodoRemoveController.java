package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/todo/remove")
@Log4j2
public class TodoRemoveController extends HttpServlet {

    private final TodoService todoService;

    public TodoRemoveController() {
        todoService = TodoService.INSTANCE;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/remove doPost() 호출: 회원 정보 삭제");
        try {
            Long tno = Long.parseLong(req.getParameter("tno"));
            log.info(tno);
            todoService.delete(tno);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo delete error");
        }
    }
}
