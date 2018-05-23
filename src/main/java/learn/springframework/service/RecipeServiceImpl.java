package learn.springframework.service;

import learn.springframework.domain.Recipe;
import learn.springframework.repository.RecipeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipeList() {
        List<Recipe> recipeList = new ArrayList<>();
        recipeRepository.findAll()
                        .forEach(recipeList::add);
        return recipeList;
    }
}
