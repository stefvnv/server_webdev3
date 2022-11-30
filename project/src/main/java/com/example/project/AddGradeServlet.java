/**
 * Controller - AddGradeServlet
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
import java.util.ArrayList;

@WebServlet("/AddGradeServlet")
public class AddGradeServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get user parameters
        String year = request.getParameter("year");
        String module = request.getParameter("module");
        String grade = request.getParameter("grade");
        String email = request.getParameter("email");

        //creates a new grade domain object
        Grade gradeObj = new Grade(year, module, grade, email);

        //add the model as an attribute in the request
        request.setAttribute("addingGrade", gradeObj);

        //save grade by calling GradeDAO save method
        try {
            GradeDAO.instance.save(gradeObj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //forward the updated request and response to out back to index
        //request.getRequestDispatcher("showGrades.jsp").forward(request, response);

        //gets session
        HttpSession session = request.getSession();

        //gets the grades of the current user
        getGrades((User) session.getAttribute("user"), request, response);
    }


    /**
     * Checks if current users' grade list is empty, forwards to relevant page
     */
    public static void getGrades(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //calls check grade validity method from GradeDAO, makes array list of grades
        if (GradeDAO.checkGradeValidity(user) != null) {
            ArrayList<Grade> gradesList = GradeDAO.checkGradeValidity(user);

            //adds the grades list as an attribute in the request
            request.setAttribute("gradesList", gradesList);

        } else {
            //forwards to add grade page
            request.getRequestDispatcher("addGrade.jsp").forward(request, response);
        }
        //forwards to show grades page
        request.getRequestDispatcher("showGrades.jsp").forward(request, response);
    }
}
