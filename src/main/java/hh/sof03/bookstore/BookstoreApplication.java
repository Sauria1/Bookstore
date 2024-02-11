package hh.sof03.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Book;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book(1, "Title 1", "Author 1", "ISBN 1", 2024, 25.0);
			Book book2 = new Book(2, "Title 2", "Author 2", "ISBN 2", 2024, 25.0);
			Book book3 = new Book(3, "Title 3", "Author 3", "ISBN 3", 2024, 25.0);

			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
		};
	}
}
