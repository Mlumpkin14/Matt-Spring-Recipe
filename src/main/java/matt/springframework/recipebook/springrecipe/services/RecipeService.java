package matt.springframework.recipebook.springrecipe.services;

import matt.springframework.recipebook.springrecipe.commands.RecipeCommand;
import matt.springframework.recipebook.springrecipe.domain.Recipe;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;


public interface RecipeService {
    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findByCommandId(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);


}
