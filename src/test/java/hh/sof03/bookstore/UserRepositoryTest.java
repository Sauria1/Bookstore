package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.domain.User;
import hh.sof03.bookstore.domain.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    void SaveUser() {
        User user = new User(null, "test","test", "test@example.com", "ROLE_TEST");
        userRepository.save(user);
        assertThat(user.getId()).isNotNull();
    }

    @Test
    void DeleteUser() {
        User user = new User(null, "test","test", "test@example.com", "ROLE_TEST");
        userRepository.save(user);

        long id = user.getId();
        userRepository.delete(user);
        assertFalse(userRepository.findById(id).isPresent());
    }

    @Test
    void FindUserById() {
        User user = new User(null, "test","test", "test@example.com", "ROLE_TEST");
        userRepository.save(user);

        long id = user.getId();
        Optional<User> foundUser = userRepository.findById(id);
        assertThat(foundUser).isPresent();
        assertThat(foundUser.get().getUsername()).isEqualTo(user.getUsername());
    }
 }