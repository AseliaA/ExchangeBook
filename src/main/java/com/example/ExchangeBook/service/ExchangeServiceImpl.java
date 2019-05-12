package com.example.ExchangeBook.service;

import com.example.ExchangeBook.enums.State;
import com.example.ExchangeBook.enums.Status;
import com.example.ExchangeBook.model.Exchange;
import com.example.ExchangeBook.repository.BookRepository;
import com.example.ExchangeBook.repository.ExchangeRepository;
import com.example.ExchangeBook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ExchangeServiceImpl implements ExchangeService {
    Random rand = new Random();
    @Autowired
    private ExchangeRepository exchangeRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Exchange startExchange(Exchange exchange) {
        if(exchange.getBook().getStatus().equals(Status.АVAILABLE)) {
            bookRepository.findById(exchange.getBook().getId()).get().setStatus(Status.BOOKED);
            bookRepository.findById(exchange.getExchangeFor().getId()).get().setStatus(Status.BOOKED);
            exchangeRepository.save(exchange);
            //(max-min) + 1) + min;
            exchange.setFirstUserConfirmation(rand.nextInt((999999 - 100000) + 1) + 100000);
            exchange.setSecondUserConfirmation(rand.nextInt((999999 - 100000) + 1) + 100000);
            System.out.println("------- FirstUserConfirmationCode -------\n----> '" + exchange.getFirstUserConfirmation() + "'\n");
            System.out.println("------- SecondUserConfirmationCode -------\n----> '" + exchange.getSecondUserConfirmation() + "'\n");
            exchange.setFirstUserConfirmed(false);
            exchange.setSecondUserConfirmed(false);
            return exchange;
        }
        else{
            return null;
        }
    }

    @Override
    public Exchange confirmExchange(Long exchangeId, Integer confirmationCode, Long confirmingUserId) {
        Exchange exchange = exchangeRepository.findById(exchangeId).get();
        if(userRepository.findById(confirmingUserId).equals(exchange.getUser())){
            if(exchangeRepository.findById(exchangeId).get().getFirstUserConfirmation().equals(confirmationCode)){
               exchange.setFirstUserConfirmed(true);
            }
        }
        if(userRepository.findById(confirmingUserId).get().equals(exchange.getBook().getUser())){
            if(exchangeRepository.findById(exchangeId).get().getSecondUserConfirmation().equals(confirmationCode)){
                exchange.setSecondUserConfirmed(true);
            }
        }
        updateExchange(exchange);
        return exchangeRepository.findById(exchangeId).get();
    }

    @Override
    public Exchange updateExchange(Exchange exchange) {
        if(exchange.getFirstUserConfirmed() && exchange.getSecondUserConfirmed()){
            exchange.setCompleted(true);
        }
        if(exchange.getCompleted()){
            bookRepository.findById(exchange.getBook().getId()).get().setStatus(Status.EXCHANGED);
            bookRepository.findById(exchange.getExchangeFor().getId()).get().setStatus(Status.EXCHANGED);
        }
        exchangeRepository.save(exchange);
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
