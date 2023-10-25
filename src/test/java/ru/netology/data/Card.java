package ru.netology.data;

import lombok.Getter;

public class Card {

    @Getter
    private String year;
    @Getter
    private String cardHolder;
    @Getter
    private String cvv;
    @Getter
    private String cardNumber;
    @Getter
    private String month;


    public Card(String cardNumber, String month, String year, String cardHolder, String cvv) {
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
    }

    public static class cardNumber {
        public cardNumber() {

        }

    }

}