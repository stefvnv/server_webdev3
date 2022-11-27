package com.example.lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkCookie
 */
@WebServlet("/checkCookie")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
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
        Cookie[] cookies = request.getCookies();
        Boolean userExists = false;

        //create variables
        String name = null;

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
        }
    }
}
