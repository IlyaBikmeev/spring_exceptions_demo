package com.example.spring_exceptions_demo.repository;

import com.example.spring_exceptions_demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
