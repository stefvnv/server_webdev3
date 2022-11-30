/**
 * Controller - GradeController
 * Stefana Chiritescu
 * A00282343
 */

package com.example.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
     * Constructor
     */
    public GradeController() {
        super();
    }

    /**
     *
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    /**
     *
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("user");
        ArrayList<Grade> gradesList = GradeDAO.checkGradeValidity(currentUser);

        String year, module, email;
        year = request.getParameter("current_row_year");
        module = request.getParameter("current_row_module");
        email = currentUser.getEmail();

        // UPDATE
        if (request.getParameter("update") != null) {
            String newGrade;
            newGrade = request.getParameter("grade_row");


            try {
                assert gradesList != null;
                GradeDAO.update(email, year, module, newGrade, gradesList.size());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            // DELETE
        } else if (request.getParameter("delete") != null) {

            int indexToDelete = Integer.parseInt(request.getParameter("current_row_index"));
            assert gradesList != null;
            ;
            try {
                GradeDAO.delete(module, email, gradesList.size());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        request.setAttribute("gradesList", GradeDAO.checkGradeValidity(currentUser));

        request.getRequestDispatcher("showGrades.jsp").forward(request, response);

    }
}
