package com.example.library.servlet.authorServlet;

import com.example.library.repository.AuthorRepository;
import com.example.library.repository.IAuthorRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthorDeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        IAuthorRepository repository = new AuthorRepository();

        String id = req.getParameter("id");

        repository.delete(id);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/authors");
        dispatcher.forward(req, resp);
    }
}
