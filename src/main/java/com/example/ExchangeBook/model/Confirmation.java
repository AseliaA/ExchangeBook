package com.example.ExchangeBook.model;

public class Confirmation {
    Long exchangeId;
    Long confirmtingUserId;
    int ConfirmationCode;

    public Confirmation(Long exchangeId, Long confirmtingUserId, int confirmationCode) {
        this.exchangeId = exchangeId;
        this.confirmtingUserId = confirmtingUserId;
        ConfirmationCode = confirmationCode;
    }

    public Long getExchangeId() {
        return exchangeId;
    }

    public void setExchangeId(Long exchangeId) {
        this.exchangeId = exchangeId;
    }

    public Long getConfirmtingUserId() {
        return confirmtingUserId;
    }

    public void setConfirmtingUserId(Long confirmtingUserId) {
        this.confirmtingUserId = confirmtingUserId;
    }

    public int getConfirmationCode() {
        return ConfirmationCode;
    }

    public void setConfirmationCode(int confirmationCode) {
        ConfirmationCode = confirmationCode;
    }
}
