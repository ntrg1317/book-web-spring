package com.trang.book.controller;

import com.trang.book.dto.BookDto;
import com.trang.book.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/admin/book")
    public String index(Model model) {
        List<BookDto> bookDtoList = bookService.findAllBooks();
        model.addAttribute("books", bookDtoList);
        return "admin/book/index";
    }
}
