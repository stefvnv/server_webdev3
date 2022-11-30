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


        int indexToDelete = Integer.parseInt(request.getParameter("current_row_index"));

        System.out.println("INDEX CLICKED = " + indexToDelete);
        HttpSession session = request.getSession();

        User test = (User) session.getAttribute("user");

        ArrayList<Grade> gradesList = GradeDAO.checkGradeValidity(test);
        String moduleToDelete, emailToDelete;
        assert gradesList != null;
        moduleToDelete = gradesList.get(indexToDelete).getModule();
        emailToDelete = gradesList.get(indexToDelete).getEmail();
        gradesList.remove(indexToDelete);
        gradesList.trimToSize();
        try {
            GradeDAO.delete(gradesList, moduleToDelete, emailToDelete);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("gradesList", GradeDAO.checkGradeValidity(test));

        request.getRequestDispatcher("showGrades.jsp").forward(request, response);

    }
}
