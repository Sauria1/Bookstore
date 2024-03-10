package hh.sof03.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import hh.sof03.bookstore.domain.BookRepository;
import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;
import hh.sof03.bookstore.domain.Book;
import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BookRepository repository, CategoryRepository categoryRepository, BCryptPasswordEncoder passwordEncoder, UserRepository userRepository) {
        return (args) -> {
            Category sciFi = new Category();
            sciFi.setName("Sci-Fi");
            categoryRepository.save(sciFi);

            Category comic = new Category();
            comic.setName("Comic");
            categoryRepository.save(comic);

            Book book1 = new Book(1, "Title 1", "Author 1", "ISBN 1", 2024, 25.0);
            book1.setCategory(sciFi);
            Book book2 = new Book(2, "Title 2", "Author 2", "ISBN 2", 2024, 25.0);
            book2.setCategory(comic);
            Book book3 = new Book(3, "Title 3", "Author 3", "ISBN 3", 2024, 25.0);
            book3.setCategory(comic);

            repository.save(book1);
            repository.save(book2);
            repository.save(book3);

            User user1 = new User(null, "user", passwordEncoder.encode("user"), null, "USER");
            User user2 = new User(null, "admin", passwordEncoder.encode("admin"), null, "ADMIN");
            userRepository.save(user1);
            userRepository.save(user2);
        };
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
