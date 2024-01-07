package com.library.springboot.demo.productService.controller;

import com.library.springboot.demo.productService.dto.ProductBookDtoRequest;
import com.library.springboot.demo.productService.dto.ProductBookDtoResponse;
import com.library.springboot.demo.productService.service.BookProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class BookController {
    private final BookProductServiceImpl bookProductService;

    @Autowired
    public BookController(BookProductServiceImpl bookProductService) {
        this.bookProductService = bookProductService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductBookDtoResponse>> getAllBooks() {
        return ResponseEntity.ok(bookProductService.getAllBookProducts());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBookProduct(@RequestBody ProductBookDtoRequest productBookDtoRequest) {
        bookProductService.addBookProduct(productBookDtoRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteBookProduct(@PathVariable("id") Long id) {
        bookProductService.deleteBookProduct(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBookProduct(@PathVariable("id") Long id, @RequestBody ProductBookDtoRequest productBookDtoRequest) {
        bookProductService.updateBookProduct(id, productBookDtoRequest);
        return ResponseEntity.ok().build();
    }


}
