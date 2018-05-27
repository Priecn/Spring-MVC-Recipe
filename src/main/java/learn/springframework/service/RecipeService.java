package learn.springframework.service;

import learn.springframework.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecipeService {

    List<Recipe> getRecipeList();

    Recipe getRecipeById(Long id);
}
