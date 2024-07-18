package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Author;

public interface AuthorRepository {
    Author save(Author author);
    Author findById(Long id);
}
