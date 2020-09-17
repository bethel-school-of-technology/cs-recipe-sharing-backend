# Recipe Sharing Backend
This is the backend repository for the recipe sharing website created by team < Code Chefs />.

## Done So Far
Ethan has created a Recipe and Ingredients Class. He has created a Post url and Get Url for the Recipes. Security is not setup yet and is not allowing these features to actually write to the database. So that still needs done.

### Recipe structure so far:
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