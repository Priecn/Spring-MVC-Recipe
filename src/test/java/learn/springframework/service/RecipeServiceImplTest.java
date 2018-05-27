package learn.springframework.service;

import learn.springframework.domain.Recipe;
import learn.springframework.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;

    RecipeServiceImpl recipeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipeByIdTest() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);

        Recipe recipeReturned = recipeService.getRecipeById(1L);

        assertNotNull("Null recipe returned", recipeReturned);
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();
    }


    @Test
    public void getRecipeTest() throws Exception{
        Recipe recipe = new Recipe();
        List<Recipe> recipeList = new ArrayList<>();
        recipeList.add(recipe);

        when(recipeService.getRecipeList()).thenReturn(recipeList);

        List<Recipe> recipes = recipeService.getRecipeList();
        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());
    }
}
