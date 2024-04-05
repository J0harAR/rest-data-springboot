package com.example.restdata.Controllers;

import com.example.restdata.Models.Book;
import com.example.restdata.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Esto retorna todos los libros
    @GetMapping("/api/books")
    public List <Book> allBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/api/books/{id}")
    public ResponseEntity<Book> findBook(@PathVariable Long id){
        Optional<Book>bookOpt=bookRepository.findById(id);
        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    //Metodo create
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book){
       return bookRepository.save(book);
    }
    //Metodo update
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){

        if(book.getId()!=null){
           Book result=bookRepository.save(book);
           return ResponseEntity.ok(result);

        }
        if(!bookRepository.existsById(book.getId())){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.badRequest().build();

    }
    //Metodo Delete por ID
    @DeleteMapping("api/books/{id}")
    public  ResponseEntity<Book> delete(@PathVariable Long id){
        if(!bookRepository.existsById(id)){
          return ResponseEntity.notFound().build();
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    //Metoido delete all
    @DeleteMapping("api/books")
    public ResponseEntity<Book>deleteAll(){
       bookRepository.deleteAll();
       return ResponseEntity.noContent().build();
    }


}
