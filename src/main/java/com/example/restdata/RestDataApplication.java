package com.example.restdata;

import com.example.restdata.Models.Book;
import com.example.restdata.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class RestDataApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(RestDataApplication.class, args);
		BookRepository repository=context.getBean(BookRepository.class);

		Book book=new Book(null,"Harry Potter","Perez",200,260.0, LocalDate.now(),true);
		Book book2=new Book(null,"Harry Potter2","Perez2",200,260.0, LocalDate.now(),false);


		repository.save(book);
		repository.save(book2);

		System.out.println(repository.findAll());
	}

}
