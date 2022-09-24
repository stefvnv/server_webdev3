package com.example.hello_form_book;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BookServlet", value = "/BookServlet")
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter p = response.getWriter();

        //title
        String title = request.getParameter("title");
        p.println("<p>The title of the book is " + title + "</p><br>");

        //author
        String author = request.getParameter("author");
        p.println("<p>The author of the book is " + author + "</p>");
    }
}
