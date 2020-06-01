package matt.springframework.recipebook.springrecipe.services;

import lombok.extern.slf4j.Slf4j;
import matt.springframework.recipebook.springrecipe.commands.RecipeCommand;
import matt.springframework.recipebook.springrecipe.converters.RecipeCommandToRecipe;
import matt.springframework.recipebook.springrecipe.converters.RecipeToRecipeCommand;
import matt.springframework.recipebook.springrecipe.domain.Recipe;
import matt.springframework.recipebook.springrecipe.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeToRecipeCommand recipeToRecipeCommand;
    private final RecipeCommandToRecipe recipeCommandToRecipe;


    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeToRecipeCommand recipeToRecipeCommand, RecipeCommandToRecipe recipeCommandToRecipe) {
        this.recipeRepository = recipeRepository;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I'm in the service");
       Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    public Recipe findById(Long l){

        Optional<Recipe> recipeOptional =recipeRepository.findById(l);

        if(!recipeOptional.isPresent()){
            throw new RuntimeException("Recipe Not Found!");
        }

        return recipeOptional.get();

    }

    @Override
    @Transactional
    public RecipeCommand findByCommandId(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }


    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detechedRecipe= recipeCommandToRecipe.convert(command);

        Recipe savedRecipe = recipeRepository.save(detechedRecipe);
        log.debug("SavedRecipeID " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

}
