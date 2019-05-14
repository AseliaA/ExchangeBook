package com.example.ExchangeBook.controller;

import com.example.ExchangeBook.enums.Language;
import com.example.ExchangeBook.model.Book;
import com.example.ExchangeBook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sprint/exchangeBook/Book")
//URL для класса Book
//1) Post - sprint/exchangeBook/Book/addBook
//2) Get - sprint/exchangeBook/Book/getBookById
//3) GetAll -  sprint/exchangeBook/Book/getAllBooks
//4) Delete -  sprint/exchangeBook/Book/deleteBookById
//5) DeleteAll-  sprint/exchangeBook/Book/deleteAllBooks
//6) GetBookByName -  sprint/exchangeBook/Book/getBookByName
//7) GetAllBooksByUserId-  sprint/exchangeBook/Book/getAllBooksByUserId
//    List<Book> getBooksByLanguage(Language language);
//    List<Book> getBooksByPeriod(int year1, int year2);
//    List<Book> getBooksByAuthor(String author);
//    List<Book> getBooksByYear(int year);

public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(path = "/addBook")
    public Book addBook(Book book){
        return bookService.addBook(book);
    }
    @GetMapping(path = "/getBookById/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
    @GetMapping(path = "/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @DeleteMapping(path = "/deleteBooksById/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
    @DeleteMapping(path = "/deleteAllBooks")
    public void deleteAllBooks(){
        bookService.deleteAllBooks();
    }
    @GetMapping(path = "/getAllBooksByUserId/{userId}")
    public List<Book> getAllBooksByUserId(@PathVariable Long userId){
        return bookService.getBooksByUserId(userId);
    }
    @GetMapping(path = "/getBookByName/{title}")
    public List<Book> getBookByName(@PathVariable String title){
        return bookService.getBooksByTitle(title);
    }
    @GetMapping(path = "/getBooksByLanguage/{languageId}")
    public List<Book> getBookByLanguage(@PathVariable int languageId){
        switch (languageId){
            case (1): return bookService.getBooksByLanguage(Language.ENGLISH);
            case (2): return bookService.getBooksByLanguage(Language.RUSSIAN);
            case (3): return bookService.getBooksByLanguage(Language.KYRGYZ);
            case (4): return bookService.getBooksByLanguage(Language.ARABIC);
            case (5): return bookService.getBooksByLanguage(Language.FRENCH);
            case (6): return bookService.getBooksByLanguage(Language.TURKISH);
            case (7): return bookService.getBooksByLanguage(Language.CHINESE);
            case (8): return bookService.getBooksByLanguage(Language.JAPANESE);
            case (9): return bookService.getBooksByLanguage(Language.DEUTCH);
            default: return null;
        }
    }
    @GetMapping(path = "/getBooksByPeriod/{from}/{to}")
    public List<Book> getBooksByPeriod(@PathVariable int from, @PathVariable int to){
        return bookService.getBooksByPeriod(from, to);
    }
    @GetMapping(path = "/getBooksByAuthor/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author){
        return bookService.getBooksByAuthor(author);
    }
    @GetMapping(path = "/getBooksByYear/{year}")
    public List<Book> getBooksByYear(@PathVariable int year){
        return bookService.getBooksByYear(year);
    }
}