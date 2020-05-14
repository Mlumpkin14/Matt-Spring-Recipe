package matt.springframework.recipebook.springrecipe.controllers;

import matt.springframework.recipebook.springrecipe.services.RecipeService;
import matt.springframework.recipebook.springrecipe.services.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final RecipeServiceImpl recipeServiceImpl;

    public IndexController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping({",","/","/index"})
    public String getIndexPage(Model model){

    model.addAttribute("recipes",recipeServiceImpl.getRecipes());


        return "index";
    }
}
