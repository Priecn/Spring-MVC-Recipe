package learn.springframework.controller;

import learn.springframework.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"/", "", "/index"})
    public String index(Model model){
        model.addAttribute("recipes", recipeService.getRecipeList());
        return "index";
    }
}
