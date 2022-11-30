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


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //gets user parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //set cookie variables
        boolean userExists = false;
        Cookie[] cookies = request.getCookies();
        String cookieName = null;

        for (int i = 0; i < cookies.length; i++) {

            //if user is stored in cookie using email, sets boolean to true
            if (cookies[i].getName().equals("email")) {
                userExists = true;

                //set cookie values
                cookieName = cookies[i].getValue();
            }
        }

        //delete
        if (request.getParameter("delete") != null) {

            //gets session
            HttpSession session = request.getSession();

            //stores current user in user object
            User currentUser = (User) session.getAttribute("user");

            //gets current users email
            email = currentUser.getEmail();

            //calls delete method in UserDAO
            try {
                UserDAO.delete(email);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if (UserDAO.checkLogin(email, password) != null) {

            //get Http session
            HttpSession session = request.getSession();

            //create a new user model (domain object)
            user = UserDAO.checkLogin(email, password);

            //set the attribute user
            session.setAttribute("user", user);

            //calls get grades method in AddGradeServlet
            AddGradeServlet.getGrades(user, request, response);

        } else {

            //data gets gathered from here
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }
    }
}
