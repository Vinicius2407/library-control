package com.example.library.connectionDatabase;

import com.example.library.model.Author;

public interface IAuthorRepository {
    public void save(Author author);
    public void update(Author author);
    public void delete(Author author);
    public Author findById(String id);
}
