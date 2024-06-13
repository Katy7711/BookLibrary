package com.example.booklibrary.service.impl;


import com.example.booklibrary.dto.BookDto;
import com.example.booklibrary.entity.Author;
import com.example.booklibrary.entity.Book;
import com.example.booklibrary.mapper.BookMapper;
import com.example.booklibrary.repository.AuthorRepository;
import com.example.booklibrary.repository.BookRepository;
import com.example.booklibrary.service.BookService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

  private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
  private final BookRepository bookRepository;
  private final AuthorRepository authorRepository;
  private final BookMapper bookMapper;

  @Override
  public Book createBook(BookDto book) {
    log.info("Was invoked method for create book");
    Author author = authorRepository.findById(book.getAuthorId());
    if (bookRepository.existsByBookName(book.getBookName()) && bookRepository.existsByAuthor(
        author)) {
      log.warn("user already exists");
      throw new ValidationException(
          String.format("Книга \"%s\" уже существует!", book.getBookName()));
    }
    Book book1 = bookMapper.bookDtoToEntity(book);
    book1.setBookName(book.getBookName());
    book1.setAuthor(author);
    log.info("book created");
    return bookRepository.save(book1);
  }

  @Override
  public Page<Book> getAllBooks(int page, int pageSize, boolean sort) {
    Pageable pageable = !sort
        ? PageRequest.of(page, pageSize)
        : PageRequest.of(page, pageSize, Sort.by("bookName").ascending());
    return bookRepository.findAll(pageable);
  }

  @Override
  public Book getBookById(long id) {
    log.info("Was invoked method for get book by id");
    return bookRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Книга с id " + id + " не найдена!"));
  }

  @Override
  public Book updateBook(long id, BookDto bookDto) {
    log.info("Was invoked method for update book");
    Author author = authorRepository.findById(bookDto.getAuthorId());
    Book book = bookRepository.findById(id).orElseThrow();
    book.setBookName(bookDto.getBookName());
    book.setAuthor(author);
    bookRepository.save(book);
    return book;
  }

  @Override
  public boolean deleteBook(long id) {
    log.info("Was invoked method for delete book with id {}", id);
    Book book = bookRepository.findById(id).orElseThrow();
    if (bookRepository.existsById(id)) {
      bookRepository.delete(book);
      log.info("book deleted");
      return true;
    }
    return false;
  }
}

