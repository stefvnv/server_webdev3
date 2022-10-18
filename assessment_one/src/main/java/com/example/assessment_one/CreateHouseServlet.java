package com.example.assessment_one;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateHouseServlet", value = "/CreateHouseServlet")
public class CreateHouseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get the value of the name and address parameters from our form
        String owner = request.getParameter("owner");
        String address = request.getParameter("address");

        int noBedrooms;
        if (!request.getParameter("noBedrooms").isEmpty()) {
            noBedrooms = Integer.parseInt(request.getParameter("noBedrooms"));
        } else {
            noBedrooms = 0;
        }

        //create a new house model (domain object)
        House house = new House(owner, address, noBedrooms);

        //add the model as an attribute in the request
        request.setAttribute("house", house);

        //forward the updated request and response to out ShowHouse View
        request.getRequestDispatcher("showHouse.jsp").forward(request, response);
    }
}