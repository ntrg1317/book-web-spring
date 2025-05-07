package com.trang.book.controller;

import com.trang.book.dto.BookDto;
import com.trang.book.entity.Book;
import com.trang.book.service.BookService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @GetMapping("/admin/book/create")
    public String showCreateForm(Model model) {
        BookDto bookDto = new BookDto();
        model.addAttribute("book", bookDto);
        return "admin/book/create";
    }

    @PostMapping("admin/book/create")
    public String create(@ModelAttribute("user") @Valid BookDto book,
                         BindingResult result,
                         @RequestParam(value = "image", required = false) MultipartFile image,
                         RedirectAttributes redirectAttributes,
                         Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", book);
            return "admin/book/create";
        }
        try {

            book.setStatus(1);

            Book savedBook = bookService.saveBook(book);

            redirectAttributes.addFlashAttribute("successMessage",
                    "Book '" + savedBook.getTitle() + "' has been created successfully");

            return "redirect:/admin/book";

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "Error saving book: " + e.getMessage());

            return "admin/book/create";
        }
    }
}
