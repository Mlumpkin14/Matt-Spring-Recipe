package matt.springframework.recipebook.springrecipe.converters;

import lombok.Synchronized;
import matt.springframework.recipebook.springrecipe.commands.CategoryCommand;
import matt.springframework.recipebook.springrecipe.commands.RecipeCommand;
import matt.springframework.recipebook.springrecipe.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandtoCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandtoCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand source) {
        if (source == null) {
            return null;
        }

        final Recipe recipe = new Recipe();
        recipe.setId(source.getId());
        recipe.setPrepTime(source.getPrepTime());
        recipe.setCookTime(source.getCookTime());
        recipe.setServings(source.getServings());
        recipe.setUrl(source.getUrl());
        recipe.setDirections(source.getDirections());
        recipe.setDifficulty(source.getDifficulty());
        recipe.setDescription(source.getDescription());
        recipe.setNotes(notesConverter.convert(source.getNotes()));

        if (source.getCategories() != null && source.getCategories().size() > 0){
            source.getCategories()
                    .forEach( category -> recipe.getCategories().add(categoryConverter.convert(category)));
        }

        if (source.getIngredients() != null && source.getIngredients().size() > 0){
            source.getIngredients()
                    .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
        }



        return recipe;
    }
}
