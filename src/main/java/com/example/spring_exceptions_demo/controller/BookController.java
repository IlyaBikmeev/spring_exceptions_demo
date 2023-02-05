package com.example.spring_exceptions_demo.controller;

import com.example.spring_exceptions_demo.error.ErrorMessage;
import com.example.spring_exceptions_demo.error.NoSuchBookException;
import com.example.spring_exceptions_demo.model.Book;
import com.example.spring_exceptions_demo.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {

    private final BookService bookService;


    @GetMapping("/{id}")
    public Book getById(@PathVariable int id) {
        return bookService.getById(id);
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handle(NoSuchBookException ex) {
        log.error(ex.getMessage(), ex.getCause());
        return new ErrorMessage(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
