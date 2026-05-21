package edu.monash.fit5046.healthyrecipehub.ui

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe
import edu.monash.fit5046.healthyrecipehub.data.repository.AuthState
import edu.monash.fit5046.healthyrecipehub.ui.auth.AuthActivity
import edu.monash.fit5046.healthyrecipehub.ui.components.BottomNavBar
import edu.monash.fit5046.healthyrecipehub.ui.components.DrawerContent
import edu.monash.fit5046.healthyrecipehub.ui.navigation.Screen
import edu.monash.fit5046.healthyrecipehub.ui.screens.addrecipe.AddRecipeScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.ai.AIAssistantScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.charts.ChartsScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.favorites.FavoritesScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.home.HomeScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.map.MapScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.profile.ProfileScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.recipe.RecipeDetailScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.recipes.RecipesScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.settings.SettingsScreen
import edu.monash.fit5046.healthyrecipehub.ui.theme.HealthyRecipeHubTheme
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.AuthViewModel
import edu.monash.fit5046.healthyrecipehub.ui.viewmodel.RecipeViewModel
import kotlinx.coroutines.launch

@Composable
fun MainApp(
    navController: NavHostController = rememberNavController(),
    authViewModel: AuthViewModel = viewModel(),
    recipeViewModel: RecipeViewModel = viewModel()
) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStack?.destination?.route ?: Screen.Home.route

    val context = LocalContext.current
    val authState by authViewModel.authState.collectAsState()
    val currentUser by authViewModel.currentUser.collectAsState()

    val userName = currentUser?.displayName ?: "User"
    val userEmail = currentUser?.email ?: "user@example.com"

    val previousAuthState = remember { mutableStateOf(authState) }
    LaunchedEffect(authState) {
        if (previousAuthState.value is AuthState.Authenticated && authState is AuthState.Unauthenticated) {
            context.startActivity(Intent(context, AuthActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
        }
        previousAuthState.value = authState
    }

    val bottomNavRoutes = listOf(
        Screen.Home.route, Screen.Recipes.route, Screen.AddRecipe.route,
        Screen.Favorites.route, Screen.Profile.route
    )
    val showBottomNav = currentRoute in bottomNavRoutes

    HealthyRecipeHubTheme {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(
                    currentRoute = currentRoute,
                    onNavigate = { route ->
                        when (route) {
                            "logout" -> authViewModel.logout()
                            else -> navController.navigate(route) {
                                launchSingleTop = true; restoreState = true
                            }
                        }
                    },
                    onCloseDrawer = { scope.launch { drawerState.close() } },
                    userName = userName,
                    userEmail = userEmail,
                    isAdmin = authViewModel.isAdmin()
                )
            },
            gesturesEnabled = drawerState.isOpen || showBottomNav
        ) {
            Scaffold(
                bottomBar = {
                    if (showBottomNav) {
                        BottomNavBar(
                            currentRoute = currentRoute,
                            onNavigate = { route ->
                                navController.navigate(route) {
                                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                }
            ) { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route,
                    modifier = Modifier.fillMaxSize().padding(paddingValues)
                ) {
                    // Home
                    composable(Screen.Home.route) {
                        val pick by recipeViewModel.dailyPick.observeAsState()
                        HomeScreen(
                            onNavigate = { navController.navigate(it) { launchSingleTop = true; restoreState = true } },
                            onOpenDrawer = { scope.launch { drawerState.open() } },
                            userName = userName,
                            dailyPick = pick?.data
                        )
                    }

                    // Recipes (Spoonacular)
                    composable(Screen.Recipes.route) {
                        val recipesResource by recipeViewModel.recipes.observeAsState()
                        val favResource by recipeViewModel.favorites.observeAsState()
                        val favoriteIds = remember(favResource) {
                            favResource?.data?.map { it.id }?.toSet() ?: emptySet()
                        }
                        RecipesScreen(
                            onNavigate = { navController.navigate(it) { launchSingleTop = true; restoreState = true } },
                            recipes = recipesResource?.data ?: emptyList(),
                            onToggleFavorite = { summary, isFav ->
                                recipeViewModel.toggleFavorite(
                                    Recipe(id = summary.id.toString(), title = summary.title,
                                        description = "", imageUrl = summary.image),
                                    isFav
                                )
                            },
                            favoriteIds = favoriteIds
                        )
                    }

                    // Recipe Detail
                    composable(
                        route = Screen.RecipeDetail.route,
                        arguments = listOf(navArgument("recipeId") { type = NavType.StringType })
                    ) {
                        val recipeId = navController.currentBackStackEntry?.arguments?.getString("recipeId") ?: ""
                        RecipeDetailScreen(
                            recipeId = recipeId,
                            onNavigateBack = { navController.navigateUp() },
                            recipeViewModel = recipeViewModel,
                            authViewModel = authViewModel
                        )
                    }

                    // Add Recipe
                    composable(Screen.AddRecipe.route) {
                        AddRecipeScreen(
                            onNavigateBack = { navController.navigateUp() },
                            recipeViewModel = recipeViewModel
                        )
                    }

                    // Favorites
                    composable(Screen.Favorites.route) {
                        LaunchedEffect(Unit) { recipeViewModel.loadFavorites() }
                        val favResource by recipeViewModel.favorites.observeAsState()
                        FavoritesScreen(
                            onNavigate = { navController.navigate(it) { launchSingleTop = true; restoreState = true } },
                            favorites = favResource?.data ?: emptyList(),
                            onRecipeClick = { recipe ->
                                navController.navigate(Screen.RecipeDetail.createRoute(recipe.id))
                            }
                        )
                    }

                    // Profile
                    composable(Screen.Profile.route) {
                        ProfileScreen(
                            onNavigateBack = { navController.navigateUp() },
                            onNavigateToSettings = { navController.navigate(Screen.Settings.route) { launchSingleTop = true } },
                            onNavigateToCharts = { navController.navigate(Screen.Charts.route) { launchSingleTop = true } },
                            onNavigateToMap = { navController.navigate(Screen.Map.route) { launchSingleTop = true } },
                            user = currentUser
                        )
                    }

                    // Drawer screens
                    composable(Screen.Map.route) { MapScreen(onNavigateBack = { navController.navigateUp() }) }
                    composable(Screen.AIAssistant.route) { AIAssistantScreen(onNavigateBack = { navController.navigateUp() }) }
                    composable(Screen.Charts.route) { ChartsScreen(onNavigateBack = { navController.navigateUp() }) }
                    composable(Screen.Settings.route) { SettingsScreen(onNavigateBack = { navController.navigateUp() }) }
                }
            }
        }
    }
}
