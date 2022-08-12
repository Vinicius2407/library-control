package com.example.library.connectionDatabase;

import com.example.library.model.Author;

import java.util.List;

public interface IAuthorRepository {
    public void save(Author author);
    public void update(Author author);
    public void delete(String id);
    public String findById(String id);
    public List<String> findAll();
}
