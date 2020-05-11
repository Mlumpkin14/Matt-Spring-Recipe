package matt.springframework.recipebook.springrecipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({",","/","/index"})
    public String getIndexPage(){
        System.out.println("Some Message... Hello World");
        return "index";
    }
}
