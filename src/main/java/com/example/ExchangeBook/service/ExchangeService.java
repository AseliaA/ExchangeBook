package com.example.ExchangeBook.service;

import com.example.ExchangeBook.model.Exchange;

import java.util.List;

public interface ExchangeService {
    Exchange startExchange(Exchange exchange);
    Exchange updateExchange(Exchange exchange);
    Exchange getExchangeById(Long id);
    List<Exchange> getAllExchanges();
    void deleteExchange(Long id);
}
