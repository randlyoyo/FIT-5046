package edu.monash.fit5046.healthyrecipehub.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.RestaurantMenu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.ui.navigation.Screen
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary

sealed class DrawerItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : DrawerItem(Screen.Home.route, "Home", Icons.Default.Home)
    object Recipes : DrawerItem(Screen.Recipes.route, "Recipes", Icons.Default.RestaurantMenu)
    object Favorites : DrawerItem(Screen.Favorites.route, "Favorites", Icons.Default.Favorite)
    object Profile : DrawerItem(Screen.Profile.route, "Profile", Icons.Default.Person)
    object Map : DrawerItem(Screen.Map.route, "Map", Icons.Default.Map)
    object AIAssistant : DrawerItem(Screen.AIAssistant.route, "AI Assistant", Icons.Default.SmartToy)
    object Charts : DrawerItem(Screen.Charts.route, "Statistics", Icons.Default.BarChart)
    object Settings : DrawerItem(Screen.Settings.route, "Settings", Icons.Default.Settings)
    object Logout : DrawerItem("logout", "Logout", Icons.Default.Logout)
}

private val primaryDrawerItems = listOf(
    DrawerItem.Home,
    DrawerItem.Recipes,
    DrawerItem.Favorites,
    DrawerItem.Profile
)

private val secondaryDrawerItems = listOf(
    DrawerItem.Map,
    DrawerItem.AIAssistant,
    DrawerItem.Charts,
    DrawerItem.Settings
)

@Composable
fun DrawerContent(
    currentRoute: String,
    onNavigate: (String) -> Unit,
    onCloseDrawer: () -> Unit,
    userName: String = "User",
    userEmail: String = "user@example.com",
    isAdmin: Boolean = false
) {
    ModalDrawerSheet {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Healthy Recipe Hub", style = MaterialTheme.typography.headlineSmall,
                color = GreenPrimary, fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(8.dp))
            Text(userName, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurface)
            Text(userEmail, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
        }

        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(Modifier.height(8.dp))

        primaryDrawerItems.forEach { item ->
            NavigationDrawerItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    onNavigate(item.route)
                    onCloseDrawer()
                },
                modifier = Modifier.padding(horizontal = 12.dp),
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = GreenPrimary.copy(alpha = 0.1f),
                    selectedTextColor = GreenPrimary,
                    selectedIconColor = GreenPrimary
                )
            )
        }

        Divider(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))

        secondaryDrawerItems.forEach { item ->
            NavigationDrawerItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    onNavigate(item.route)
                    onCloseDrawer()
                },
                modifier = Modifier.padding(horizontal = 12.dp),
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = GreenPrimary.copy(alpha = 0.1f),
                    selectedTextColor = GreenPrimary,
                    selectedIconColor = GreenPrimary
                )
            )
        }

        Divider(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))

        NavigationDrawerItem(
            icon = { Icon(DrawerItem.Logout.icon, contentDescription = DrawerItem.Logout.title) },
            label = { Text(DrawerItem.Logout.title) },
            selected = false,
            onClick = {
                onNavigate(DrawerItem.Logout.route)
                onCloseDrawer()
            },
            modifier = Modifier.padding(horizontal = 12.dp),
            colors = NavigationDrawerItemDefaults.colors(
                selectedContainerColor = GreenPrimary.copy(alpha = 0.1f),
                selectedTextColor = GreenPrimary,
                selectedIconColor = GreenPrimary
            )
        )
    }
}
