package hh.sof03.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof03.bookstore.domain.Category;
import hh.sof03.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void SaveCategory() {
        Category category = new Category(null,"Action");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    void DeleteCategory() {
        Category category = new Category(null,"Action");
        categoryRepository.save(category);
        categoryRepository.delete(category);
        assertThat(categoryRepository.findById(category.getCategoryId())).isEmpty();
    }

    @Test
    void FindCategoryById() {
        Category category = new Category(null,"Action");
        categoryRepository.save(category);
        Optional<Category> foundCategory = categoryRepository.findById(category.getCategoryId());
        assertThat(foundCategory).isPresent();
        assertThat(foundCategory.get().getName()).isEqualTo(category.getName());
    }
}
