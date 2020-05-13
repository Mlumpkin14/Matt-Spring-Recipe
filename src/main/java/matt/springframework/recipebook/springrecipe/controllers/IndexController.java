package matt.springframework.recipebook.springrecipe.controllers;

import matt.springframework.recipebook.springrecipe.domain.Category;
import matt.springframework.recipebook.springrecipe.domain.UnitOfMeasure;
import matt.springframework.recipebook.springrecipe.repositories.CategoryRepository;
import matt.springframework.recipebook.springrecipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLOutput;
import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;



    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {

        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;

    }

    @RequestMapping({",","/","/index"})
    public String getIndexPage(){
        System.out.println("Some Message... Hello World");

        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        System.out.println("Cat id is: " + categoryOptional.get().getId());
        System.out.println("UOM id is: " + unitOfMeasureOptional.get().getId());



        return "index";
    }
}
