/**
 * Controller - GradeController
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
@WebServlet(name = "GradeController", value = "/GradeController")
public class GradeController extends HttpServlet {

    //create variables
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public GradeController() {
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

       String count = request.getParameter("current_row_index");



        HttpSession session = request.getSession();
        System.out.println(test.getName());
        ArrayList<Grade> currentList = (ArrayList<Grade>) request.getParameter("arrayObject");
        System.out.println(currentList);
        //System.out.println("passes list = " + currentList.get(0));
        //currentList.remove(Integer.parseInt(count));
        //currentList.trimToSize();
        //request.setAttribute("gradesList", currentList);


        request.getRequestDispatcher("showGrades.jsp").forward(request, response);

    }
}
