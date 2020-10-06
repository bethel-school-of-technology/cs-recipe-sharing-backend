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
			//Check to see if the database is empty
			if(!recipes.iterator().hasNext()) {
				populateFirst();
				recipes = recipeRepository.findAll();
			}
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


		 private void populateFirst(){
			 for(Integer i = 0; i < 10; i++) {
				 //add some variables to mix things up
				 String description = "This is a wonderful recipe full of flavor and spice!";
				 String title = "Soup";
				 String[] adjectives = {"Amazing", "Wonderful", "Incredible", "The Best", "Excellent", "Great", "Perfect", "Delicious", "Tasty", "Simple"};
				 String difficulty = "Easy";
				 String directions = "Pour everything together and cook it.";
				 ArrayList<String> ingredients_name = new ArrayList<String>(5);
				 ArrayList<Integer> ingredients_amount = new ArrayList<Integer>(5);
				 ArrayList<String> ingredients_measurement = new ArrayList<String>(5);
				 ingredients_name.add("Tomato Paste");
				 ingredients_name.add("Salt");
				 ingredients_name.add("Pepper");
				 ingredients_name.add("Water");
				 ingredients_name.add("Broth");
				 ingredients_amount.add(1);
				 ingredients_amount.add(2);
				 ingredients_amount.add(2);
				 ingredients_amount.add(8);
				 ingredients_amount.add(6);
				 ingredients_measurement.add("cup(s)");
				 ingredients_measurement.add("tablespoon(s)");
				 ingredients_measurement.add("teaspoon(s)");
				 ingredients_measurement.add("ounce(s)");
				 ingredients_measurement.add("cups(s)");
			
				 if(i % 2 == 0 || i % 3 != 0) {
					description = "This will take you back home to the kitchens of Italy with every bite!";
				 	title = "Pasta";
				 	difficulty = "Hard";
					directions = "Cook the pasta, combine the ingredients for the sauce, and eat up!";
					ingredients_name.set(2, "Pasta");
					ingredients_name.set(1, "Tomato Sauce");
					ingredients_name.set(0, "Chicken");
					ingredients_name.set(3, "Olive Oil");
					ingredients_name.set(4, "White Pepper");
					ingredients_amount.set(2, 16);
					ingredients_amount.set(1, 8);
					ingredients_amount.set(0, 2);
					ingredients_amount.set(3, 3);
					ingredients_amount.set(4, 2);
					ingredients_measurement.set(2, "ounce(s)");
					ingredients_measurement.set(1, "ounces(s)");
					ingredients_measurement.set(0, "pounds(s)");
					ingredients_measurement.set(3, "tablespoon(s)");
					ingredients_measurement.set(4, "teaspoon(s)");
				 }
				 if(i % 3 == 0) {
					description = "This is a wonderful recipe full of flavor and spice!";
					title = "Grilled Steak";
					difficulty = "Medium";
					   directions = "Grill the steak. Cook the potatoes. Put on a plate. Eat.";
					   ingredients_name.set(0, "Beef");
					   ingredients_name.set(1, "Salt");
					   ingredients_name.set(2, "Pepper");
					   ingredients_name.set(3, "Butter");
					   ingredients_name.set(4, "Potatoes");
					   ingredients_amount.set(0, 1);
					   ingredients_amount.set(1, 2);
					   ingredients_amount.set(2, 2);
					   ingredients_amount.set(3, 4);
					   ingredients_amount.set(4, 1);
					   ingredients_measurement.set(0, "pound(s)");
					   ingredients_measurement.set(1, "tablespoon(s)");
					   ingredients_measurement.set(2, "tablespoon(s)");
					   ingredients_measurement.set(3, "tablespoon(s)");
					   ingredients_measurement.set(4, "pound(s)");
				 }

				 Recipe recipe = new Recipe();
				 recipe.setAuthor("Team Code Chefs");
				 recipe.setAuthorId(100);
				 recipe.setCookTime(30 + (i*5));
				 recipe.setDescription(description);
				 recipe.setDifficulty(difficulty);
				 recipe.setDirections(directions);
				 recipe.setIngredients_amount(ingredients_amount);
				 recipe.setIngredients_measurement(ingredients_measurement);
				 recipe.setIngredients_name(ingredients_name);
				 recipe.setServingSize(8 + i);
				 recipe.setTitle(adjectives[i] + " " + title + " with " + ingredients_name.get(0));
				 recipe.setTimeCreated(new Timestamp(System.currentTimeMillis()));
				 recipeRepository.save(recipe);
			 }

		 }
		 
}
