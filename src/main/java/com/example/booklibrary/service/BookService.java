package com.example.booklibrary.service;

import com.example.booklibrary.dto.BookDto;
import com.example.booklibrary.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

  Book createBook (BookDto book);
  Page<Book> getAllBooks (Pageable pageable);

  Book getBookById(long id);

  Book updateBook(long id, BookDto bookDto);

  boolean deleteBook(long id);
}
