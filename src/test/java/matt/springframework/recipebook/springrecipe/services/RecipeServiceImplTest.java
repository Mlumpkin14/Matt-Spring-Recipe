package matt.springframework.recipebook.springrecipe.services;

import matt.springframework.recipebook.springrecipe.converters.RecipeCommandToRecipe;
import matt.springframework.recipebook.springrecipe.converters.RecipeToRecipeCommand;
import matt.springframework.recipebook.springrecipe.domain.Recipe;
import matt.springframework.recipebook.springrecipe.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository,recipeToRecipeCommand,recipeCommandToRecipe);

    }

    @Test
    public void getTestById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.findById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository,times(1)).findById(anyLong());
        verify(recipeRepository,never()).findAll();



    }

    @Test
    public void getRecipesTest() {

        Recipe recipe = new Recipe();
        HashSet recipeData = new HashSet();
        recipeData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(),1);
        verify(recipeRepository,times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());

    }


}