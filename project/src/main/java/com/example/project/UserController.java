/**
 * Controller - UserController
 * Stefana Chiritescu
 * A00282343
 */

package com.example.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class UserController
 */
@WebServlet(name = "UserController", value = "/UserController")
public class UserController extends HttpServlet {

    //create variables
    private static final long serialVersionUID = 1L;
    ArrayList<User> users = null;

    /**
     *
     */
    public UserController() {
        super();
    }

    /**
     *
     */
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
        //String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println(request.getParameter("email"));

        //create a new user model (domain object)
        User user = new User (email, password);

        Cookie[] cookies = request.getCookies();
        boolean userExists = false;

        String name = null;
        for (int i = 0; i < cookies.length; i++) {

            System.out.println("cookie " + i);
            System.out.println(cookies[i].getName());
            System.out.println(cookies[i].getValue());

            if (cookies[i].getName().equals("email")) {
                userExists = true;

                //set values
                name = cookies[i].getValue();
            }
        }
        if (userExists) {
            System.out.print("cookie name exists... value is: ");
            System.out.println(name);
            System.out.println("setting attribute...");

            //set request attribute
            request.setAttribute("name", name);

            System.out.println("calling display.jsp");

            //data gets outputted here
            request.getRequestDispatcher("showGrades.jsp").forward(request, response);

        } else {
            //data gets gathered from here
            request.getRequestDispatcher("signUp.jsp").forward(request, response);

        }


        /**
        try {
            //ArrayList<User> users = UserDAO.instance.list();
            //save user to database by calling method in DAO
            //UserDAO.instance.save(user);
            //String check = "mcurran@ait.ie";
            //User user = UserDAO.instance.selectOne(check);
            //System.out.println(u1.getName());
            //request.setAttribute("userList", users);

            //get session
            HttpSession session = request.getSession();

            session.setAttribute("user", user);

            request.getRequestDispatcher("showGrades.jsp").forward(request, response);
        } catch (Exception e) {

            System.out.println("User does not exist, going to Sign Up page.");

            //forward the updated request and response to sign up page
            request.getRequestDispatcher("signUp.jsp").forward(request, response);
        }


        /**
        //delete user
        Boolean deleted = UserDAO.instance.deleteUser("Martina");
        if(deleted == true) {
            System.out.println("deleted");
        }else {
            System.out.println("nope doesn't exist!");
        }
         **/
    }
}
