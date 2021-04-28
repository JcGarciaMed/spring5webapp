package com.greymatter.spring5webapp.controllers;

import com.greymatter.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        System.out.println("paso por aqui");
        model.addAttribute("books", bookRepository.findAll());
        model.addAttribute("titulo", "Spring Framework");

        System.out.println("paso por aqui 2");
        return "books/list";
    }

}
