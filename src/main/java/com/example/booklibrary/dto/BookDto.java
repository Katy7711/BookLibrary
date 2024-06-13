package com.example.booklibrary.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BookDto {

  @NotBlank
  private String bookName;
  @NotBlank
  private long authorId;

}
