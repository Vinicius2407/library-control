package com.example.library.servlet.authorServlet;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AuthorServlet", urlPatterns = {"", "/authors"})
public class AuthorServlet  extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorRepository repository = new AuthorRepository();

        List<Author> authors = new ArrayList<>();

        try {
            authors = repository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        req.setAttribute("authors", authors);

        RequestDispatcher dispatcher = req.getRequestDispatcher("authors.jsp");
        dispatcher.forward(req, resp);
    }
}
