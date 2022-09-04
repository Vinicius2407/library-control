package com.example.library.repository;

import com.example.library.model.Author;

import java.util.List;

public interface IAuthorRepository {
    public Author save(Author author);
    public Author update(Author author);
    public String delete(String id);
    public Author findById(String id);
    public List<Author> findAll();
}
