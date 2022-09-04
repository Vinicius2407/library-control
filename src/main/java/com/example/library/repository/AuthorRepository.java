package com.example.library.repository;

import com.example.library.connectionDatabase.ConnectionFactory;
import com.example.library.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository implements IAuthorRepository {

    private final Connection conn;

    public AuthorRepository() {
        conn = ConnectionFactory.getConnection();
    }

    public Author save(Author author) {
        PreparedStatement statement = null;

        try {
            String sql = "INSERT INTO author (name) VALUES(?)";
            statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, author.getName());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet ids = statement.getGeneratedKeys();

                while (ids.next()) {
                    author.setId(ids.getString(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }

    public Author update(Author author) {
        PreparedStatement statement = null;

        try {
            String sql = "UPDATE author SET name = ? WHERE id = ?";
            statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, author.getName());
            statement.setString(2, author.getId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet ids = statement.getGeneratedKeys();

                while (ids.next()) {
                    author.setId(ids.getString(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }

    public String delete(String id) {
        PreparedStatement statement =  null;

        try {
            String sql = "DELETE FROM author WHERE id = ?";
            statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet ids = statement.getGeneratedKeys();

                while (ids.next()) {
                    id = ids.getString(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public List<Author> findAll() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Author> authors = new ArrayList<>();

        try {
            String sql = "SELECT * FROM author";
            statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getString("id"));
                author.setName(resultSet.getString("name"));
                authors.add(author);
            }

        } catch (SQLException e) {
           throw new RuntimeException(e.getMessage());
    } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return authors;
    }

    public Author findById(String id) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Author author = new Author();

        try {
            String sql = "SELECT * FROM author WHERE id = ?";
            statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, id);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                author.setId(resultSet.getString("id"));
                author.setName(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert statement != null;
                statement.close();
                assert resultSet != null;
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return author;
    }
}