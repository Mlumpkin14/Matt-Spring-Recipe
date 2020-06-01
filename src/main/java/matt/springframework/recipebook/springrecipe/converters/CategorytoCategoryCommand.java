package matt.springframework.recipebook.springrecipe.converters;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lombok.Synchronized;
import matt.springframework.recipebook.springrecipe.commands.CategoryCommand;
import matt.springframework.recipebook.springrecipe.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CategorytoCategoryCommand implements Converter<Category, CategoryCommand> {


    @Synchronized
    @Nullable
    @Override
    public CategoryCommand convert(Category source) {
        if(source == null) {
            return null;
        }

        final CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(source.getId());
        categoryCommand.setDescription(source.getDescription());

        return categoryCommand;
    }


}
