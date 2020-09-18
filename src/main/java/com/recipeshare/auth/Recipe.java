package com.recipeshare.auth;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {
	
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Integer id;
		
		private String title;
		private String description;
		private Integer servingSize;
		private Integer cookTime;
		private String difficulty;
		private String image;
		private Ingredients[] ingredients;
		private String directions;
		private String author;
		private Integer authorId;
		
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Integer getServingSize() {
			return servingSize;
		}
		public void setServingSize(Integer servingSize) {
			this.servingSize = servingSize;
		}
		public Integer getCookTime() {
			return cookTime;
		}
		public void setCookTime(Integer cookTime) {
			this.cookTime = cookTime;
		}
		public String getDifficulty() {
			return difficulty;
		}
		public void setDifficulty(String difficulty) {
			this.difficulty = difficulty;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public Ingredients[] getIngredients() {
			return ingredients;
		}
		public void setIngredients(Ingredients[] ingredients) {
			this.ingredients = ingredients;
		}
		public String getDirections() {
			return directions;
		}
		public void setDirections(String directions) {
			this.directions = directions;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public Integer getAuthorId() {
			return authorId;
		}
		public void setAuthorId(Integer authorId) {
			this.authorId = authorId;
		}
		
		
		
	
	}
