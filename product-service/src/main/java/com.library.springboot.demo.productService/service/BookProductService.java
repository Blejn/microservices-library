package com.library.springboot.demo.productService.service;


import com.library.springboot.demo.productService.dto.ProductBookDtoRequest;
import com.library.springboot.demo.productService.dto.ProductBookDtoResponse;
import com.library.springboot.demo.productService.dto.ProductOtherDtoRequest;

import java.util.List;

public interface BookProductService {
    public List<ProductBookDtoResponse> getAllBookProducts();


    void addBookProduct(ProductBookDtoRequest productBookDtoRequest);

    boolean deleteBookProduct(Long id);


    void updateBookProduct(Long id, ProductBookDtoRequest productBookDtoRequest);

}
