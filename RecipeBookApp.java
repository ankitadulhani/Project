import java.util.*;

class Recipe {
    String name;
    String ingredients;
    String instructions;

    public Recipe(String name, String ingredients, String instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
}

public class RecipeBookApp {
    static List<Recipe> recipes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Recipe Book App");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Search Recipes");
            System.out.println("4. Edit Recipe");
            System.out.println("5. Delete Recipe");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    addRecipe();
                    break;
                case 2:
                    viewRecipes();
                    break;
                case 3:
                    searchRecipes();
                    break;
                case 4:
                    editRecipe();
                    break;
                case 5:
                    deleteRecipe();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    static void addRecipe() {
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ingredients: ");
        String ingredients = scanner.nextLine();
        System.out.print("Enter instructions: ");
        String instructions = scanner.nextLine();

        Recipe recipe = new Recipe(name, ingredients, instructions);
        recipes.add(recipe);
        System.out.println("Recipe added successfully!");
    }

    static void viewRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            for (int i = 0; i < recipes.size(); i++) {
                Recipe recipe = recipes.get(i);
                System.out.println("Recipe " + (i + 1));
                System.out.println("Name: " + recipe.name);
                System.out.println("Ingredients: " + recipe.ingredients);
                System.out.println("Instructions: " + recipe.instructions);
                System.out.println();
            }
        }
    }

    static void searchRecipes() {
        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();
        boolean found = false;

        for (Recipe recipe : recipes) {
            if (recipe.name.toLowerCase().contains(keyword.toLowerCase()) ||
                    recipe.ingredients.toLowerCase().contains(keyword.toLowerCase()) ||
                    recipe.instructions.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Name: " + recipe.name);
                System.out.println("Ingredients: " + recipe.ingredients);
                System.out.println("Instructions: " + recipe.instructions);
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No recipes found matching the search keyword.");
        }
    }

    static void editRecipe() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available to edit.");
        } else {
            viewRecipes();
            System.out.print("Enter the recipe number to edit: ");
            int recipeNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (recipeNumber > 0 && recipeNumber <= recipes.size()) {
                Recipe recipe = recipes.get(recipeNumber - 1);
                System.out.print("Enter new name (press enter to skip): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    recipe.name = newName;
                }

                System.out.print("Enter new ingredients (press enter to skip): ");
                String newIngredients = scanner.nextLine();
                if (!newIngredients.isEmpty()) {
                    recipe.ingredients = newIngredients;
                }

                System.out.print("Enter new instructions (press enter to skip): ");
                String newInstructions = scanner.nextLine();
                if (!newInstructions.isEmpty()) {
                    recipe.instructions = newInstructions;
                }

                System.out.println("Recipe edited successfully!");
            } else {
                System.out.println("Invalid recipe number.");
            }
        }
    }

    static void deleteRecipe() {
        if (recipes.isEmpty()) {
            System.out.println("No recipes available to delete.");
        } else {
            viewRecipes();
            System.out.print("Enter the recipe number to delete: ");
            int recipeNumber = scanner.nextInt();
            scanner.nextLine(); 

            if (recipeNumber > 0 && recipeNumber <= recipes.size()) {
                recipes.remove(recipeNumber - 1);
                System.out.println("Recipe deleted successfully!");
            } else {
                System.out.println("Invalid recipe number.");
            }
        }
    }
}

