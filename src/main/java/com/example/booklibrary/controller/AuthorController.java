package com.example.booklibrary.controller;

import com.example.booklibrary.dto.AuthorDto;
import com.example.booklibrary.entity.Author;
import com.example.booklibrary.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthorController {

  private static final Logger log = LoggerFactory.getLogger(AuthorController.class);
  private final AuthorService authorService;
  @PostMapping("/author/create")
  public ResponseEntity<Author> createAuthor(@RequestBody AuthorDto authorDto) {
    log.info("Request for add author");
    return ResponseEntity.ok(authorService.createAuthor(authorDto));
  }

}
