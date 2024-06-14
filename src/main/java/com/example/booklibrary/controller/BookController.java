package com.example.booklibrary.controller;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

import com.example.booklibrary.dto.BookDto;
import com.example.booklibrary.dto.View;
import com.example.booklibrary.entity.Book;
import com.example.booklibrary.service.impl.BookServiceImpl;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class BookController {
  private static final Logger log = LoggerFactory.getLogger(BookController.class);
  private final BookServiceImpl bookService;
  @PostMapping("/book/create")
  @JsonView(View.Book.class)
  public ResponseEntity<Book> createOrder(@RequestBody BookDto book) {
    log.info("Request for add book");
    return ResponseEntity.ok(bookService.createBook(book));
  }
  @GetMapping("/books")
  public ResponseEntity<Page<Book>> getAllBooks (Pageable pageable) {
    log.info("Request for get all books");
    return ResponseEntity.ok(bookService.getAllBooks(pageable));
  }
  @GetMapping("book/{id}")
  @JsonView(View.Book.class)
  public ResponseEntity<Book> getBookById(@PathVariable long id) {
    log.info("Request for get book by id");
    return ResponseEntity.ok(bookService.getBookById(id));
  }
  @PatchMapping("/update/book")
  @JsonView(View.Book.class)
  public ResponseEntity<Book> updateBook(long id, @Valid @RequestBody BookDto bookDto) {
    log.info("Request for update information of book");
    return ResponseEntity.ok(bookService.updateBook(id, bookDto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> removeBook(@PathVariable long id) {
    log.info("Request for delete book by id");
    if (bookService.deleteBook(id)) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpServletResponse.SC_NOT_FOUND).build();
  }
}
