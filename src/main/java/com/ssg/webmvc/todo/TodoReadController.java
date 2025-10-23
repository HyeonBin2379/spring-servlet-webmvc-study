package com.ssg.webmvc.todo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/read doGet() 호출: 회원 정보 조회 화면 출력");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/read.jsp");
        dispatcher.forward(req, resp);
    }
}
