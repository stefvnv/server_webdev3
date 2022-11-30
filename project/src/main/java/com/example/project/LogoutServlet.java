/**
 * Controller - LogoutServlet
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

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * Constructor
     */
    public LogoutServlet() {
        super();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //gets session
        HttpSession session = request.getSession();

        //sets user to null
        session.setAttribute("user", null);

        //forwards to index page
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
