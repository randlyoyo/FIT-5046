package edu.monash.fit5046.healthyrecipehub.ui.screens.charts

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.data.model.Recipe
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.PieChartData
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.NutritionPieChart
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.BarChartData
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.SimpleBarChart
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChartsScreen(
    onNavigateBack: () -> Unit,
    onOpenDrawer: () -> Unit = {},
    favorites: List<Recipe> = emptyList()
) {
    // Analyze favorites data dynamically
    val favCount = favorites.size
    val totalCal = favorites.sumOf { it.calories }
    val avgCal = if (favCount > 0) totalCal / favCount else 0

    val totalProtein = favorites.sumOf { it.protein }
    val totalCarbs = favorites.sumOf { it.carbs }
    val totalFat = favorites.sumOf { it.fat }
    val avgProtein = if (favCount > 0) (totalProtein / favCount) else 0.0
    val avgCarbs = if (favCount > 0) (totalCarbs / favCount) else 0.0
    val avgFat = if (favCount > 0) (totalFat / favCount) else 0.0
    val avgProteinInt = avgProtein.toInt()
    val avgCarbsInt = avgCarbs.toInt()
    val avgFatInt = avgFat.toInt()

    // Difficulty distribution
    val easyCount = favorites.count { it.difficulty == "Easy" }
    val mediumCount = favorites.count { it.difficulty == "Medium" }
    val hardCount = favorites.count { it.difficulty == "Hard" }

    // Category distribution
    val categoryCounts = favorites.groupBy { it.category }.mapValues { it.value.size }

    val hasData = favCount > 0

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Favorites Analysis", fontWeight = FontWeight.Bold) },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") } },
                actions = { IconButton(onClick = onOpenDrawer) { Icon(Icons.Default.Menu, "Menu") } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primary, titleContentColor = MaterialTheme.colorScheme.onPrimary, navigationIconContentColor = MaterialTheme.colorScheme.onPrimary)
            )
        }
    ) { paddingValues ->
        Column(
            Modifier.fillMaxSize().padding(paddingValues).verticalScroll(rememberScrollState()).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            if (!hasData) {
                Box(Modifier.fillMaxSize().height(300.dp), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(Icons.Default.FavoriteBorder, null, tint = Color.Gray, modifier = Modifier.size(64.dp))
                        Spacer(Modifier.height(16.dp))
                        Text("No favorites yet", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
                        Text("Save some recipes to see your nutrition analysis", color = Color.Gray)
                    }
                }
            } else {
                // Summary cards
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    SummaryCard(Modifier.weight(1f), Icons.Default.Favorite, "$favCount", "Saved", OrangeSecondary)
                    SummaryCard(Modifier.weight(1f), Icons.Default.LocalFireDepartment, "$avgCal", "Avg kcal", GreenPrimary)
                    SummaryCard(Modifier.weight(1f), Icons.Default.Insights, "${avgProteinInt + avgCarbsInt + avgFatInt}g", "Avg total", Color(0xFF4F6BED))
                }

                // Nutrition Pie Chart (from favorites data)
                if (avgProteinInt + avgCarbsInt + avgFatInt > 0) {
                    NutritionPieChart(
                        data = listOf(
                            PieChartData("Protein", avgProteinInt.toFloat(), GreenPrimary),
                            PieChartData("Carbs", avgCarbsInt.toFloat(), OrangeSecondary),
                            PieChartData("Fat", avgFatInt.toFloat(), Color(0xFFE57373))
                        ),
                        title = "Average nutrition per favorite recipe"
                    )
                }

                // Difficulty bar chart
                SimpleBarChart(
                    data = listOf(
                        BarChartData("Easy", easyCount.toFloat(), GreenPrimary),
                        BarChartData("Medium", mediumCount.toFloat(), OrangeSecondary),
                        BarChartData("Hard", hardCount.toFloat(), Color(0xFFE57373))
                    ),
                    title = "Difficulty distribution",
                    maxValue = maxOf(easyCount, mediumCount, hardCount, 1).toFloat()
                )

                // Category distribution
                if (categoryCounts.isNotEmpty()) {
                    Card(Modifier.fillMaxWidth(), elevation = CardDefaults.cardElevation(2.dp)) {
                        Column(Modifier.padding(16.dp)) {
                            Text("Categories", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                            Spacer(Modifier.height(8.dp))
                            categoryCounts.forEach { (cat, count) ->
                                Row(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                                    Text(cat.ifEmpty { "General" }, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f))
                                    Text("$count", style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Bold, color = GreenPrimary)
                                }
                            }
                        }
                    }
                }

                // Calorie bar chart by category
                val calByCat = favorites.groupBy { it.category }.mapValues { entry ->
                    entry.value.sumOf { it.calories } / entry.value.size
                }
                if (calByCat.isNotEmpty()) {
                    SimpleBarChart(
                        data = calByCat.entries.take(5).map { (cat, cal) ->
                            BarChartData(cat.take(8), cal.toFloat(), GreenPrimary)
                        },
                        title = "Avg calories per category",
                        maxValue = calByCat.values.max().toFloat()
                    )
                }
            }
        }
    }
}

@Composable
private fun SummaryCard(modifier: Modifier, icon: androidx.compose.ui.graphics.vector.ImageVector, value: String, label: String, accent: Color) {
    Card(modifier = modifier, elevation = CardDefaults.cardElevation(2.dp)) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(icon, null, tint = accent, modifier = Modifier.size(24.dp))
            Text(value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(label, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
    }
}
