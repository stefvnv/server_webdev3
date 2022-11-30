/**
 * Controller - SignUpServlet
 * Stefana Chiritescu
 * A00282343
 */

package com.example.project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {

    //initialize variables
    private static final long serialVersionID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get user parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //create a new user model (domain object)
        User user = new User(name, email, password);

        //add the model as an attribute in the request
        request.setAttribute("user", user);

        //gets session
        HttpSession session = request.getSession();

        //save user
        try {
            UserDAO.instance.save(user);
        } catch (Exception e) {
            System.out.println("Email must be unique");

            session.setAttribute("DUPLICATE_EMAIL", "true");

            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }
        session.setAttribute("DUPLICATE_EMAIL", "false");

        //forwards the updated request and response to out back to index
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
