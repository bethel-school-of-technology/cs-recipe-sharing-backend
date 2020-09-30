package com.recipeshare.auth;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/recipe")
public class RecipeController {

		
		 @Autowired
		 private RecipeRepository recipeRepository;
		 
		 @GetMapping(path="")
		 public @ResponseBody Iterable<Recipe> getAllRecipes() {
			Iterable<Recipe> recipes = recipeRepository.findAll();
			for(Recipe r: recipes) {
				if(r.getIngredients_name() != null) {
				ArrayList<Ingredients> compilingIngredients = new ArrayList<Ingredients>();
				for(int i = 0; i < r.getIngredients_name().size(); i++) {
					Ingredients newIngredient = new Ingredients();
					newIngredient.newIngredient(r.getIngredients_name().get(i), r.getIngredients_amount().get(i), r.getIngredients_measurement().get(i));
					compilingIngredients.add(newIngredient);
				}
				r.setIngredients(compilingIngredients);
				System.out.println(r);
				}
			}
			System.out.println(recipes);
			 return recipes;
		 }
		 
		 @PostMapping(path="/add")
		 public String addNewRecipe(@RequestBody String incomingRecipe) {
			 Gson gson = new Gson();
			 Recipe newRecipe = gson.fromJson(incomingRecipe, Recipe.class);
			 newRecipe.setTimeCreated(new Timestamp(System.currentTimeMillis()));
			 ArrayList<Ingredients> incomingIngredients = newRecipe.getIngredients();
			 ArrayList<String> iname = new ArrayList<String>();
			 ArrayList<Integer> iamount = new ArrayList<Integer>();
			 ArrayList<String> imeasure = new ArrayList<String>();
			 for(int i = 0; i < incomingIngredients.size(); i++) {
				 iname.add(incomingIngredients.get(i).getName());
				 iamount.add(incomingIngredients.get(i).getAmount());
				 imeasure.add(incomingIngredients.get(i).getMeasurement());
			 }
			 newRecipe.setIngredients_name(iname);
			 newRecipe.setIngredients_measurement(imeasure);
			 newRecipe.setIngredients_amount(iamount);
			 recipeRepository.save(newRecipe);
			 return "Success";
		 }
		 
}
