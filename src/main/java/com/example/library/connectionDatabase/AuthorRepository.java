package com.example.library.connectionDatabase;

import com.example.library.model.Author;

import java.sql.*;

public class AuthorRepository implements IAuthorRepository {

    Connection conn = ConnectionFactory.getConnection();

    public static void main(String[] args) {
        Author author = new Author();
        AuthorRepository authorRepository = new AuthorRepository();

        author.setName("Bruno Silveira Gostoso");

       authorRepository.save(author);
    }

    @Override
    public void save(Author author) {
        try {
            Statement stmt = conn.createStatement();

            stmt.execute("INSERT INTO author (id ,name) VALUES (nextval('author_id_seq'), '" + author.getName() + "')");

            System.out.println("Author saved successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void delete(Author author) {

    }

    @Override
    public Author findById(String id) {


        return null;
    }
}
