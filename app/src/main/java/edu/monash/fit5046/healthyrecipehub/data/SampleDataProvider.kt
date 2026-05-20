package edu.monash.fit5046.healthyrecipehub.data

import edu.monash.fit5046.healthyrecipehub.data.model.Ingredient
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe

/**
 * Sample Data Provider for Demo Purposes
 * Provides realistic recipe data to populate the app
 */
object SampleDataProvider {

    fun getSampleRecipes(): List<Recipe> {
        return listOf(
            Recipe(
                id = "recipe_001",
                title = "Grilled Salmon with Asparagus",
                description = "A healthy and delicious salmon dish rich in omega-3 fatty acids. Perfect for a nutritious dinner that supports heart health.",
                imageUrl = "https://picsum.photos/seed/salmon/400/300",
                calories = 420,
                protein = 35.0,
                carbs = 12.0,
                fat = 24.0,
                fiber = 4.0,
                sugar = 3.0,
                sodium = 580.0,
                prepTime = 10,
                cookTime = 15,
                servings = 2,
                difficulty = "Easy",
                category = "Dinner",
                cuisine = "Mediterranean",
                dietaryTags = listOf("High Protein", "Low Carb", "Gluten-Free"),
                ingredients = listOf(
                    Ingredient("Salmon fillet", 400.0, "g", false),
                    Ingredient("Asparagus", 300.0, "g", false),
                    Ingredient("Olive oil", 30.0, "ml", false),
                    Ingredient("Lemon", 1.0, "piece", false),
                    Ingredient("Garlic", 3.0, "cloves", false),
                    Ingredient("Black pepper", 5.0, "g", true),
                    Ingredient("Sea salt", 3.0, "g", false)
                ),
                instructions = listOf(
                    "Preheat the grill to medium-high heat.",
                    "Season salmon fillets with salt, pepper, and minced garlic.",
                    "Toss asparagus with olive oil and seasoning.",
                    "Grill salmon for 4-5 minutes per side until flaky.",
                    "Grill asparagus for 3-4 minutes until tender-crisp.",
                    "Serve with fresh lemon wedges."
                ),
                nutritionScore = 92.0,
                authorId = "user_admin",
                authorName = "HealthyChef",
                isFavorite = true
            ),

            Recipe(
                id = "recipe_002",
                title = "Quinoa Buddha Bowl",
                description = "A nutrient-packed vegetarian bowl featuring quinoa, roasted vegetables, and tahini dressing. High in fiber and plant protein.",
                imageUrl = "https://picsum.photos/seed/quinoa/400/300",
                calories = 380,
                protein = 14.0,
                carbs = 52.0,
                fat = 16.0,
                fiber = 12.0,
                sugar = 8.0,
                sodium = 420.0,
                prepTime = 15,
                cookTime = 25,
                servings = 1,
                difficulty = "Medium",
                category = "Lunch",
                cuisine = "International",
                dietaryTags = listOf("Vegetarian", "High Fiber", "Vegan Option"),
                ingredients = listOf(
                    Ingredient("Quinoa", 100.0, "g", false),
                    Ingredient("Chickpeas", 150.0, "g", false),
                    Ingredient("Sweet potato", 200.0, "g", false),
                    Ingredient("Kale", 100.0, "g", false),
                    Ingredient("Avocado", 0.5, "piece", false),
                    Ingredient("Tahini", 30.0, "ml", false),
                    Ingredient("Cherry tomatoes", 100.0, "g", false)
                ),
                instructions = listOf(
                    "Rinse quinoa and cook according to package instructions.",
                    "Roast chickpeas and sweet potato cubes at 200°C for 20 minutes.",
                    "Massage kale with olive oil to soften.",
                    "Make tahini dressing by mixing tahini, lemon, and water.",
                    "Assemble bowl: quinoa base, roasted vegetables, fresh toppings.",
                    "Drizzle with tahini dressing and serve."
                ),
                nutritionScore = 88.0,
                authorId = "user_admin",
                authorName = "NutritionExpert",
                isFavorite = false
            ),

            Recipe(
                id = "recipe_003",
                title = "Greek Yogurt Parfait",
                description = "A protein-rich breakfast parfait layered with Greek yogurt, fresh berries, and crunchy granola. Perfect start to your day.",
                imageUrl = "https://picsum.photos/seed/parfait/400/300",
                calories = 280,
                protein = 20.0,
                carbs = 35.0,
                fat = 8.0,
                fiber = 6.0,
                sugar = 18.0,
                sodium = 120.0,
                prepTime = 5,
                cookTime = 0,
                servings = 1,
                difficulty = "Easy",
                category = "Breakfast",
                cuisine = "Mediterranean",
                dietaryTags = listOf("High Protein", "Quick Meal", "Vegetarian"),
                ingredients = listOf(
                    Ingredient("Greek yogurt", 200.0, "g", false),
                    Ingredient("Mixed berries", 100.0, "g", false),
                    Ingredient("Granola", 40.0, "g", false),
                    Ingredient("Honey", 15.0, "ml", true),
                    Ingredient("Chia seeds", 10.0, "g", true),
                    Ingredient("Almonds", 15.0, "g", true)
                ),
                instructions = listOf(
                    "Layer half the yogurt in a glass or bowl.",
                    "Add a layer of mixed berries.",
                    "Sprinkle half the granola on top.",
                    "Repeat the layers.",
                    "Top with chia seeds, almonds, and a drizzle of honey.",
                    "Serve immediately or refrigerate."
                ),
                nutritionScore = 85.0,
                authorId = "user_admin",
                authorName = "BreakfastClub",
                isFavorite = true
            ),

            Recipe(
                id = "recipe_004",
                title = "Chicken Stir-Fry with Vegetables",
                description = "A quick and healthy Asian-inspired stir-fry packed with lean protein and colorful vegetables. Low in calories but high in flavor.",
                imageUrl = "https://picsum.photos/seed/stirfry/400/300",
                calories = 320,
                protein = 28.0,
                carbs = 22.0,
                fat = 14.0,
                fiber = 5.0,
                sugar = 6.0,
                sodium = 650.0,
                prepTime = 15,
                cookTime = 10,
                servings = 2,
                difficulty = "Easy",
                category = "Dinner",
                cuisine = "Asian",
                dietaryTags = listOf("High Protein", "Low Fat", "Quick Meal"),
                ingredients = listOf(
                    Ingredient("Chicken breast", 300.0, "g", false),
                    Ingredient("Broccoli", 200.0, "g", false),
                    Ingredient("Bell peppers", 150.0, "g", false),
                    Ingredient("Snow peas", 100.0, "g", false),
                    Ingredient("Soy sauce", 30.0, "ml", false),
                    Ingredient("Ginger", 20.0, "g", false),
                    Ingredient("Sesame oil", 10.0, "ml", false),
                    Ingredient("Garlic", 3.0, "cloves", false)
                ),
                instructions = listOf(
                    "Slice chicken into thin strips.",
                    "Cut vegetables into bite-sized pieces.",
                    "Heat sesame oil in a wok over high heat.",
                    "Stir-fry chicken for 3-4 minutes until cooked through.",
                    "Add vegetables and stir-fry for 3 minutes.",
                    "Add soy sauce and ginger, toss to combine.",
                    "Serve hot over rice or noodles."
                ),
                nutritionScore = 86.0,
                authorId = "user_admin",
                authorName = "AsianFusion",
                isFavorite = false
            ),

            Recipe(
                id = "recipe_005",
                title = "Avocado Toast with Poached Egg",
                description = "The ultimate healthy breakfast or brunch option. Creamy avocado on whole grain toast topped with a perfectly poached egg.",
                imageUrl = "https://picsum.photos/seed/avocado/400/300",
                calories = 340,
                protein = 16.0,
                carbs = 28.0,
                fat = 20.0,
                fiber = 8.0,
                sugar = 3.0,
                sodium = 380.0,
                prepTime = 5,
                cookTime = 8,
                servings = 1,
                difficulty = "Easy",
                category = "Breakfast",
                cuisine = "International",
                dietaryTags = listOf("Vegetarian", "High Fiber", "Quick Meal"),
                ingredients = listOf(
                    Ingredient("Whole grain bread", 2.0, "slices", false),
                    Ingredient("Avocado", 0.5, "piece", false),
                    Ingredient("Egg", 1.0, "piece", false),
                    Ingredient("Lemon juice", 5.0, "ml", false),
                    Ingredient("Chili flakes", 1.0, "g", true),
                    Ingredient("Sea salt", 2.0, "g", false),
                    Ingredient("Black pepper", 1.0, "g", false)
                ),
                instructions = listOf(
                    "Toast the bread slices until golden brown.",
                    "Mash avocado with lemon juice, salt, and pepper.",
                    "Bring water to a gentle simmer for poaching.",
                    "Crack egg into a cup, then slide into simmering water.",
                    "Poach for 3 minutes for a runny yolk.",
                    "Spread avocado on toast and top with poached egg.",
                    "Sprinkle with chili flakes if desired."
                ),
                nutritionScore = 84.0,
                authorId = "user_admin",
                authorName = "BrunchLover",
                isFavorite = true
            ),

            Recipe(
                id = "recipe_006",
                title = "Mediterranean Chickpea Salad",
                description = "A refreshing and filling salad with chickpeas, cucumber, tomatoes, and feta. Perfect for a light lunch or side dish.",
                imageUrl = "https://picsum.photos/seed/chickpea/400/300",
                calories = 260,
                protein = 12.0,
                carbs = 32.0,
                fat = 12.0,
                fiber = 10.0,
                sugar = 8.0,
                sodium = 480.0,
                prepTime = 10,
                cookTime = 0,
                servings = 2,
                difficulty = "Easy",
                category = "Lunch",
                cuisine = "Mediterranean",
                dietaryTags = listOf("Vegetarian", "High Fiber", "No Cook"),
                ingredients = listOf(
                    Ingredient("Chickpeas", 240.0, "g", false),
                    Ingredient("Cucumber", 150.0, "g", false),
                    Ingredient("Cherry tomatoes", 200.0, "g", false),
                    Ingredient("Red onion", 50.0, "g", false),
                    Ingredient("Feta cheese", 80.0, "g", false),
                    Ingredient("Olive oil", 30.0, "ml", false),
                    Ingredient("Lemon juice", 15.0, "ml", false),
                    Ingredient("Fresh oregano", 5.0, "g", true)
                ),
                instructions = listOf(
                    "Rinse and drain chickpeas.",
                    "Dice cucumber and halve cherry tomatoes.",
                    "Finely chop red onion.",
                    "Cube feta cheese.",
                    "Combine all ingredients in a large bowl.",
                    "Whisk olive oil and lemon juice for dressing.",
                    "Toss salad with dressing and season to taste.",
                    "Garnish with fresh oregano if available."
                ),
                nutritionScore = 90.0,
                authorId = "user_admin",
                authorName = "MediterraneanKitchen",
                isFavorite = false
            ),

            Recipe(
                id = "recipe_007",
                title = "Overnight Oats with Berries",
                description = "Prepare breakfast the night before with these protein-packed overnight oats. Perfect for busy mornings.",
                imageUrl = "https://picsum.photos/seed/oats/400/300",
                calories = 310,
                protein = 12.0,
                carbs = 48.0,
                fat = 9.0,
                fiber = 9.0,
                sugar = 14.0,
                sodium = 95.0,
                prepTime = 5,
                cookTime = 0,
                servings = 1,
                difficulty = "Easy",
                category = "Breakfast",
                cuisine = "International",
                dietaryTags = listOf("Meal Prep", "High Fiber", "Vegetarian"),
                ingredients = listOf(
                    Ingredient("Rolled oats", 60.0, "g", false),
                    Ingredient("Almond milk", 200.0, "ml", false),
                    Ingredient("Greek yogurt", 100.0, "g", false),
                    Ingredient("Chia seeds", 15.0, "g", false),
                    Ingredient("Mixed berries", 80.0, "g", false),
                    Ingredient("Maple syrup", 15.0, "ml", true),
                    Ingredient("Vanilla extract", 2.0, "ml", true)
                ),
                instructions = listOf(
                    "Combine oats, milk, yogurt, and chia seeds in a jar.",
                    "Add vanilla extract if using.",
                    "Stir well and refrigerate overnight (or at least 4 hours).",
                    "In the morning, top with fresh berries.",
                    "Drizzle with maple syrup if desired.",
                    "Enjoy cold or warmed up."
                ),
                nutritionScore = 87.0,
                authorId = "user_admin",
                authorName = "MealPrepMaster",
                isFavorite = true
            ),

            Recipe(
                id = "recipe_008",
                title = "Turkey Lettuce Wraps",
                description = "Low-carb lettuce wraps filled with seasoned ground turkey. A light yet satisfying meal packed with protein.",
                imageUrl = "https://picsum.photos/seed/turkey/400/300",
                calories = 240,
                protein = 26.0,
                carbs = 10.0,
                fat = 12.0,
                fiber = 3.0,
                sugar = 5.0,
                sodium = 520.0,
                prepTime = 10,
                cookTime = 12,
                servings = 2,
                difficulty = "Easy",
                category = "Dinner",
                cuisine = "Asian Fusion",
                dietaryTags = listOf("Low Carb", "High Protein", "Gluten-Free"),
                ingredients = listOf(
                    Ingredient("Ground turkey", 300.0, "g", false),
                    Ingredient("Butter lettuce", 8.0, "leaves", false),
                    Ingredient("Water chestnuts", 100.0, "g", false),
                    Ingredient("Green onions", 3.0, "stalks", false),
                    Ingredient("Soy sauce", 25.0, "ml", false),
                    Ingredient("Sesame oil", 10.0, "ml", false),
                    Ingredient("Ginger", 15.0, "g", false),
                    Ingredient("Garlic", 2.0, "cloves", false)
                ),
                instructions = listOf(
                    "Chop water chestnuts and green onions.",
                    "Heat sesame oil in a pan over medium heat.",
                    "Cook ground turkey until no longer pink.",
                    "Add ginger, garlic, soy sauce, and cook for 2 minutes.",
                    "Stir in water chestnuts and green onions.",
                    "Spoon mixture into lettuce leaves.",
                    "Serve immediately while warm."
                ),
                nutritionScore = 89.0,
                authorId = "user_admin",
                authorName = "HealthyChef",
                isFavorite = false
            )
        )
    }
}
