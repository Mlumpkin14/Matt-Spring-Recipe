package matt.springframework.recipebook.springrecipe.repositories;

import matt.springframework.recipebook.springrecipe.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
