package com.example.lab8;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Servlet implementation class checkCookie
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Cookie[] cookies = request.getCookies();
        //Boolean userExists = false;

        //get parameters
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //checks login
        //UserDAO.checkLogin(name, password);

        if (UserDAO.checkLogin(name, password) != null) {

            //get session
            HttpSession session = request.getSession();

            //set attribute user
            session.setAttribute("user", name);

            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }


        /**
         //create variables
         String name = null;
         String password = null;

         for (int i = 0; i < cookies.length; i++) {

         System.out.println("cookie " + i);
         System.out.println(cookies[i].getName());
         System.out.println(cookies[i].getValue());

         if (cookies[i].getName().equals("name")) {
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

         //data gets dispatched here
         request.getRequestDispatcher("hello.jsp").forward(request, response);
         } else {

         //data gets dispatched here
         request.getRequestDispatcher("enterName.jsp").forward(request, response);
         }**/
    }
}
