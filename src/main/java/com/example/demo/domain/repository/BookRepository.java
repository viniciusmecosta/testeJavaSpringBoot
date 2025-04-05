package com.example.demo.domain.repository;

import com.example.demo.domain.entity.Book;

public interface BookRepository {
    Book save(Book book);
    Book findById(Long id);
}
