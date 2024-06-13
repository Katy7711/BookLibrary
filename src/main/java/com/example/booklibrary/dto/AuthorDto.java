package com.example.booklibrary.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorDto {

  @NotBlank
  private String authorFullName;

}
