package com.example.lab6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieInfo
 */
@WebServlet("/CookieInfo")
public class CookieInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieInfo() {
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

        //get parameters
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String creditCardNumber = request.getParameter("creditCardNumber");
        String expiryDate = request.getParameter("expiryDate");
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");


        String userString = name + address;

        //set cookies
        Cookie cookie= new Cookie("user_string", userString);


        cookie.setMaxAge(360*24);
        response.addCookie(cookie);

        System.out.println(request.getCookies());
        request.setAttribute("name", name);
        request.setAttribute("address", address);
        request.setAttribute("creditCardNumber", creditCardNumber);
        request.setAttribute("expiryDate", expiryDate);
        request.setAttribute("addressLine1", addressLine1);
        request.setAttribute("addressLine2", addressLine2);


        //data gets displayed here
        request.getRequestDispatcher("printData.jsp").forward(request, response);
    }
}
