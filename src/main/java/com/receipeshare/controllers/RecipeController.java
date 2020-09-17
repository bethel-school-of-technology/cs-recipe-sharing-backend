package com.receipeshare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
			 return recipeRepository.findAll();
		 }
		 
		 @PostMapping(path="/new")
		 public ResponseEntity<Recipe> addNewRecipe(
				 @RequestBody String title,
				 @RequestBody String description,
				 @RequestBody Integer servingSize,
				 @RequestBody Integer cookTime,
				 @RequestBody String difficulty,
				 @RequestBody String image,
				 @RequestBody Ingredients[] ingredients,
				 @RequestBody String directions,
				 @RequestBody String author,
				 @RequestBody Integer authorId) {
			 Recipe addedRecipe = new Recipe();
			 addedRecipe.setTitle(title);
			 addedRecipe.setDescription(description);
			 addedRecipe.setServingSize(servingSize);
			 addedRecipe.setCookTime(cookTime);
			 addedRecipe.setDifficulty(difficulty);
			 addedRecipe.setImage(image);
			 addedRecipe.setIngredients(ingredients);
			 addedRecipe.setDirections(directions);
			 addedRecipe.setAuthor(author);
			 addedRecipe.setAuthorId(authorId);
			 recipeRepository.save(addedRecipe);
			 return ResponseEntity.ok(addedRecipe);
		 }
		 
}
