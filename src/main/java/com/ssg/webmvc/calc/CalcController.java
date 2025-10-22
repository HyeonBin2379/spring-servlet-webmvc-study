package com.ssg.webmvc.calc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// PRG 패턴(POST-Redirect-GET)
// post 방식과 redirect를 결합해서 사용하는 패턴 - 게시판 구현 시 사용
// 1. 사용자는 컨트롤러에 원하는 작업을 post 방식으로 처리하기를 요청
// 2. post 방식을 컨트롤러에서 처리하고, 브라우저는 다른 경로로 이동
// 3. 브라우저는 get 방식으로 이동
@WebServlet(name = "calcController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.println(num1 + " " + num2);

        resp.sendRedirect("/calc/input");
    }
}
