package com.library.springboot.demo.productService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "author")
    private String author;

    @Column(name = "page_count")
    private int pageCount;

    @Column(name = "ISBN", unique = true)
    private String ISBN;

    @Column(name = "publication_year")
    private int publicationYear;

    @Column(name = "genre")
    private String genre;

    @Column(name = "language")
    private String language;

    @Column(name = "cover_image_url")
    private String coverImageURL;

    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private Boolean availability;

    @Column(name = "quantity")
    private int quantity;
}
