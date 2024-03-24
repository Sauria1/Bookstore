package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.BookRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void SaveBook() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setIsbn("ISBN");
        book.setPublicationYear(2024);
        book.setPrice(10.0);
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();
    }

    @Test
    void DeleteBook() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setIsbn("ISBN");
        book.setPublicationYear(2024);
        book.setPrice(10.0);
        bookRepository.save(book);

        long id = book.getId();
        bookRepository.deleteById(id);
        assertThat(bookRepository.findById(id)).isEmpty();
    }

    @Test
    void FindBookById() {
        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setIsbn("ISBN");
        book.setPublicationYear(2024);
        book.setPrice(10.0);
        bookRepository.save(book);

        long id = book.getId();
        assertThat(bookRepository.findById(id)).isPresent();
    }
}
