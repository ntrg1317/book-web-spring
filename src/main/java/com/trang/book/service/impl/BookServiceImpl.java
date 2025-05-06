package com.trang.book.service.impl;

import com.trang.book.dto.BookDto;
import com.trang.book.entity.Book;
import com.trang.book.repository.BookRepository;
import com.trang.book.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findBookById(id);
    }

    @Override
    public List<BookDto> findAllBooks() {
        List<Book> books = bookRepository.findAll();

        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book : books) {
            BookDto bookDto = mapBookToBookDto(book);
            bookDtoList.add(bookDto);
        }
        return bookDtoList;
    }

    private BookDto mapBookToBookDto(Book book) {
        return BookDto.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .authors(book.getAuthors())
                .avgRating(book.getAvgRating())
                .nReview(book.getNReview())
                .price(book.getPrice())
                .description(book.getDescription())
                .publisher(book.getPublisher())
                .category(book.getCategory())
                .pageCount(book.getPageCount())
                .publishDate(book.getPublishDate())
                .language(book.getLanguage())
                .image(book.getImage())
                .status(book.getStatus())
                .build();
    }
}
