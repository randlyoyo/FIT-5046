package edu.monash.fit5046.healthyrecipehub.ui.screens.map

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import com.mapbox.geojson.Point
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapInitOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.ResourceOptions
import com.mapbox.maps.Style
import edu.monash.fit5046.healthyrecipehub.R
import edu.monash.fit5046.healthyrecipehub.data.model.Store
import edu.monash.fit5046.healthyrecipehub.data.model.StoreType
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt

private const val MelbourneLongitude = 144.9631
private const val MelbourneLatitude = -37.8136
private const val MelbourneZoom = 12.0
private const val StoreFocusZoom = 14.0
private const val UserLocationZoom = 13.5
private const val EarthRadiusKm = 6371.0

private val fallbackUserPoint = Point.fromLngLat(MelbourneLongitude, MelbourneLatitude)

private data class NearbyStore(
    val store: Store,
    val distanceKm: Double
)

private val healthyStores = listOf(
    Store(
        id = "qvm",
        name = "Queen Victoria Market",
        address = "Queen St, Melbourne VIC 3000",
        latitude = -37.8076,
        longitude = 144.9568,
        rating = 4.6f,
        openingHours = "Market hours vary",
        storeType = StoreType.FARMERS_MARKET,
        isOrganic = true,
        isVeganFriendly = true
    ),
    Store(
        id = "terra-madre",
        name = "Terra Madre Northcote",
        address = "105 High St, Northcote VIC 3070",
        latitude = -37.7722,
        longitude = 144.9964,
        rating = 4.7f,
        openingHours = "Open until 7:00 PM",
        storeType = StoreType.ORGANIC,
        isOrganic = true,
        isVeganFriendly = true,
        isGlutenFree = true
    ),
    Store(
        id = "smm",
        name = "South Melbourne Market",
        address = "322-326 Coventry St, South Melbourne VIC 3205",
        latitude = -37.8311,
        longitude = 144.9604,
        rating = 4.5f,
        openingHours = "Open until 4:00 PM",
        storeType = StoreType.FARMERS_MARKET,
        isOrganic = true,
        isVeganFriendly = true
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen(
    onNavigateBack: () -> Unit,
    onOpenDrawer: () -> Unit = {}
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val accessToken = stringResource(R.string.mapbox_access_token)
    var selectedStoreId by remember { mutableStateOf<String?>(null) }
    var userPoint by remember { mutableStateOf(fallbackUserPoint) }
    var locationMessage by remember {
        mutableStateOf<String?>(
            "Location permission is needed to recommend nearby healthy stores. Showing Melbourne CBD as default."
        )
    }

    val mapView = remember(accessToken) {
        val resourceOptions = ResourceOptions.Builder()
            .accessToken(accessToken)
            .build()

        MapView(
            context,
            MapInitOptions(
                context = context,
                resourceOptions = resourceOptions
            )
        ).apply {
            getMapboxMap().setCamera(
                CameraOptions.Builder()
                    .center(fallbackUserPoint)
                    .zoom(MelbourneZoom)
                    .build()
            )
            getMapboxMap().loadStyleUri(Style.MAPBOX_STREETS)
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        val granted = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
            permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true

        if (granted) {
            val currentLocation = getBestLastKnownLocation(context)
            if (currentLocation != null) {
                val currentPoint = Point.fromLngLat(currentLocation.longitude, currentLocation.latitude)
                userPoint = currentPoint
                locationMessage = null
                moveCamera(mapView, currentPoint, UserLocationZoom)
            } else {
                userPoint = fallbackUserPoint
                locationMessage =
                    "Location permission is needed to recommend nearby healthy stores. Showing Melbourne CBD as default."
                moveCamera(mapView, fallbackUserPoint, MelbourneZoom)
            }
        } else {
            userPoint = fallbackUserPoint
            locationMessage =
                "Location permission is needed to recommend nearby healthy stores. Showing Melbourne CBD as default."
            moveCamera(mapView, fallbackUserPoint, MelbourneZoom)
        }
    }

    LaunchedEffect(Unit) {
        if (hasLocationPermission(context)) {
            val currentLocation = getBestLastKnownLocation(context)
            if (currentLocation != null) {
                val currentPoint = Point.fromLngLat(currentLocation.longitude, currentLocation.latitude)
                userPoint = currentPoint
                locationMessage = null
                moveCamera(mapView, currentPoint, UserLocationZoom)
            } else {
                userPoint = fallbackUserPoint
                locationMessage =
                    "Location permission is needed to recommend nearby healthy stores. Showing Melbourne CBD as default."
                moveCamera(mapView, fallbackUserPoint, MelbourneZoom)
            }
        } else {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
    }

    DisposableEffect(lifecycleOwner, mapView) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                else -> Unit
            }
        }

        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
            mapView.onStop()
            mapView.onDestroy()
        }
    }

    val nearbyStores = remember(userPoint) {
        healthyStores
            .map { store ->
                NearbyStore(
                    store = store,
                    distanceKm = haversineDistanceKm(
                        latitude1 = userPoint.latitude(),
                        longitude1 = userPoint.longitude(),
                        latitude2 = store.latitude,
                        longitude2 = store.longitude
                    )
                )
            }
            .sortedBy { it.distanceKm }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Map") },
                navigationIcon = {
                    IconButton(onClick = onOpenDrawer) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu")
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
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Healthy stores around you",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Mapbox map recenters to your location when permission is available, otherwise Melbourne CBD stays as the prototype default.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.82f)
                    )
                }
            }

            locationMessage?.let { message ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = message,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                }
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                AndroidView(
                    factory = { mapView },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                )
            }

            Text(
                text = "Nearby healthy stores",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )

            nearbyStores.forEach { nearbyStore ->
                StoreCard(
                    nearbyStore = nearbyStore,
                    isSelected = selectedStoreId == nearbyStore.store.id,
                    onClick = {
                        selectedStoreId = nearbyStore.store.id
                        moveCamera(
                            mapView = mapView,
                            point = Point.fromLngLat(
                                nearbyStore.store.longitude,
                                nearbyStore.store.latitude
                            ),
                            zoom = StoreFocusZoom
                        )
                    }
                )
            }
        }
    }
}

