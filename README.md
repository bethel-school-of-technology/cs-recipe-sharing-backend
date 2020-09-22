# Recipe Sharing Backend
This is the backend repository for the recipe sharing website created by team < Code Chefs />.

## How to Install
1. Clone this repo to your local machine (git clone)
2. Downloand MYSQL workbench: https://www.mysql.com/products/workbench/
3. Setup MYSQL to have a username of ROOT and Password of "Password1!"
4. Navigate in Visual Studio Code in the JAVA files to src/main/java/com/recipeshare/RecipeSharingBackendApplication.java
5. Press the Play button in the top right of VS Code (install any plugins it may suggest)
6. Your server is now up and running! In a separate VS Code Window, you can open the Front End and interact with the backend.

## URL END POINTS FOR THE FRONT END
Here are the end points as of right now:

#### USER End Points:
- POST localhost:8080/api/user/register (for registering new users)
- POST localhost:8080/login (for logging in a user)
- GET localhost:8080/api/user (for getting logged in user's info)

#### Recipe End Points
- GET localhost:8080/api/recipe (returns all recipes with no authorization)
- POST localhost:8080/api/recipe/add (for posting new recipes, see structures below)


### User Structure

Here is the JSON that needs to be sent in the BODY to register a user:
{
    "username":"user",
    "email": "email",
    "password":"password"
}
Here is the JSON that needs to be sent in the BODY to login:
{
    "username":"username",
    "password":"password"
}
Here is the JSON that gets returned when a user's info is requested (the user's info is requested by passing the authorization token and in the header request the username of the user):
{
    "id": 5,
    "username": "username",
    "email": "email",
    "password": "encrypted",
    "savedRecipes": [saved IDs]
}

### Recipe structure so far:
This is the JSON that needs passed in the BODY to create a recipe:
{
    "title":"ethans Recipe",
    "description":"A cool recipe",
    "servingSize":8,
    "cookTime": 30,
	"difficulty": "easy",
	"image": "url",
	"ingredients": [
        {"name":"pepper", "amount":3, "measurement":"tablespoon(s)"},
        {"name":"salt", "amount":2, "measurement":"teaspoon(s)"}
        ],
	"directions": "stir things together",
	"author":"ethanmcneil",
	"authorId":42
}
This is the JSON data returned from a get request on the recipes:
{
        "id": 10,
        "title": "ethans Recipe",
        "description": "A cool recipe",
        "servingSize": 8,
        "cookTime": 30,
        "difficulty": "easy",
        "image": "url",
        "ingredients": [
        {"name":"pepper", "amount":3, "measurement":"tablespoon(s)"},
        {"name":"salt", "amount":2, "measurement":"teaspoon(s)"}
        ],
        "directions": "stir things together",
        "author": "ethanmcneil",
        "authorId": 42,
        "timeCreated": "2020-09-22T20:29:32.778+00:00"
}

PLEASE NOTE AS OF 9-21 the everything is working except the ingredients part of the recipes.
