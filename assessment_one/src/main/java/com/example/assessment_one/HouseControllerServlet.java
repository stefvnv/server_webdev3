package com.example.assessment_one;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HouseControllerServlet", value = "/HouseControllerServlet")
public class HouseControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //create a new houseList model from HouseDAO (domain object)
        List<House> houseList = HouseDAO.instance.list();

        //add the model as an attribute in the request
        request.setAttribute("houseList", houseList);

        //forward the updated request and response to out ShowList View
        request.getRequestDispatcher("showList.jsp").forward(request, response);
    }
}
