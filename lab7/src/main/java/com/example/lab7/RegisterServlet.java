package com.example.lab7;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import com.example.lab7.User;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get the value of the name and address parameters from our form
        String name = request.getParameter("name");
        String password = request.getParameter("name");
        String address = request.getParameter("address");

        //create a new user model (domain object)
        User user = new User (name, password, address);

        System.out.println("hereee");

//
//        //add the model as an attribute in the request
//        request.setAttribute("user", user);
//
//        //save user
//        try {
//            UserDAO.instance.save(user);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        //forward the updated request and response to out back to index
//        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
