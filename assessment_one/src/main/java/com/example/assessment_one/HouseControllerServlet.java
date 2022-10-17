package com.example.assessment_one;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HouseControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<House> houseList = HouseDAO.instance.list();
        request.setAttribute("house", houseList);

        //forward the updated request and response to out ShowHouse View
        request.getRequestDispatcher("showHouse.jsp").forward(request, response);
    }
}
