package matt.springframework.recipebook.springrecipe.services;

import matt.springframework.recipebook.springrecipe.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();
}
