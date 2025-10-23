package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/list doGet() 호출: 할 일 목록 조회");


        List<TodoDTO> todoDTOList = TodoService.INSTANCE.getList();
//        HttpSession session = req.getSession();
//        session.setAttribute("list", todoDTOList);
        req.setAttribute("list", todoDTOList);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/list.jsp");
        dispatcher.forward(req, resp);
    }
}
