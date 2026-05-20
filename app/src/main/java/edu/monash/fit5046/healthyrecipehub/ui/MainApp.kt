package edu.monash.fit5046.healthyrecipehub.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.monash.fit5046.healthyrecipehub.ui.components.BottomNavBar
import edu.monash.fit5046.healthyrecipehub.ui.components.DrawerContent
import edu.monash.fit5046.healthyrecipehub.ui.navigation.Screen
import edu.monash.fit5046.healthyrecipehub.ui.screens.addrecipe.AddRecipeScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.ai.AIAssistantScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.charts.ChartsScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.email.EmailScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.favorites.FavoritesScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.home.HomeScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.map.MapScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.profile.ProfileScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.recipes.RecipesScreen
import edu.monash.fit5046.healthyrecipehub.ui.screens.settings.SettingsScreen
import edu.monash.fit5046.healthyrecipehub.ui.theme.HealthyRecipeHubTheme
import edu.monash.fit5046.healthyrecipehub.data.model.Resource
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
    
    val authState by authViewModel.authState.collectAsState()
    val currentUser by authViewModel.currentUser.collectAsState()
    
    val userName = currentUser?.displayName ?: "User"
    val userEmail = currentUser?.email ?: "user@example.com"
    
    // Check if bottom nav should be shown
    val showBottomNav = currentRoute in listOf(
        Screen.Home.route,
        Screen.Recipes.route,
        Screen.AddRecipe.route,
        Screen.Favorites.route,
        Screen.Profile.route
    )
    
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
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    },
                    onCloseDrawer = {
                        scope.launch { drawerState.close() }
                    },
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
                                    // Pop up to avoid back stack buildup
                                    popUpTo(navController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            ) { paddingValues ->
                NavHost(
                    navController = navController,
                    startDestination = Screen.Home.route,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    composable(Screen.Home.route) {
                        HomeScreen(
                            onNavigate = { route ->
                                navController.navigate(route) {
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            onOpenDrawer = {
                                scope.launch { drawerState.open() }
                            },
                            userName = userName
                        )
                    }
                    
                    composable(Screen.Recipes.route) {
                        val recipesResource by recipeViewModel.recipes.observeAsState()
                        RecipesScreen(
                            onNavigate = { route ->
                                navController.navigate(route) {
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            onOpenDrawer = {
                                scope.launch { drawerState.open() }
                            },
                            recipes = recipesResource?.data ?: emptyList()
                        )
                    }
                    
                    composable(Screen.AddRecipe.route) {
                        AddRecipeScreen(
                            onNavigateBack = {
                                navController.navigateUp()
                            },
                            onOpenDrawer = {
                                scope.launch { drawerState.open() }
                            }
                        )
                    }
                    
                    composable(Screen.Favorites.route) {
                        val favoritesResource by recipeViewModel.favorites.observeAsState()
                        FavoritesScreen(
                            onOpenDrawer = {
                                scope.launch { drawerState.open() }
                            },
                            favorites = favoritesResource?.data ?: emptyList()
                        )
                    }
                    
                    composable(Screen.Profile.route) {
                        ProfileScreen(
                            onNavigateBack = { navController.navigateUp() },
                            user = currentUser,
                            onOpenDrawer = {
                                scope.launch { drawerState.open() }
                            }
                        )
                    }
                    
                    // Drawer screens
                    composable(Screen.Map.route) {
                        MapScreen(onNavigateBack = { navController.navigateUp() })
                    }
                    
                    composable(Screen.AIAssistant.route) {
                        AIAssistantScreen(onNavigateBack = { navController.navigateUp() })
                    }
                    
                    composable(Screen.Charts.route) {
                        ChartsScreen(onNavigateBack = { navController.navigateUp() })
                    }
                    
                    composable(Screen.Email.route) {
                        EmailScreen(onNavigateBack = { navController.navigateUp() })
                    }
                    
                    composable(Screen.Settings.route) {
                        SettingsScreen(onNavigateBack = { navController.navigateUp() })
                    }
                }
            }
        }
    }
}
