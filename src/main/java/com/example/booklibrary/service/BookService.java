package com.example.booklibrary.service;

import com.example.booklibrary.dto.BookDto;
import com.example.booklibrary.entity.Book;
import org.springframework.data.domain.Page;

public interface BookService {

  Book createBook (BookDto book);
  Page<Book> getAllBooks (int page, int pageSize, boolean sort);

  Book getBookById(long id);

  Book updateBook(long id, BookDto bookDto);

  boolean deleteBook(long id);
}
