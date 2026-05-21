package edu.monash.fit5046.healthyrecipehub.ui.screens.charts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Insights
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.TrackChanges
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.BarChartData
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.NutritionPieChart
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.PieChartData
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.SimpleBarChart
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChartsScreen(
    onNavigateBack: () -> Unit
) {
    val nutritionData = listOf(
        PieChartData("Protein", 92f, GreenPrimary),
        PieChartData("Carbs", 165f, OrangeSecondary),
        PieChartData("Fat", 58f, Color(0xFFE57373)),
        PieChartData("Fiber", 24f, Color(0xFF4F6BED))
    )

    val weeklyCalories = listOf(
        BarChartData("Mon", 1860f, GreenPrimary),
        BarChartData("Tue", 2010f, GreenPrimary),
        BarChartData("Wed", 1740f, OrangeSecondary),
        BarChartData("Thu", 2125f, GreenPrimary),
        BarChartData("Fri", 1980f, GreenPrimary),
        BarChartData("Sat", 2230f, OrangeSecondary),
        BarChartData("Sun", 1910f, GreenPrimary)
    )

    val comparisonData = listOf(
        BarChartData("Your Avg", 1980f, GreenPrimary),
        BarChartData("Goal", 2100f, Color(0xFF4F6BED)),
        BarChartData("Prototype Avg", 1870f, OrangeSecondary)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Charts") },
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                SummaryCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.LocalFireDepartment,
                    value = "13,855",
                    label = "Weekly kcal",
                    accent = OrangeSecondary
                )
                SummaryCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.TrackChanges,
                    value = "94%",
                    label = "Goal match",
                    accent = GreenPrimary
                )
                SummaryCard(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.Insights,
                    value = "24g",
                    label = "Avg fiber",
                    accent = Color(0xFF4F6BED)
                )
            }

            NutritionPieChart(
                data = nutritionData,
                title = "Macronutrient distribution"
            )

            DailyCalorieBarChart(
                data = weeklyCalories,
                title = "Daily calorie intake",
                maxValue = 2400f
            )

            SimpleBarChart(
                data = comparisonData,
                title = "Target comparison",
                maxValue = 2400f
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = "Prototype insights",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Protein intake is consistent across the week and stays close to the current goal.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Saturday runs higher on calories, which creates useful visual contrast in the weekly graph.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Fiber remains the easiest improvement area for the next recommendation iteration.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun DailyCalorieBarChart(
    data: List<BarChartData>,
    title: String,
    maxValue: Float
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                data.forEach { item ->
                    DailyCalorieBarItem(
                        data = item,
                        maxValue = maxValue,
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "0",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
                Text(
                    text = "${maxValue.toInt()}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Composable
private fun DailyCalorieBarItem(
    data: BarChartData,
    maxValue: Float,
    modifier: Modifier = Modifier
) {
    val heightFraction = if (maxValue > 0f) (data.value / maxValue).coerceIn(0f, 1f) else 0f

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "${data.value.toInt()}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(6.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Gray.copy(alpha = 0.3f))
                    .align(Alignment.BottomCenter)
            )

            Box(
                modifier = Modifier
                    .width(24.dp)
                    .fillMaxHeight(heightFraction)
                    .background(
                        color = data.color,
                        shape = RoundedCornerShape(topStart = 6.dp, topEnd = 6.dp)
                    )
                    .align(Alignment.BottomCenter)
            )
        }

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = data.label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun SummaryCard(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    value: String,
    label: String,
    accent: Color
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Icon(icon, contentDescription = null, tint = accent)
            Text(text = value, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}
