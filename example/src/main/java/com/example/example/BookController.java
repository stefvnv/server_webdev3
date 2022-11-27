package com.example.example;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.example.Book;
import com.example.example.User;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String t = request.getParameter("bookTitle");
        String a = request.getParameter("bookAuthor");

        ArrayList<Book> listOfBooks = new ArrayList();

        Book b1 = new Book(t, a);
        listOfBooks.add(b1);
        Book b2 = new Book("Killing Floor", "Lee Child");
        Book b3 = new Book("Circle of Friends", "Maeve Binchy");
        listOfBooks.add(b2);
        listOfBooks.add(b3);

        request.setAttribute("myList", listOfBooks);
        request.getRequestDispatcher("showBooks.jsp").forward(request, response);
    }

}
