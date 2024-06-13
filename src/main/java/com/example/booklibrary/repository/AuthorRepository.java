package com.example.booklibrary.repository;

import com.example.booklibrary.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author, Long> {

  Author findById(long id);
  boolean existsByAuthorFullName(String author);



}
