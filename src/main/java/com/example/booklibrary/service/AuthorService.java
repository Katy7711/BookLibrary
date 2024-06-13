package com.example.booklibrary.service;

import com.example.booklibrary.dto.AuthorDto;
import com.example.booklibrary.entity.Author;
public interface AuthorService {

  Author createAuthor (AuthorDto authorDto);


}