private fun hasLocationPermission(context: Context): Boolean {
    val fineLocationGranted = ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
    val coarseLocationGranted = ContextCompat.checkSelfPermission(
        context,
        Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED
    return fineLocationGranted || coarseLocationGranted
}

private fun getBestLastKnownLocation(context: Context): Location? {
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as? LocationManager ?: return null
    if (!hasLocationPermission(context)) return null

    val providers = listOf(
        LocationManager.GPS_PROVIDER,
        LocationManager.NETWORK_PROVIDER,
        LocationManager.PASSIVE_PROVIDER
    )

    return providers
        .filter { provider -> locationManager.isProviderEnabled(provider) }
        .mapNotNull { provider ->
            runCatching { locationManager.getLastKnownLocation(provider) }.getOrNull()
        }
        .minByOrNull { location -> location.accuracy }
}

private fun moveCamera(
    mapView: MapView,
    point: Point,
    zoom: Double
) {
    mapView.getMapboxMap().setCamera(
        CameraOptions.Builder()
            .center(point)
            .zoom(zoom)
            .build(),
    )
}

private fun haversineDistanceKm(
    latitude1: Double,
    longitude1: Double,
    latitude2: Double,
    longitude2: Double
): Double {
    val latitudeDistance = Math.toRadians(latitude2 - latitude1)
    val longitudeDistance = Math.toRadians(longitude2 - longitude1)
    val startLatitude = Math.toRadians(latitude1)
    val endLatitude = Math.toRadians(latitude2)

    val haversine = sin(latitudeDistance / 2).pow(2) +
        cos(startLatitude) * cos(endLatitude) * sin(longitudeDistance / 2).pow(2)
    val angularDistance = 2 * atan2(sqrt(haversine), sqrt(1 - haversine))
    return EarthRadiusKm * angularDistance
}

@Composable
private fun StoreTag(label: String) {
    Box(
        modifier = Modifier
            .background(GreenPrimary.copy(alpha = 0.12f), RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 8.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = GreenPrimary,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun StoreCard(
    nearbyStore: NearbyStore,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val store = nearbyStore.store

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(
                if (isSelected) {
                    Modifier.border(
                        width = 2.dp,
                        color = GreenPrimary,
                        shape = RoundedCornerShape(12.dp)
                    )
                } else {
                    Modifier
                }
            )
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 5.dp else 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    modifier = Modifier.weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
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
                        Text(
                            text = store.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = store.address,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.72f)
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

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Navigation, contentDescription = null, tint = Color(0xFF4F6BED))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "${String.format("%.1f", nearbyStore.distanceKm)} km away",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF4F6BED)
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.LocationOn, contentDescription = null, tint = GreenPrimary)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = store.openingHours ?: "Hours unavailable",
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (store.isOrganic) StoreTag("Organic")
                if (store.isVeganFriendly) StoreTag("Vegan-friendly")
                if (store.isGlutenFree) StoreTag("Gluten-free")
            }
        }
    }
}
