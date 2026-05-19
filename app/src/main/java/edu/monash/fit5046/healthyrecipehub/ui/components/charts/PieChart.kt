package edu.monash.fit5046.healthyrecipehub.ui.components.charts

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import edu.monash.fit5046.healthyrecipehub.ui.theme.GreenPrimary
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary
import kotlin.math.min

data class PieChartData(
    val label: String,
    val value: Float,
    val color: Color
)

@Composable
fun NutritionPieChart(
    data: List<PieChartData>,
    modifier: Modifier = Modifier,
    title: String = "Nutrition Distribution"
) {
    val total = data.sumOf { it.value.toDouble() }.toFloat()
    
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
            
            // Pie Chart Canvas
            Canvas(
                modifier = Modifier.size(200.dp)
            ) {
                val canvasWidth = size.width
                val canvasHeight = size.height
                val radius = min(canvasWidth, canvasHeight) / 2 * 0.8f
                val centerX = canvasWidth / 2
                val centerY = canvasHeight / 2
                
                var startAngle = -90f // Start from top
                
                data.forEach { item ->
                    val sweepAngle = if (total > 0) {
                        (item.value / total) * 360f
                    } else 0f
                    
                    // Draw slice
                    drawArc(
                        color = item.color,
                        startAngle = startAngle,
                        sweepAngle = sweepAngle,
                        useCenter = true,
                        topLeft = Offset(
                            centerX - radius,
                            centerY - radius
                        ),
                        size = Size(radius * 2, radius * 2)
                    )
                    
                    startAngle += sweepAngle
                }
                
                // Draw center hole for donut effect
                drawCircle(
                    color = Color.White,
                    radius = radius * 0.4f,
                    center = Offset(centerX, centerY)
                )
                
                // Draw total text in center
                // Note: Can't easily draw text in Canvas without TextMeasurer in older Compose versions
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Legend
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                data.forEach { item ->
                    LegendItem(
                        color = item.color,
                        label = item.label,
                        value = "${item.value.toInt()}g"
                    )
                }
            }
        }
    }
}

@Composable
private fun LegendItem(
    color: Color,
    label: String,
    value: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Canvas(
            modifier = Modifier
                .size(16.dp)
                .clip(CircleShape)
        ) {
            drawCircle(color = color)
        }
        
        Text(
            text = label,
            modifier = Modifier
                .weight(1f)
                .padding(start = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
        
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

// Preview sample data
fun getSampleNutritionData(): List<PieChartData> {
    return listOf(
        PieChartData("Protein", 25f, GreenPrimary),
        PieChartData("Carbs", 45f, OrangeSecondary),
        PieChartData("Fat", 20f, Color.Red.copy(alpha = 0.7f)),
        PieChartData("Fiber", 10f, Color.Blue.copy(alpha = 0.7f))
    )
}
