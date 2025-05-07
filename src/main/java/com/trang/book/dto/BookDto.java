package com.trang.book.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;

    @NotNull(message = "ISDB code should not be empty")
    private String isbn;

    @NotNull(message = "Title of book should not be empty")
    private String title;

    private String authors;

    private Double avgRating;

    private Integer nReview = 0;

    private Double price;

    private String description;

    private String publisher;

    private String category;

    private Integer pageCount;

    private Date publishDate;

    private String language;

    private String image;

    private Integer status;
}
