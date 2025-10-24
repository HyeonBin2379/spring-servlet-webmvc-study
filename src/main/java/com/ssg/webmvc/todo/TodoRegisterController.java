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
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name="todoRegisterController", urlPatterns = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {

    private final TodoService todoService;

    public TodoRegisterController() {
        todoService = TodoService.INSTANCE;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/register doGet() 호출: 회원 등록 화면 출력");
        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/register doPost() 호출: 입력을 처리하고 목록 페이지로 이동");
        String title = req.getParameter("title");
        LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"));

        try {
            TodoDTO todoDTO = TodoDTO.builder()
                    .title(title)
                    .dueDate(dueDate)
                    .build();
            todoService.register(todoDTO);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("todo register error");
        }
    }
}
