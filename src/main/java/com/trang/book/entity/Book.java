package com.trang.book.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String authors;

    private Double avgRating;

    @Column(nullable = false)
    private Integer nReview = 0;

    @Column(nullable = false)
    private Double price;

    private String description;

    @Column(nullable = false)
    private String publisher;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Integer pageCount;

    @Column(nullable = false)
    private Date publishDate;

    @Column(nullable = false)
    private String language;

    private String image;

    private Integer status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}