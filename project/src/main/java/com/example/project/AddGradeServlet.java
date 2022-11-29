package com.example.project;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddGradeServlet")
public class AddGradeServlet extends HttpServlet {
    private static final long serialVersionID = 1L;



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


        //create a new grade (domain object)
        Grade gradeObj = new Grade (year, module, grade, email);

        //add the model as an attribute in the request
        request.setAttribute("addingGrade", gradeObj);

        //save grade
        try {
            GradeDAO.instance.save(gradeObj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //forward the updated request and response to out back to index
        request.getRequestDispatcher("showGrades.jsp").forward(request, response);
    }
}
