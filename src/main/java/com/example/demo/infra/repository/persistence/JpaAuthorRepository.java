package com.example.demo.infra.repository.persistence;

import com.example.demo.domain.entity.Author;
import com.example.demo.domain.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpaAuthorRepository implements AuthorRepository {

    private final SpringDataAuthorRepository repository;

    @Autowired
    public JpaAuthorRepository(SpringDataAuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author save(Author author) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setName(author.getName());
        return repository.save(authorEntity).toDomain();
    }

    @Override
    public Author findById(Long id) {
        return repository.findById(id).map(AuthorEntity::toDomain).orElse(null);
    }
}
