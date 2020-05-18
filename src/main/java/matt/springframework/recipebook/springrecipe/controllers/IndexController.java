package matt.springframework.recipebook.springrecipe.controllers;

import lombok.extern.slf4j.Slf4j;
import matt.springframework.recipebook.springrecipe.services.RecipeService;
import matt.springframework.recipebook.springrecipe.services.RecipeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    private final RecipeServiceImpl recipeServiceImpl;

    public IndexController(RecipeServiceImpl recipeServiceImpl) {
        this.recipeServiceImpl = recipeServiceImpl;
    }

    @RequestMapping({",","/","/index"})
    public String getIndexPage(Model model){

    log.debug("Getting Index Page");

    model.addAttribute("recipes",recipeServiceImpl.getRecipes());


        return "index";
    }
}
