package com.bca.sharingknowledge.controller;

import com.bca.sharingknowledge.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @RequestMapping("/books")
    public String dataBuku(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }

}
