package matt.springframework.recipebook.springrecipe.repositories;

import matt.springframework.recipebook.springrecipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
