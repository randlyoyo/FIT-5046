package edu.monash.fit5046.healthyrecipehub.ui.screens.ai

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Image
import androidx.compose.material.icons.filled.SmartToy
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizer
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import edu.monash.fit5046.healthyrecipehub.ui.theme.OrangeSecondary
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

private data class RecipeDraftPreview(
    val title: String,
    val ingredients: List<String>,
    val instructions: List<String>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AIAssistantScreen(
    onNavigateBack: () -> Unit,
    onOpenDrawer: () -> Unit = {}
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val recognizer = remember { TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS) }

    DisposableEffect(recognizer) {
        onDispose { recognizer.close() }
    }

    var prompt by remember { mutableStateOf("Extract recipe text from an image and prepare a draft.") }
    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }
    var selectedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var extractedText by remember { mutableStateOf("") }
    var recipeDraft by remember { mutableStateOf<RecipeDraftPreview?>(null) }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    var infoMessage by remember { mutableStateOf<String?>(null) }
    var isRecognizing by remember { mutableStateOf(false) }

    fun startRecognition(uri: Uri?) {
        infoMessage = null
        if (uri == null) {
            errorMessage = "No image selected."
            return
        }

        coroutineScope.launch {
            recognizeRecipeText(
                context = context,
                uri = uri,
                recognizer = recognizer,
                onStart = {
                    isRecognizing = true
                    extractedText = ""
                    recipeDraft = null
                    errorMessage = null
                },
                onSuccess = { text ->
                    isRecognizing = false
                    if (text.isBlank()) {
                        extractedText = ""
                        recipeDraft = null
                        errorMessage = "No text detected in the selected image."
                    } else {
                        extractedText = text
                        recipeDraft = parseRecipeDraft(text)
                    }
                },
                onFailure = { message ->
                    isRecognizing = false
                    extractedText = ""
                    recipeDraft = null
                    errorMessage = message
                }
            )
        }
    }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        infoMessage = null
        if (uri == null) {
            errorMessage = "No image selected."
            return@rememberLauncherForActivityResult
        }

        selectedImageUri = uri
        selectedBitmap = loadBitmapFromUri(context, uri)
        errorMessage = null
        startRecognition(uri)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AI Assistant") },
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
                    modifier = Modifier.padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Icon(Icons.Default.AutoAwesome, contentDescription = null, tint = OrangeSecondary)
                        Text(
                            text = "ML Kit recipe text extraction",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Text(
                        text = "Select a recipe image from the gallery to extract text locally and preview a draft recipe structure for the prototype.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.82f)
                    )
                }
            }

            OutlinedTextField(
                value = prompt,
                onValueChange = { prompt = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Prototype prompt context") }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = {
                        errorMessage = null
                        infoMessage = null
                        imagePicker.launch("image/*")
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(Icons.Default.Image, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Select recipe image")
                }

                OutlinedButton(
                    onClick = { startRecognition(selectedImageUri) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Extract text")
                }
            }

            if (selectedBitmap != null || selectedImageUri != null) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Selected image",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        selectedBitmap?.let { bitmap ->
                            Image(
                                bitmap = bitmap.asImageBitmap(),
                                contentDescription = "Selected recipe image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(220.dp)
                            )
                        }
                        Text(
                            text = selectedImageUri?.toString() ?: "Image ready for OCR",
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.72f)
                        )
                    }
                }
            }

            if (isRecognizing) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.size(22.dp),
                            strokeWidth = 2.5.dp
                        )
                        Text(
                            text = "Recognizing recipe text from the selected image...",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            errorMessage?.let { message ->
                StatusCard(
                    title = "Recognition status",
                    body = message,
                    containerColor = MaterialTheme.colorScheme.errorContainer,
                    contentColor = MaterialTheme.colorScheme.onErrorContainer
                )
            }

            infoMessage?.let { message ->
                StatusCard(
                    title = "Prototype note",
                    body = message,
                    containerColor = OrangeSecondary.copy(alpha = 0.12f),
                    contentColor = MaterialTheme.colorScheme.onSurface
                )
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Text(
                        text = "Recipe draft preview",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )

                    DraftSection(
                        heading = "Detected title",
                        lines = listOf(recipeDraft?.title?.ifBlank { "Untitled recipe draft" } ?: "Title will appear here after OCR.")
                    )
                    DraftSection(
                        heading = "Ingredients preview",
                        lines = recipeDraft?.ingredients?.ifEmpty {
                            listOf("No ingredient lines detected yet.")
                        } ?: listOf("Ingredients will be grouped here after OCR.")
                    )
                    DraftSection(
                        heading = "Instructions preview",
                        lines = recipeDraft?.instructions?.ifEmpty {
                            listOf("No instruction lines detected yet.")
                        } ?: listOf("Instructions will be grouped here after OCR.")
                    )

                    Button(
                        onClick = {
                            infoMessage = "Recipe draft integration will be connected in the next iteration."
                            Toast.makeText(
                                context,
                                "Recipe draft integration will be connected in the next iteration.",
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Use extracted text for recipe draft")
                    }
                }
            }

            if (extractedText.isNotBlank()) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Extracted text",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = extractedText,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            ChatBubble(
                title = "Healthy Recipe AI",
                icon = Icons.Default.SmartToy,
                accent = Color(0xFF4F6BED),
                content = "This prototype uses on-device text recognition first. Once a recipe image is parsed reliably, the next iteration can connect the draft directly into recipe creation."
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = OrangeSecondary.copy(alpha = 0.12f))
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "Prototype note",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "Gallery-based OCR keeps the advanced feature screenshot-ready without adding camera permission flow to the skeleton prototype.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

private suspend fun recognizeRecipeText(
    context: Context,
    uri: Uri,
    recognizer: TextRecognizer,
    onStart: () -> Unit,
    onSuccess: (String) -> Unit,
    onFailure: (String) -> Unit
) {
    onStart()
    try {
        val image = InputImage.fromFilePath(context, uri)
        val result = recognizer.process(image).await()
        onSuccess(result.text.trim())
    } catch (_: Exception) {
        onFailure("Text recognition failed. Please try a clearer recipe image.")
    }
}

private fun parseRecipeDraft(text: String): RecipeDraftPreview {
    val lines = text
        .lines()
        .map { it.trim() }
        .filter { it.isNotEmpty() }

    val title = lines.firstOrNull().orEmpty()
    val ingredients = mutableListOf<String>()
    val instructions = mutableListOf<String>()

    lines.drop(1).forEach { line ->
        if (looksLikeIngredient(line)) {
            ingredients += line
        } else {
            instructions += line
        }
    }

    return RecipeDraftPreview(
        title = title,
        ingredients = ingredients,
        instructions = instructions
    )
}

private fun looksLikeIngredient(line: String): Boolean {
    val normalized = line.lowercase()
    val ingredientKeywords = listOf(
        "cup", "cups", "tbsp", "tsp", "teaspoon", "teaspoons", "tablespoon", "tablespoons",
        "g", "kg", "ml", "l", "oz", "lb", "clove", "cloves", "slice", "slices",
        "pinch", "ingredient", "ingredients"
    )
    val startsWithQuantity = normalized.matches(Regex("^\\d+[\\d/ .-]*.*"))
    val containsMeasure = ingredientKeywords.any { keyword -> normalized.contains(keyword) }
    val bulletLine = normalized.startsWith("-")
    return startsWithQuantity || containsMeasure || bulletLine
}

private fun loadBitmapFromUri(context: Context, uri: Uri): Bitmap? {
    return runCatching {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val source = ImageDecoder.createSource(context.contentResolver, uri)
            ImageDecoder.decodeBitmap(source)
        } else {
            @Suppress("DEPRECATION")
            MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
        }
    }.getOrNull()
}

@Composable
private fun DraftSection(
    heading: String,
    lines: List<String>
) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        Text(
            text = heading,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.SemiBold
        )
        lines.forEach { line ->
            Text(
                text = line,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun StatusCard(
    title: String,
    body: String,
    containerColor: Color,
    contentColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = containerColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                color = contentColor
            )
            Text(
                text = body,
                style = MaterialTheme.typography.bodyMedium,
                color = contentColor
            )
        }
    }
}

@Composable
private fun ChatBubble(
    title: String,
    icon: ImageVector,
    accent: Color,
    content: String
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(accent.copy(alpha = 0.9f), accent.copy(alpha = 0.55f))
                            ),
                            shape = CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(icon, contentDescription = null, tint = Color.White)
                }
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Text(text = content, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

// TODO: Add camera capture flow for direct recipe scanning in a later iteration.
// TODO: Connect extracted recipe draft data to Add Recipe auto-fill in a later iteration.
