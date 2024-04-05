package com.example.restdata.service;

import com.example.restdata.Models.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test
    void calculatePrice() {
        Book book=new Book(null,"Harry Potter3","Perez444",500,200.00, LocalDate.now(),true);
        BookPriceCalculator calculator=new BookPriceCalculator();
        double price=calculator.calculatePrice(book);
        System.out.println(price);
        assertTrue(price>0);

    }
}