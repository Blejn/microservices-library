package com.library.springboot.demo.productService.service;

import com.library.springboot.demo.productService.dto.ProductOtherDtoRequest;

public interface OtherProductService {
    public ProductOtherDtoRequest getAllOtherProducts();

    void addOtherProduct(ProductOtherDtoRequest productOtherDtoRequest);

    boolean deleteOtherProduct(Long id);

    void updateOtherProduct(Long id, ProductOtherDtoRequest productOtherDtoRequest);
}
