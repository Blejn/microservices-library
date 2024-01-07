package com.library.springboot.demo.productService.service;


import com.library.springboot.demo.productService.dto.ProductBookDtoRequest;
import com.library.springboot.demo.productService.dto.ProductBookDtoResponse;
import com.library.springboot.demo.productService.dto.ProductOtherDtoRequest;
import com.library.springboot.demo.productService.mapper.BookMapper;
import com.library.springboot.demo.productService.model.Book;
import com.library.springboot.demo.productService.model.OtherProduct;
import com.library.springboot.demo.productService.repository.BookRepository;
import com.library.springboot.demo.productService.repository.OtherProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookProductServiceImpl implements BookProductService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    public BookProductServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<ProductBookDtoResponse> getAllBookProducts() {
        List<Book> bookList = this.bookRepository.findAll();

        return bookList.stream().map(bookMapper::mapToBookDto).collect(Collectors.toList());


    }

    public ProductBookDtoResponse getProductBookById(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            return bookMapper.mapToBookDto(book);

        } else {
            throw new EntityNotFoundException("Book with id " + id + " not found");

        }
    }


    @Override
    public void addBookProduct(ProductBookDtoRequest productBookDtoRequest) {
        Book book = new Book();
        book.setAuthor(productBookDtoRequest.getAuthor());
        book.setPageCount(productBookDtoRequest.getPageCount());
        book.setQuantity(productBookDtoRequest.getQuantity());
        book.setISBN(productBookDtoRequest.getISBN());
        book.setPublicationYear(productBookDtoRequest.getPublicationYear());
        book.setGenre(productBookDtoRequest.getGenre());
        book.setLanguage(productBookDtoRequest.getLanguage());
        book.setCoverImageURL(productBookDtoRequest.getCoverImageURL());
        if (productBookDtoRequest.getQuantity() > 0) {
            book.setAvailability(true);
        }
        bookRepository.save(book);
    }

    @Override
    public boolean deleteBookProduct(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            bookRepository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException();
        }

    }


    @Override
    public void updateBookProduct(Long id, ProductBookDtoRequest productBookDtoRequest) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setAuthor(productBookDtoRequest.getAuthor());
            book.setPageCount(productBookDtoRequest.getPageCount());
            book.setQuantity(productBookDtoRequest.getQuantity());
            book.setISBN(productBookDtoRequest.getISBN());
            book.setPublicationYear(productBookDtoRequest.getPublicationYear());
            book.setGenre(productBookDtoRequest.getGenre());
            book.setLanguage(productBookDtoRequest.getLanguage());
            book.setCoverImageURL(productBookDtoRequest.getCoverImageURL());
            if (productBookDtoRequest.getQuantity() > 0) {
                book.setAvailability(true);
            } else {
                book.setAvailability(false);
            }
            bookRepository.save(book);
        } else {
            throw new EntityNotFoundException("Book with id " + id + " not found");
        }


    }


}
