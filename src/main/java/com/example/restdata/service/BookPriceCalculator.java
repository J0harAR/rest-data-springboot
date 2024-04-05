package com.example.restdata.service;

import com.example.restdata.Models.Book;

public class BookPriceCalculator {
    public double calculatePrice(Book book){
        double price=book.getPrice();
        if(book.getPages()>300){
            price+=5;
        }
        //Envio
        price+=2.99;
        return  price;
    }


}
