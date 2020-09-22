package com.recipeshare.auth;

import java.sql.Timestamp;

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
		 
		 @PostMapping(path="/add")
		 public ResponseEntity <Recipe> addNewRecipe(@RequestBody Recipe incomingRecipe) {
			 System.out.print(incomingRecipe);
			 incomingRecipe.setTimeCreated(new Timestamp(System.currentTimeMillis()));
			 recipeRepository.save(incomingRecipe);
			 return ResponseEntity.ok(incomingRecipe);
		 }
		 
}
