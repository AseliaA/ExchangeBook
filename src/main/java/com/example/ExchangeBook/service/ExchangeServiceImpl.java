package com.example.ExchangeBook.service;

import com.example.ExchangeBook.enums.State;
import com.example.ExchangeBook.model.Exchange;
import com.example.ExchangeBook.repository.BookRepository;
import com.example.ExchangeBook.repository.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExchangeServiceImpl implements ExchangeService {
    @Autowired
    private ExchangeRepository exchangeRepository;
    @Autowired
    private BookRepository bookRepository;
    @Override
    public Exchange startExchange(Exchange exchange) {
        bookRepository.findById(exchange.getBook().getId()).get().setStatus(Status.);
        bookRepository.findById(exchange.getExchangeFor().getId()).get().setStatus(Status.);
        exchangeRepository.save(exchange);
        return exchange;
    }

    @Override
    public Exchange updateExchange(Exchange exchange) {
        if(exchange.getCompleted()){
            bookRepository.findById(exchange.getBook().getId()).get().setStatus(Status.);
            bookRepository.findById(exchange.getExchangeFor().getId()).get().setStatus(Status.);
        }
        else {
            exchangeRepository.save(exchange);
        }
        return exchange;
    }

    @Override
    public Exchange getExchangeById(Long id) {
        return exchangeRepository.findById(id).get();
    }

    @Override
    public List<Exchange> getAllExchanges() {
        return exchangeRepository.findAll();
    }

    @Override
    public void deleteExchange(Long id) {
        exchangeRepository.deleteById(id);
    }
}
