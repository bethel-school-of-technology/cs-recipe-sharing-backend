# Recipe Sharing Backend
This is the backend repository for the recipe sharing website created by team < Code Chefs />.

## How to Install
1. Clone this repo to your local machine (git clone)
2. Downloand MYSQL workbench: https://www.mysql.com/products/workbench/
3. Setup MYSQL to have a username of ROOT and Password of "Password1!"
4. Navigate in Visual Studio Code in the JAVA files to src/main/java/com/recipeshare/RecipeSharingBackendApplication.java
5. Make sure you have the latest JAVA JDK installed.
6. Press the Play button in the top right of VS Code (install any plugins it may suggest)
7. Your server is now up and running! In a separate VS Code Window, you can open the Front End and interact with the backend.

The very first time you run the server and perform a get request for recipes, it will automatically populate your database with 10 recipes. But the database must be empty for it to do this.

## URL END POINTS FOR THE FRONT END
Here are the end points as of right now:

#### USER End Points:
- POST localhost:8080/api/user/register (for registering new user - must send user info in body)
- POST localhost:8080/login (for logging in a user - must send username and password in body)
- GET localhost:8080/api/user (for getting logged in user's info - must send TOKEN and username in header)
- DELETE localhost:8080/api/user/{id} (for deleting a user - must send ID in url and TOKEN in header)
- PUT localhost:8080/api/user/my-recipe (for adding a new recipe or removing a recipe from a user's saved recipe list - must send userId, recipeId, and TOKEN in header)
- PUT localhost:8080/api/user/update (for updating a user's information - must send email, username, and saved recipes in body)

#### Recipe End Points
- GET localhost:8080/api/recipe (returns all recipes with no authorization)
- POST localhost:8080/api/recipe/add (for posting new recipes, see structures below)
- GET localhost:8080/api/recipe/{id} (returns one recipe with no authorization)
- POST localhost:8080/api/recipe/add (for creating a new recipe - must have the recipe in body and TOKEN in header)
- POST localhost:8080/api/recipe/uploadImage (for creating a new Image - must have the image as form data in body and the TOKEN in header - will return the new file location)
- GET localhost:8080/api/recipe/images/{name} (returns an image with no authentication)
- PUT localhost:8080/api/recipe/update (for updating a recipe - must have the recipe in body and TOKEN in header)
- DELETE localhost:8080/api/recipe/{id} (deletes a recipe - must have TOKEN in header)



### User Structure
Here is the JSON that needs to be sent in the BODY to register a user:
```
{
    "username":"user",
    "email": "email",
    "password":"password"
}
```
Here is the JSON that needs to be sent in the BODY to login:
```
{
    "username":"username",
    "password":"password"
}
```
Here is the JSON that gets returned when a user's info is requested (the user's info is requested by passing the authorization token and in the header request the username of the user):
```
{
    "id": 5,
    "username": "username",
    "email": "email",
    "password": "encrypted",
    "savedRecipes": [saved IDs]
}
```

### Authorization
For all requests besides the Register and Get Recipes, you must pass in the header of your requests an **Authorization** key with the JWT token as the value. You will receive this token in the header of the response upon a successful login.

### Recipe structure:
This is the JSON that needs passed in the BODY to create a recipe:
```
{
   "title":"ethans 54 Recipe",
    "description":"A cool recipe",
    "servingSize":8,
    "cookTime": 30,
	"difficulty": "easy",
    "ingredients": [{
                    "name": "salt",
                    "amount": 3,
                    "measurement": "tablespoons"
                    },
                    {
                    "name": "pepper",
                    "amount": 3,
                    "measurement": "tablespoons"
                    }],
	"image": "url",
	"directions": "stir things together",
	"author":"ethanmcneil",
	"authorId":22
}
```

This is the JSON data returned from a get request on the recipes:
```
{
        "id": 40,
        "title": "ethans 54 Recipe",
        "description": "A cool recipe",
        "servingSize": 8,
        "cookTime": 30,
        "ingredients": [
            {
                "name": "salt",
                "amount": 3,
                "measurement": "tablespoons"
            },
            {
                "name": "pepper",
                "amount": 3,
                "measurement": "tablespoons"
            }
        ],
        "ingredients_name": [
            "salt",
            "pepper"
        ],
        "ingredients_amount": [
            3,
            3
        ],
        "ingredients_measurement": [
            "tablespoons",
            "tablespoons"
        ],
        "difficulty": "easy",
        "image": "url",
        "directions": "stir things together",
        "author": "ethanmcneil",
        "authorId": 22,
        "timeCreated": "2020-09-30T19:10:12.728+00:00"
}
```

## LEFT TO DO:
Update and delete functions for users and recipes.
