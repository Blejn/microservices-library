package com.library.springboot.demo.productService.service;

import com.library.springboot.demo.productService.dto.ProductOtherDtoRequest;
import org.springframework.stereotype.Service;

@Service
public class OtherProductServiceImpl implements  OtherProductService {


    @Override
    public ProductOtherDtoRequest getAllOtherProducts() {
        return null;
    }

    @Override
    public void addOtherProduct(ProductOtherDtoRequest productOtherDtoRequest) {

    }

    @Override
    public boolean deleteOtherProduct(Long id) {
        return false;
    }

    @Override
    public void updateOtherProduct(Long id, ProductOtherDtoRequest productOtherDtoRequest) {

    }
}
