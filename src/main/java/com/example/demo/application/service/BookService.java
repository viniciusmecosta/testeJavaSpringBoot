package com.example.demo.application.service;

import com.example.demo.domain.entity.Book;
import com.example.demo.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBook(Long id) {
        return bookRepository.findById(id);
    }
}
