package edu.monash.fit5046.healthyrecipehub.ui.screens.charts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.NutritionPieChart
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.PieChartData
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.SimpleBarChart
import edu.monash.fit5046.healthyrecipehub.ui.components.charts.BarChartData
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChartsScreen(
    onNavigateBack: () -> Unit
) {
    // Sample nutrition data
    val nutritionData = listOf(
        PieChartData("Protein", 25f, GreenPrimary),
        PieChartData("Carbs", 45f, OrangeSecondary),
        PieChartData("Fat", 20f, Color.Red.copy(alpha = 0.7f)),
        PieChartData("Fiber", 10f, Color.Blue.copy(alpha = 0.7f))
    )
    
    // Sample calorie data for the week
    val calorieData = listOf(
        BarChartData("Mon", 450f, GreenPrimary),
        BarChartData("Tue", 520f, GreenPrimary),
        BarChartData("Wed", 380f, OrangeSecondary),
        BarChartData("Thu", 600f, GreenPrimary),
        BarChartData("Fri", 420f, GreenPrimary),
        BarChartData("Sat", 550f, OrangeSecondary),
        BarChartData("Sun", 480f, GreenPrimary)
    )
    
    // Nutrition comparison
    val comparisonData = listOf(
        BarChartData("Avg Recipe", 350f, GreenPrimary),
        BarChartData("Your Avg", 420f, OrangeSecondary),
        BarChartData("Target", 300f, Color.Blue.copy(alpha = 0.7f))
    )
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nutrition Statistics") },
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
            // Summary Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Weekly Summary",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        SummaryItem("3,400", "Total kcal")
                        SummaryItem("485", "Daily Avg")
                        SummaryItem("12", "Recipes")
                    }
                }
            }
            
            // Nutrition Pie Chart
            NutritionPieChart(
                data = nutritionData,
                title = "Macronutrient Distribution"
            )
            
            // Weekly Calories Bar Chart
            SimpleBarChart(
                data = calorieData,
                title = "Daily Calorie Intake",
                maxValue = 700f
            )
            
            // Comparison Chart
            SimpleBarChart(
                data = comparisonData,
                title = "Nutrition Comparison (per meal)",
                maxValue = 500f
            )
            
            // Insights Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Health Insights",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    InsightItem("✅ Good protein intake (25%)")
                    InsightItem("⚠️ Carbs slightly high (45%)")
                    InsightItem("✅ Fat within healthy range")
                    InsightItem("💡 Try to increase fiber intake")
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun SummaryItem(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = GreenPrimary
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
    }
}

@Composable
private fun InsightItem(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(vertical = 4.dp)
    )
}
