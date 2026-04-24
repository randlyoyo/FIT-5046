package edu.monash.fit5046.healthyrecipehub.ui.components.charts

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary

data class BarChartData(
    val label: String,
    val value: Float,
    val color: Color = GreenPrimary
)

@Composable
fun SimpleBarChart(
    data: List<BarChartData>,
    modifier: Modifier = Modifier,
    title: String = "Calorie Comparison",
    maxValue: Float? = null
) {
    val max = maxValue ?: (data.maxOfOrNull { it.value } ?: 1f)
    
    Card(
        modifier = modifier.fillMaxWidth(),
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
            
            // Bar Chart
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ) {
                data.forEach { item ->
                    BarItem(
                        label = item.label,
                        value = item.value,
                        maxValue = max,
                        color = item.color
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Scale indicator
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
                    text = "${max.toInt()}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Composable
private fun BarItem(
    label: String,
    value: Float,
    maxValue: Float,
    color: Color
) {
    val heightFraction = if (maxValue > 0) value / maxValue else 0f
    
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.width(60.dp)
    ) {
        Text(
            text = "${value.toInt()}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        // Bar
        Canvas(
            modifier = Modifier
                .width(40.dp)
                .height(150.dp)
        ) {
            val barHeight = size.height * heightFraction
            
            // Draw bar
            drawRect(
                color = color,
                topLeft = Offset(
                    (size.width - 40.dp.toPx()) / 2,
                    size.height - barHeight
                ),
                size = Size(40.dp.toPx(), barHeight)
            )
            
            // Draw baseline
            drawLine(
                color = Color.Gray.copy(alpha = 0.3f),
                start = Offset(0f, size.height),
                end = Offset(size.width, size.height),
                strokeWidth = 1.dp.toPx()
            )
        }
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )
    }
}

// Sample data
fun getSampleCalorieData(): List<BarChartData> {
    return listOf(
        BarChartData("Mon", 450f, GreenPrimary),
        BarChartData("Tue", 520f, GreenPrimary),
        BarChartData("Wed", 380f, OrangeSecondary),
        BarChartData("Thu", 600f, GreenPrimary),
        BarChartData("Fri", 420f, GreenPrimary),
        BarChartData("Sat", 550f, OrangeSecondary),
        BarChartData("Sun", 480f, GreenPrimary)
    )
}

// Nutrition comparison data
fun getNutritionComparisonData(): List<BarChartData> {
    return listOf(
        BarChartData("Avg Recipe", 350f, GreenPrimary),
        BarChartData("Your Avg", 420f, OrangeSecondary),
        BarChartData("Healthy Target", 300f, Color.Blue.copy(alpha = 0.7f))
    )
}
