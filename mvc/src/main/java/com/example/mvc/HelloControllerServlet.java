package com.example.mvc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.mvc.User;

@WebServlet(name = "HelloControllerServlet", value = "/HelloControllerServlet")
public class HelloControllerServlet extends HttpServlet {
    private static final long serialVersionID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get the value of the name parameter from our form
        String name = request.getParameter("name");

        //create a new user model (domain object)
        User user = new User (name, "unknown");

        //add the model as an attribute in the request
        request.setAttribute("user", user);

        //forward the updated request and response to out ShowUser View
        request.getRequestDispatcher("ShowUser.jsp").forward(request, response);
    }
}
