package com.ssg.webmvc.calc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 웹 브라우저에서 경로 '/calc/input'을 갖는 URL에 관한 GET 요청에 관해
// /WEB-INF/calc/input.jsp 파일을 매핑하는 서블릿
@WebServlet(name="inputController", urlPatterns="/calc/input")
public class InputController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InputController 요청된 doGet()");

        // RequestDispatcher: 서블릿에서 전달된 요청을 다른 쪽으로 전달/배포하기 위한 중간 경유지 역할 수행
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        dispatcher.forward(req, resp);
    }
}
