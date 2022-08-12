package com.example.library.connectionDatabase;

import com.example.library.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AuthorRepository implements IAuthorRepository {

    Connection conn = ConnectionFactory.getConnection();

    public static void main(String[] args) {
        Author author = new Author();
        AuthorRepository authorRepository = new AuthorRepository();

//        author.setName("Bruno Silveira Gostoso");
//
//        authorRepository.save(author);

//        List<String> authors = authorRepository.findAll();
//        for (String authorName : authors) {
//            System.out.println(authorName);
//        }

//        String nameAuthor = authorRepository.findById("5");
//        System.out.println(nameAuthor);

//        authorRepository.update(author);
        authorRepository.delete("4");
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
    public void delete(String id) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM author WHERE id = " + id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.getRowId(id) != null) {
                System.out.println("Author deleted successfully");
            } else {
                System.out.println("Author not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String findById(String id) {

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT name FROM author WHERE id = " + id);
            ResultSet resultSet = stmt.executeQuery();

            return resultSet.next() ? resultSet.getString("name") : null;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<String> findAll() {
        List<String> authors = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT id ,name FROM author");
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                authors.add(resultSet.getString("id") + " " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

}
