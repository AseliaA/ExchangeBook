package com.example.ExchangeBook.service;

import com.example.ExchangeBook.enums.Language;
import com.example.ExchangeBook.model.Book;

import java.util.List;

public interface BookService {
    //URL для класса Book
    //1) Post - sprint/exchangeBook/Book/addBook
    //2) Get - sprint/exchangeBook/Book/getBookById
    //3) GetAll - sprint/exchangeBook/Book/getAllBooks
    //4) Delete - sprint/exchangeBook/Book/deleteBookById
    //5) DeleteAll- sprint/exchangeBook/Book/deleteAllBooks
    //6) GetBookByName - sprint/exchangeBook/Book/getBookByName
    //7) GetAllBooksByUserId- sprint/exchangeBook/Book/getAllBooksByUserId
    Book addBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    void deleteBook(Long id);
    void deleteAllBooks();
    List<Book> getBooksByTitle(String title);
    List<Book> getBooksByUserId(Long id);
    List<Book> getBooksByLanguage(Language language);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksByYear(int year);
    List<Book> getBooksByPeriod(int year1, int year2);

}

