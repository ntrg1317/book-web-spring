package com.trang.book.controller;

import com.trang.book.dto.BookDto;
import com.trang.book.entity.Book;
import com.trang.book.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/admin/book/{id}")
    public String detail(@PathVariable Long id, Model model) {
        BookDto book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "admin/book/detail";
    }

    @PostMapping("/admin/book/status/{id}/{status}")
    public String updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        Integer newStatus = (status == 1) ? 0 : 1;
        bookService.updateBookStatus(id, newStatus);
        return "redirect:/admin/book/" + id;
    }
}
