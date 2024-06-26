package com.example.booklibrary.repository;

import com.example.booklibrary.entity.Author;
import com.example.booklibrary.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {

  boolean existsByBookName(String name);
  boolean existsByAuthor(Author author);




}
