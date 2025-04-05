package com.example.demo.infra.repository.persistence;

import com.example.demo.application.port.out.BookRepository;
import com.example.demo.domain.Book;
import com.example.demo.infra.repository.persistence.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaBookRepository implements BookRepository {

    private final SpringDataBookRepository repository;

    @Autowired
    public JpaBookRepository(SpringDataBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(new AuthorEntity(book.getAuthor().getId()));
        return repository.save(bookEntity).toDomain();
    }

    @Override
    public Book findById(Long id) {
        return repository.findById(id).map(BookEntity::toDomain).orElse(null);
    }
}
