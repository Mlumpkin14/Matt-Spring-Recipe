package matt.springframework.recipebook.springrecipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication

public class SpringRecipeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRecipeApplication.class, args);
    }

}
