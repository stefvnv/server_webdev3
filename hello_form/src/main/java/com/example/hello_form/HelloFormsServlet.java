package com.example.hello_form;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloFormsServlet", value = "/HelloFormsServlet")
public class HelloFormsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //set the content type
        response.setContentType("text/html");

        //get the printWriter for the response
        PrintWriter p = response.getWriter();

        //get the name parameter from the request
        String name = request.getParameter("name");

        //output will be in views usually
        p.println("<h3>Hello " + name + "</h3>");
        p.close();
    }
}
