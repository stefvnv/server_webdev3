package com.example.lab8;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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


        //add the model as an attribute in the request
        request.setAttribute("user", user);

        //save user
        try {
            UserDAO.instance.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //forward the updated request and response to out back to index
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
