package com.library.springboot.demo.productService.config;

import com.library.springboot.demo.productService.dto.ProductBookDtoResponse;
import com.library.springboot.demo.productService.mapper.BookMapper;
import com.library.springboot.demo.productService.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
