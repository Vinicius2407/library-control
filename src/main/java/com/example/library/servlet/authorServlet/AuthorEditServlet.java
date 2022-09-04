package com.example.library.servlet.authorServlet;

import com.example.library.model.Author;
import com.example.library.repository.AuthorRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthorEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorRepository repository = new AuthorRepository();

        req.setCharacterEncoding("UTF-8");

        if(req.getParameter("id") != null) {
            String id = String.valueOf(req.getParameter("id"));

            Author author = repository.findById(id);

            req.setAttribute("author", author);

            RequestDispatcher dispatcher = req.getRequestDispatcher("author-edit.jsp");
            dispatcher.forward(req, resp);
        } else {
            Author author = new Author();

            String id = req.getParameter("field-id");
            String name = req.getParameter("field-name");

            author.setId(id);
            author.setName(name);

            repository.save(author);

            resp.sendRedirect("authors");
        }
    }
}
