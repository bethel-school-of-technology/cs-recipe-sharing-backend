package com.recipeshare.auth;

import java.sql.Timestamp;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Timestamp time_created;
	private String title;
	private String description;
	private Integer servingSize;
	private Integer cookTime;
	@Transient
	private ArrayList<Ingredients> ingredients;
	private ArrayList<String> ingredients_name;
	private ArrayList<Integer> ingredients_amount;
	private ArrayList<String> ingredients_measurement;
	private String difficulty;
	private String image;
	private String directions;
	private String author;
	private Integer authorId;

	public Integer getId() {
		return id;
	}

	public ArrayList<Ingredients> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredients> ingredients) {
		this.ingredients = ingredients;
	}

	public ArrayList<String> getIngredients_measurement() {
		return ingredients_measurement;
	}

	public void setIngredients_measurement(ArrayList<String> ingredients_measurement) {
		this.ingredients_measurement = ingredients_measurement;
	}

	public ArrayList<Integer> getIngredients_amount() {
		return ingredients_amount;
	}

	public void setIngredients_amount(ArrayList<Integer> ingredients_amount) {
		this.ingredients_amount = ingredients_amount;
	}

	public ArrayList<String> getIngredients_name() {
		return ingredients_name;
	}

	public void setIngredients_name(ArrayList<String> ingredients_name) {
		this.ingredients_name = ingredients_name;
	}

	public void setId(Integer id) {
			this.id = id;
		}
		public Timestamp getTimeCreated() {
			return time_created;
		}
		public void setTimeCreated(Timestamp time_created) {
			this.time_created = time_created;
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
