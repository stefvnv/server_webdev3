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
        //request.getRequestDispatcher("showGrades.jsp").forward(request, response);

        HttpSession session = request.getSession();

        getGrades((User) session.getAttribute("user"), request, response);
    }
    public static void getGrades(User user, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(GradeDAO.checkGradeValidity(user) != null){
            ArrayList<Grade> gradesList = GradeDAO.checkGradeValidity(user);

            System.out.println("setting gradeslist to not null");
            //add the model as an attribute in the request
            request.setAttribute("gradesList", gradesList);

            System.out.println(gradesList.get(0).getEmail());
        }else{
            request.getRequestDispatcher("addGrade.jsp").forward(request, response);
        }
        //data gets outputted here
        request.getRequestDispatcher("showGrades.jsp").forward(request, response);
    }

}
