package edu.monash.fit5046.healthyrecipehub.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.filled.Map
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
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary

sealed class DrawerItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Map : DrawerItem("map", "Map", Icons.Default.Map)
    object AIAssistant : DrawerItem("ai_assistant", "AI Assistant", Icons.Default.SmartToy)
    object Charts : DrawerItem("charts", "Statistics", Icons.Default.BarChart)
    object Email : DrawerItem("email", "Email Center", Icons.Default.Email)
    object Settings : DrawerItem("settings", "Settings", Icons.Default.Settings)
    object Admin : DrawerItem("admin", "Admin Panel", Icons.Default.AdminPanelSettings)
    object Logout : DrawerItem("logout", "Logout", Icons.Default.Logout)
}

val mainDrawerItems = listOf(
    DrawerItem.Map,
    DrawerItem.AIAssistant
)

val toolsDrawerItems = listOf(
    DrawerItem.Charts,
    DrawerItem.Email
)

val accountDrawerItems = listOf(
    DrawerItem.Settings,
    DrawerItem.Logout
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
        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Healthy Recipe Hub",
                style = MaterialTheme.typography.headlineSmall,
                color = GreenPrimary,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = userName,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = userEmail,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
        
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        
        // Main section
        Text(
            text = "Main",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 8.dp)
        )
        
        mainDrawerItems.forEach { item ->
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
        
        Spacer(modifier = Modifier.height(8.dp))
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        
        // Tools section
        Text(
            text = "Tools",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 8.dp)
        )
        
        toolsDrawerItems.forEach { item ->
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
        
        // Admin section (conditional)
        if (isAdmin) {
            Spacer(modifier = Modifier.height(8.dp))
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "Admin",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(horizontal = 28.dp, vertical = 8.dp)
            )
            
            NavigationDrawerItem(
                icon = { Icon(DrawerItem.Admin.icon, contentDescription = DrawerItem.Admin.title) },
                label = { Text(DrawerItem.Admin.title) },
                selected = currentRoute == DrawerItem.Admin.route,
                onClick = {
                    onNavigate(DrawerItem.Admin.route)
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
        
        Spacer(modifier = Modifier.height(8.dp))
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        Spacer(modifier = Modifier.height(8.dp))
        
        // Account section
        Text(
            text = "Account",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            modifier = Modifier.padding(horizontal = 28.dp, vertical = 8.dp)
        )
        
        accountDrawerItems.forEach { item ->
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
    }
}
