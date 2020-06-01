package matt.springframework.recipebook.springrecipe.converters;

import matt.springframework.recipebook.springrecipe.commands.IngredientCommand;
import matt.springframework.recipebook.springrecipe.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    public IngredientToIngredientCommand(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.uomConverter = uomConverter;
    }

    @Nullable
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if(ingredient == null) {
            return null;
        }

        IngredientCommand ingredientCommand = new IngredientCommand();
        ingredientCommand.setId(ingredient.getId());
        ingredientCommand.setDescription(ingredient.getDescription());
        ingredientCommand.setUnitOfMeasure(uomConverter.convert(ingredient.getUom()));

        return ingredientCommand;
    }
}
