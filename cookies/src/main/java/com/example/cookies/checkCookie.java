package com.example.cookies;

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
public class checkCookie extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkCookie() {
        super();
        // TODO Auto-generated constructor stub
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
        // TODO Auto-generated method stub
        Cookie[] cookies = request.getCookies();
        Boolean userExists = false;
        String userName = null;
        for(int i =0; i<cookies.length; i++) {
            System.out.println("cookie " + i);
            System.out.println(cookies[i].getName());
            System.out.println(cookies[i].getValue());

            if(cookies[i].getName().equals("name")) {
                userExists = true;
                userName = cookies[i].getValue();
            }
        }
        if(userExists) {
            System.out.print("cookie name exists... value is: ");

            System.out.println(userName);
            System.out.println("setting attribute");
            request.setAttribute("name", userName);
            System.out.println("calling display.jsp");
            request.getRequestDispatcher("Display.jsp").forward(request, response);
            //doGet(request, response);
        }else {

            request.getRequestDispatcher("GatherData.jsp").forward(request, response);

        }
    }
}
