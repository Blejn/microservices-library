package com.library.springboot.demo.productService.mapper;

import com.library.springboot.demo.productService.dto.ProductBookDtoResponse;
import com.library.springboot.demo.productService.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class BookMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductBookDtoResponse mapToBookDto(Book book) {
        return modelMapper.map(book, ProductBookDtoResponse.class);
    }

    public Book mapToBookEntity(ProductBookDtoResponse productBookDtoResponse) {
        return modelMapper.map(productBookDtoResponse, Book.class);
    }
}
