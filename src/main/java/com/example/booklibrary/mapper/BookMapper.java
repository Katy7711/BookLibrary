package com.example.booklibrary.mapper;

import com.example.booklibrary.dto.BookDto;
import com.example.booklibrary.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper  (
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BookMapper extends WebMapper<BookDto, Book> {

    BookDto toBookDto(Book entity);
    Book bookDtoToEntity(BookDto dto);

}