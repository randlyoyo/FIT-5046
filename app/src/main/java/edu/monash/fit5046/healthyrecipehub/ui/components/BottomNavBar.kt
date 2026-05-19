package edu.monash.fit5046.healthyrecipehub.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomNavItem("home", "Home", Icons.Default.Home)
    object Recipes : BottomNavItem("recipes", "Recipes", Icons.Default.RestaurantMenu)
    object Add : BottomNavItem("add_recipe", "Add", Icons.Default.Add)
    object Favorites : BottomNavItem("favorites", "Favorites", Icons.Default.Favorite)
    object Profile : BottomNavItem("profile", "Profile", Icons.Default.Person)
}

val bottomNavItems = listOf(
    BottomNavItem.Home,
    BottomNavItem.Recipes,
    BottomNavItem.Add,
    BottomNavItem.Favorites,
    BottomNavItem.Profile
)

@Composable
fun BottomNavBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.primary
    ) {
        bottomNavItems.forEach { item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                icon = { 
                    Icon(
                        imageVector = item.icon, 
                        contentDescription = item.title,
                        tint = if (selected) GreenPrimary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    ) 
                },
                label = { 
                    Text(
                        text = item.title,
                        color = if (selected) GreenPrimary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    ) 
                },
                selected = selected,
                onClick = { onNavigate(item.route) },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = GreenPrimary.copy(alpha = 0.1f)
                )
            )
        }
    }
}
