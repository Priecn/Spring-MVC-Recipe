package learn.springframework.controller;

import learn.springframework.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipe/{id}/show")
    public String getRecipeViewById(@PathVariable String id, Model model){
        model.addAttribute("recipe", recipeService.getRecipeById(new Long(id)));
        return "recipe/show";
    }
}

