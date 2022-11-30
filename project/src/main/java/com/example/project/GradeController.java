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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //gets session
        HttpSession session = request.getSession();

        //stores session user in user object
        User currentUser = (User) session.getAttribute("user");

        //
        ArrayList<Grade> gradesList = GradeDAO.checkGradeValidity(currentUser);

        //gets grade parameters
        String year = request.getParameter("current_row_year");
        String module = request.getParameter("current_row_module");
        String email = currentUser.getEmail();

        //update
        if (request.getParameter("update") != null) {
            String newGrade;
            newGrade = request.getParameter("grade_row");

            //calls update method in GradeDAO
            try {
                assert gradesList != null;
                GradeDAO.update(email, year, module, newGrade, gradesList.size());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            //delete
        } else if (request.getParameter("delete") != null) {

            int indexToDelete = Integer.parseInt(request.getParameter("current_row_index"));
            assert gradesList != null;

            //calls delete method in GradeDAO
            try {
                GradeDAO.delete(module, email, gradesList.size());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        //sets grade list of the current user
        request.setAttribute("gradesList", GradeDAO.checkGradeValidity(currentUser));

        //forwards to show grades page
        request.getRequestDispatcher("showGrades.jsp").forward(request, response);
    }
}
