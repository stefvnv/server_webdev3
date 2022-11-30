/**
 * Controller - UserController
 * Stefana Chiritescu
 * A00282343
 */

package com.example.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {

    //initialize variables
    private static final long serialVersionUID = 1L;
    ArrayList<User> users = null;
    private User user;

    /**
     * Constructor
     */
    public UserController() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }


    /**
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //gets user parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");



        boolean userExists = false;

        Cookie[] cookies = request.getCookies();

        String cookieName = null;
        for (int i = 0; i < cookies.length; i++) {

            System.out.println("cookie " + i);
            System.out.println(cookies[i].getName());
            System.out.println(cookies[i].getValue());

            if (cookies[i].getName().equals("email")) {
                userExists = true;

                //set values
                cookieName = cookies[i].getValue();
            }
        }

        if (UserDAO.checkLogin(email, password) != null) {
            System.out.print("cookie name exists... value is: ");
            System.out.println(name);
            System.out.println("setting attribute...");

            //get session
            HttpSession session = request.getSession();

            //create a new user model (domain object)
            user = UserDAO.checkLogin(email, password);

            //set the attribute user
            session.setAttribute("user", user);

            AddGradeServlet.getGrades(user, request, response);


        } else {
            //data gets gathered from here
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }
    }
}
