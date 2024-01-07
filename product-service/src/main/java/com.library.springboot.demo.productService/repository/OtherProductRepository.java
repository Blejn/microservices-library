package com.library.springboot.demo.productService.repository;

import com.library.springboot.demo.productService.model.Book;
import com.library.springboot.demo.productService.model.OtherProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtherProductRepository extends JpaRepository<OtherProduct, Long> {

}
