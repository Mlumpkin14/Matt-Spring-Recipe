package matt.springframework.recipebook.springrecipe.converters;

import lombok.Synchronized;
import matt.springframework.recipebook.springrecipe.commands.CategoryCommand;
import matt.springframework.recipebook.springrecipe.domain.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class CategoryCommandtoCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Nullable
    @Override
    public Category convert(CategoryCommand source) {
        if(source == null){
            return null;
        }

        final Category category = new Category();

        category.setId(source.getId());
        category.setDescription(source.getDescription());

        return category;
    }
}
