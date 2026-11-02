package com.example.librarymanagement.service;

import com.example.librarymanagement.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    // Add a new book
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    // Get all books
    public List<Book> getAllBooks() {
        return books;
    }

    // Search book by ID
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    // Update book availability
    public Book updateAvailability(int bookId, boolean available) {
        Book book = getBookById(bookId);

        if (book != null) {
            book.setAvailable(available);
            return book;
        }

        return null;
    }

    // Delete book
    public boolean deleteBook(int bookId) {
        Book book = getBookById(bookId);

        if (book != null) {
            books.remove(book);
            return true;
        }

        return false;
    }
}