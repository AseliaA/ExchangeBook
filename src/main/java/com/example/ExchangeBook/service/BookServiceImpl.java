package com.example.ExchangeBook.service;

import com.example.ExchangeBook.enums.Language;
import com.example.ExchangeBook.enums.State;
import com.example.ExchangeBook.model.Book;
import com.example.ExchangeBook.model.Exchange;
import com.example.ExchangeBook.model.User;
import com.example.ExchangeBook.repository.BookRepository;
import com.example.ExchangeBook.repository.ExchangeRepository;
import com.example.ExchangeBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ExchangeRepository exchangeRepository;
    @Autowired
    private UserRepository userRepository;

    //URL для класса Book
    //1) Post - sprint/exchangeBook/Book/addBook
    //2) Get - sprint/exchangeBook/Book/getBookById
    //3) GetAll - sprint/exchangeBook/Book/getAllBooks
    //4) Delete - sprint/exchangeBook/Book/deleteBookById
    //5) DeleteAll- sprint/exchangeBook/Book/deleteAllBooks
    //6) GetBookByName - sprint/exchangeBook/Book/getBookByName
    //7) GetAllBooksByUserId- sprint/exchangeBook/Book/getAllBooksByUserId

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        if(title != null) {
            return bookRepository.findAll().stream().filter(x -> x.getTitle().contains(title)).collect(Collectors.toList());
        }
        else return null;
    }

    @Override
    public List<Book> getBooksByUserId(Long id) {
        return bookRepository.findAll().stream().filter(x->x.getUser().equals(userRepository.findById(id))).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByLanguage(Language language) {
        return bookRepository.findAll().stream().filter(x->x.getLanguage().equals(language)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return bookRepository.findAll().stream().filter(x->x.getAuthor().contains(author)).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByYear(int year) {
        return bookRepository.findAll().stream().filter(x->x.getYear()==year).collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByPeriod(int year1, int year2) {
        return bookRepository.findAll().stream().filter(x->x.getYear()>=year1 && x.getYear()<=year2).collect(Collectors.toList());
    }
}
