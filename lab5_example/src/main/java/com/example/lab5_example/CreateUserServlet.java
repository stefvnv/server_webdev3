package com.example.lab5_example;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.example.lab5_example.User;

@WebServlet(name = "CreateUserServlet", value = "/CreateUserServlet")
public class CreateUserServlet extends HttpServlet {
    private static final long serialVersionID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get the value of the name and address parameters from our form
        String name = request.getParameter("name");
        String address = request.getParameter("address");

        //create a new user model (domain object)
        User user = new User (name, address);

        //add the model as an attribute in the request
        request.setAttribute("user", user);

        //forward the updated request and response to out ShowUser View
        request.getRequestDispatcher("showUser.jsp").forward(request, response);
    }
}
