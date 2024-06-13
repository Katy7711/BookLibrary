package com.example.booklibrary.mapper;

import com.example.booklibrary.dto.AuthorDto;
import com.example.booklibrary.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)public interface AuthorMapper extends WebMapper<AuthorDto, Author> {

  AuthorDto toAuthorDto(Author entity);
  Author authorDtoToEntity (AuthorDto dto);


}
