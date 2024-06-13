package com.example.booklibrary.service.impl;

import com.example.booklibrary.dto.AuthorDto;
import com.example.booklibrary.entity.Author;
import com.example.booklibrary.mapper.AuthorMapper;
import com.example.booklibrary.repository.AuthorRepository;
import com.example.booklibrary.service.AuthorService;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
  private static final Logger log = LoggerFactory.getLogger(AuthorServiceImpl.class);
  private final AuthorRepository authorRepository;
  private final AuthorMapper authorMapper;

  @Override
  public Author createAuthor(AuthorDto authorDto) {
    log.info("Was invoked method for create author");
    if (authorRepository.existsByAuthorFullName(authorDto.getAuthorFullName())) {
      log.warn("user already exists");
      throw new ValidationException(
          String.format("Автор \"%s\" уже существует!", authorDto.getAuthorFullName()));
    }
    log.info("author created");
    return authorRepository.save(authorMapper.authorDtoToEntity(authorDto));
  }
}
