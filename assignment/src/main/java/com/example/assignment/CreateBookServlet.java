package com.example.assignment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.assignment.Book;

@WebServlet(name = "CreateBookServlet", value = "/CreateBookServlet")
public class CreateBookServlet extends HttpServlet {
    private static final long serialVersionID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //get the value of the title and author parameters from our form
        String title = request.getParameter("title");
        String author = request.getParameter("author");

        //create a new book model (domain object)
        Book book = new Book (title, author);

        //add the model as an attribute in the request
        request.setAttribute("book", book);

        //forward the updated request and response to out ShowUser View
        request.getRequestDispatcher("showBook.jsp").forward(request, response);
    }
}
