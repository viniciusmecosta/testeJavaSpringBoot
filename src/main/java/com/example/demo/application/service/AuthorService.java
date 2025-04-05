package com.example.demo.application.service;

import com.example.demo.domain.entity.Author;
import com.example.demo.domain.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getAuthor(Long id) {
        return authorRepository.findById(id);
    }
}
