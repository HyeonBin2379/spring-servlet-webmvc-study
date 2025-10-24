package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="todoListController", urlPatterns = "/todo/list")
@Log4j2
public class TodoListController extends HttpServlet {

    private final TodoService todoService;

    public TodoListController() {
        this.todoService = TodoService.INSTANCE;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("/todo/list doGet() 호출: 할 일 목록 조회");
        log.info("/todo list......");

        try {
            List<TodoDTO> dtoList = todoService.listAll();
            req.setAttribute("dtoList", dtoList);
            req.getRequestDispatcher("/WEB-INF/todo/list.jsp").forward(req, resp);
        } catch (Exception e) {
            // 예외 발생 시 로그 메시지 출력
            log.error(e.getMessage());
            throw new ServletException("todo list error");
        }
    }
}
