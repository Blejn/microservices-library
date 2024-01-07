package com.library.springboot.demo.productService.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProductBookDtoResponse {
    private Long id;
    private String description;
    private Boolean availability;
    private int quantity;
    private String author;
    private Integer pageCount;
    private String ISBN;
    private Integer publicationYear;
    private String genre;
    private String language;
    private String coverImageURL;
}
