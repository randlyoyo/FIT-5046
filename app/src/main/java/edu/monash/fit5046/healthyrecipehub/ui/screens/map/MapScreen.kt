package edu.monash.fit5046.healthyrecipehub.ui.screens.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.data.model.Store
import edu.monash.fit5046.healthyrecipehub.data.model.StoreType
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary

private val mockStores = listOf(
    Store(
        id = "1",
        name = "Monash Wholefoods Market",
        address = "Campus Centre, Clayton",
        latitude = -37.911,
        longitude = 145.134,
        rating = 4.7f,
        openingHours = "Open until 8:00 PM",
        storeType = StoreType.HEALTH_FOOD,
        isOrganic = true,
        isVeganFriendly = true
    ),
    Store(
        id = "2",
        name = "Green Basket Organics",
        address = "210 Blackburn Rd, Glen Waverley",
        latitude = -37.904,
        longitude = 145.166,
        rating = 4.5f,
        openingHours = "Open until 7:30 PM",
        storeType = StoreType.ORGANIC,
        isOrganic = true,
        isGlutenFree = true
    ),
    Store(
        id = "3",
        name = "Protein Pantry",
        address = "31 Kingsway, Mount Waverley",
        latitude = -37.877,
        longitude = 145.129,
        rating = 4.4f,
        openingHours = "Open until 9:00 PM",
        storeType = StoreType.SUPPLEMENT_STORE,
        isVeganFriendly = true
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Map") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Healthy shopping nearby",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Mock store data is shown until live map search and geolocation are connected.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                    )
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        TagPill("Organic")
                        TagPill("Vegan-friendly")
                        TagPill("Open now")
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(Color(0xFFDDEEDB), Color(0xFFF8F2D6))
                        ),
                        shape = RoundedCornerShape(24.dp)
                    )
                    .padding(18.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.Default.LocationOn, contentDescription = null, tint = GreenPrimary)
                        Text(
                            text = "Clayton campus search area",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Text(
                        text = "Map preview placeholder for the FIT5046 prototype. Store pins, route overlays, and current location can be added later without changing the layout.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.78f)
                    )
                    Row(
                        modifier = Modifier.horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        MapStatCard("3", "Nearby picks")
                        MapStatCard("12m", "Closest walk")
                        MapStatCard("4.5", "Avg rating")
                    }
                }
            }

            Text(
                text = "Suggested stores",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            mockStores.forEach { store ->
                StoreCard(store)
            }
        }
    }
}

@Composable
private fun TagPill(label: String) {
    Box(
        modifier = Modifier
            .background(GreenPrimary.copy(alpha = 0.12f), RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(text = label, style = MaterialTheme.typography.bodySmall, color = GreenPrimary)
    }
}

@Composable
private fun MapStatCard(value: String, label: String) {
    Card(colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.88f))) {
        Column(modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)) {
            Text(text = value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Text(text = label, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
private fun StoreCard(store: Store) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .background(GreenPrimary.copy(alpha = 0.14f), RoundedCornerShape(14.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Storefront, contentDescription = null, tint = GreenPrimary)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(text = store.name, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                        Text(
                            text = store.address,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                    }
                }
                Text(
                    text = "${store.rating ?: 0f}*",
                    style = MaterialTheme.typography.titleSmall,
                    color = OrangeSecondary,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = store.openingHours ?: "Hours unavailable",
                style = MaterialTheme.typography.bodyMedium
            )

            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                if (store.isOrganic) TagPill("Organic")
                if (store.isVeganFriendly) TagPill("Vegan")
                if (store.isGlutenFree) TagPill("Gluten-free")
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Navigation, contentDescription = null, tint = Color(0xFF4F6BED))
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Prototype route preview available",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF4F6BED)
                )
            }
        }
    }
}
