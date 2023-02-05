package com.example.spring_exceptions_demo.service;

import com.example.spring_exceptions_demo.error.NoSuchBookException;
import com.example.spring_exceptions_demo.model.Book;
import com.example.spring_exceptions_demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book getById(int id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new NoSuchBookException("No such book!")
        );
    }
}
