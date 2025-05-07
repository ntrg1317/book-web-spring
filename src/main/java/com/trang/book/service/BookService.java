package com.trang.book.service;

import com.trang.book.dto.BookDto;
import com.trang.book.entity.Book;

import java.util.List;

public interface BookService {
    BookDto findBookById(Long id);

    List<BookDto> findAllBooks();

    void updateBookStatus(Long id, Integer status);
}
