package hh.sof03.bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@CrossOrigin
@RestController
public class BookRestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookbyId(@PathVariable Long id) {
        return bookRepository.findById(id);
    }
}
