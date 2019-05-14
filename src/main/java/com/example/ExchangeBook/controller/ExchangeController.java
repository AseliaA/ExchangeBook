package com.example.ExchangeBook.controller;

import com.example.ExchangeBook.model.Confirmation;
import com.example.ExchangeBook.model.Exchange;
import com.example.ExchangeBook.model.Response;
import com.example.ExchangeBook.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sprint/exchangeBook/exchange")
public class ExchangeController {
    //    Exchange startExchange(Exchange exchange);
    //    Exchange updateExchange(Exchange exchange);
    //    Exchange getExchangeById(Long id);
    //    List<Exchange> getAllExchanges();
    //    void deleteExchange(Long id);
    //    Exchange confirmExchange(Long exchangeId, Integer confirmationCode, Long confirmingUserId);
    //@Id
    //    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    private Long id;
    //    @ManyToOne
    //    @JoinColumn(name = "user_id")
    //    private User user;//Creates exchange process
    //    @ManyToOne
    //    @JoinColumn(name = "book_id")
    //    private Book book;//User above wants this book
    //    @ManyToOne
    //    @JoinColumn(name = "book_id_ex")
    //    private Book exchangeFor;//Belongs to the one who created this process
    //    private LocalDateTime timeCreated;
    //    private Boolean isCompleted;
    //    private Integer firstUserConfirmation;
    //    private Integer secondUserConfirmation;
    //    private Boolean firstUserConfirmed;
    //    private Boolean secondUserConfirmed;
    @Autowired
    private ExchangeService exchangeService;
    @GetMapping(path = "/getExchangeById/{id}")
    public Response getExchangeById(@PathVariable Long id){
        return new Response(true, "Exchange with id = " + id , exchangeService.getExchangeById(id));
    }
    @GetMapping(path = "/getAllExchanges")
    public Response getAllExchanges(){
        return new Response(true, "All exchanges ever made", exchangeService.getAllExchanges());
    }
    @PostMapping(path = "/newExchange")
    public Response startExchange(@RequestBody Exchange exchange){
        return new Response(true, "Started new Exchange",exchangeService.startExchange(exchange));
    }
    @PutMapping(path = "/updateExchange")
    public Response updateExchange(@RequestBody Exchange exchange){
        return new Response(true, "Updated Exchange", exchangeService.updateExchange(exchange));
    }
    @PutMapping(path = "/confirmExchange/{exchangeId}")
    public Response confirmExchange(@RequestBody Confirmation confirmation){
        return new Response(true, "Confirming exchange",exchangeService.confirmExchange(confirmation));
    }
    @DeleteMapping(path = "/deleteExchange/{id}")
    public Response  deleteExchange(@PathVariable Long id){
        exchangeService.deleteExchange(id);
        return new Response(true, "Deleting Exchange by id = " + id, null);
    }
}
