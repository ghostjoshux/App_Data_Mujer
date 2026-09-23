package com.example.app_data_mujer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.border
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_data_mujer.ui.theme.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.ui.geometry.Offset

data class CategoryItem(
    val name: String,
    val countText: String,
    val emoji: String,
    val backgroundColor: Color,
    val textColor: Color = Color.Black
)

@Composable
fun HomeScreen(username: String, onCategoryClick: (String) -> Unit, onAboutClick: () -> Unit, onScientistClick: (String) -> Unit) {
    var selectedTab by remember { mutableStateOf("explorar") }
    var selectedDifficulty by remember { mutableStateOf("fácil") }

    val categories = listOf(
        CategoryItem("Matemáticas", "5 historias", "🧮", Color(0xFFFCDD81)),
        CategoryItem("Física", "5 historias", "⚛️", Color(0xFF8CD8DA)),
        CategoryItem("Química", "5 historias", "🧪", Color(0xFFF4B2DE)),
        CategoryItem("Biología", "5 historias", "🔬", Color(0xFFC9C1FF)),
        CategoryItem("Medicina", "5 historias", "🩺", Color(0xFFF4B2DE)),
        CategoryItem("Astronomía", "5 historias", "☄️", DataMujerDark, Color.White),
        CategoryItem("Computación", "5 historias", "👩‍💻", Color(0xFFC9C1FF)),
        CategoryItem("Ingeniería", "5 historias", "⚙️", Color(0xFF8CD8DA))
    )

    val scrollStateExplore = rememberScrollState()
    val scrollStateQuiz = rememberScrollState()

    Scaffold(
        containerColor = Color(0xFFEDF7F9),
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp)
                    .height(72.dp)
                    .clip(RoundedCornerShape(36.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Explorar Tab
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp))
                            .background(if (selectedTab == "explorar") Color(0xFFE0F2F1) else Color.Transparent)
                            .clickable { selectedTab = "explorar" }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Explorar",
                            tint = if (selectedTab == "explorar") DataMujerTeal else Color.Gray
                        )
                        Text(
                            text = "Explorar",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (selectedTab == "explorar") DataMujerTeal else Color.Gray
                        )
                    }

                    // Quiz Tab
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp))
                            .background(if (selectedTab == "quiz") Color(0xFFE0F2F1) else Color.Transparent)
                            .clickable { selectedTab = "quiz" }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Quiz,
                            contentDescription = "Quiz",
                            tint = if (selectedTab == "quiz") DataMujerTeal else Color.Gray
                        )
                        Text(
                            text = "Quiz",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (selectedTab == "quiz") DataMujerTeal else Color.Gray
                        )
                    }

                    // Guardadas Tab
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(RoundedCornerShape(24.dp))
                            .background(if (selectedTab == "guardadas") Color(0xFFE0F2F1) else Color.Transparent)
                            .clickable { selectedTab = "guardadas" }
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Guardadas",
                            tint = if (selectedTab == "guardadas") DataMujerTeal else Color.Gray
                        )
                        Text(
                            text = "Guardadas",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (selectedTab == "guardadas") DataMujerTeal else Color.Gray
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .verticalScroll(if (selectedTab == "explorar" || selectedTab == "quiz") scrollStateExplore else scrollStateQuiz)
        ) {
            // Header Row (Common for all tabs)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .clickable { onAboutClick() }
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = DataMujerPink,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "DATA MUJER",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = DataMujerPink
                    )
                }
            }

            var activeGameScreen by remember { mutableStateOf(false) }
            var currentQuestionsSet by remember { mutableStateOf<List<QuizQuestion>>(emptyList()) }

            if (selectedTab == "explorar") {
                ExploreContent(username, categories, onCategoryClick)
            } else if (selectedTab == "quiz") {
                if (activeGameScreen) {
                    GameQuizContent(
                        questions = currentQuestionsSet,
                        difficulty = selectedDifficulty,
                        onFinish = { activeGameScreen = false }
                    )
                } else {
                    QuizContent(
                        selectedDifficulty = selectedDifficulty,
                        onDifficultyChange = { selectedDifficulty = it },
                        onStartGame = {
                            val (sourceList, count) = when (selectedDifficulty) {
                                "intermedio" -> MediumQuestionsList to 10
                                "difícil" -> HardQuestionsList to 15
                                else -> EasyQuestionsList to 5
                            }
                            currentQuestionsSet = sourceList.shuffled().take(count)
                            activeGameScreen = true
                        }
                    )
                }
            } else {
                // Guardadas Tab Content
                val savedFavorites = FavoritesManager.favoriteScientists
                if (savedFavorites.isEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(top = 48.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(Icons.Default.Favorite, contentDescription = null, modifier = Modifier.size(64.dp), tint = Color.LightGray)
                        Text("Aquí aparecerán tus historias guardadas.", color = Color.Black, modifier = Modifier.padding(top = 16.dp))
                    }
                } else {
                    Column(
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Tus historias guardadas",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = DataMujerDark
                        )
                        Text(
                            text = "Accede rápidamente a tus científicas favoritas.",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )

                        savedFavorites.forEach { scientistName ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onScientistClick(scientistName) },
                                shape = RoundedCornerShape(20.dp),
                                colors = CardDefaults.cardColors(containerColor = Color.White),
                                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .size(48.dp)
                                                .clip(CircleShape)
                                                .background(DataMujerPink.copy(alpha = 0.1f)),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Favorite,
                                                contentDescription = null,
                                                tint = DataMujerPink,
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }
                                        Column {
                                            Text(
                                                text = scientistName,
                                                fontSize = 16.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = DataMujerDark
                                            )
                                            Text(
                                                text = "Matemáticas",
                                                fontSize = 12.sp,
                                                color = Color.Gray
                                            )
                                        }
                                    }

                                    IconButton(
                                        onClick = { FavoritesManager.toggleFavorite(scientistName) }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Favorite,
                                            contentDescription = "Eliminar de favoritos",
                                            tint = DataMujerPink
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ExploreContent(username: String, categories: List<CategoryItem>, onCategoryClick: (String) -> Unit) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))

        // Welcome Greeting
        Text(
            text = "Hola, ${username.ifBlank { "Fiorella" }} 👋",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = DataMujerDark,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Hoy también puedes descubrir algo increíble.",
            fontSize = 15.sp,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = DataMujerPink.copy(alpha = 0.5f), thickness = 1.dp)
        Spacer(modifier = Modifier.height(16.dp))

        // Categories Header
        Text(
            text = "Categorías",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF9575CD) // Lavender accent from image
        )

        Text(
            text = "Descubre a las mujeres que dejaron huella en la ciencia.",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
        )

        // Dynamic grid calculation
        val chunks = categories.chunked(2)
        chunks.forEach { chunk ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                chunk.forEach { item ->
                    Card(
                        modifier = Modifier
                            .weight(1f)
                            .height(110.dp)
                            .clickable { onCategoryClick(item.name) },
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(containerColor = item.backgroundColor)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = item.emoji,
                                fontSize = 24.sp,
                                modifier = Modifier.padding(bottom = 8.dp)
                            )
                            Text(
                                text = item.name,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = item.textColor
                            )
                            Text(
                                text = item.countText,
                                fontSize = 12.sp,
                                color = if (item.textColor == Color.White) Color.LightGray else Color.Gray
                            )
                        }
                    }
                }
                if (chunk.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun QuizContent(selectedDifficulty: String, onDifficultyChange: (String) -> Unit, onStartGame: () -> Unit) {
    Column {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Reto científico",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = DataMujerDark
        )
        Text(
            text = "Elige tu dificultad",
            fontSize = 18.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 4.dp)
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Dark Info Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = DataMujerDark)
        ) {
            Row(
                modifier = Modifier.padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.StarBorder,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(
                        text = "¿Qué tanto sabes de ellas?",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Descubre, aprende y pon a prueba tus conocimientos.",
                        color = Color.White.copy(alpha = 0.8f),
                        fontSize = 14.sp
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Difficulty List
        DifficultyItem(
            title = "Fácil",
            description = "Reconoce nombres y áreas científicas.",
            stars = 1,
            color = DataMujerTeal,
            isSelected = selectedDifficulty == "fácil",
            onClick = { onDifficultyChange("fácil") }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        DifficultyItem(
            title = "Intermedio",
            description = "Relaciona científicas con sus aportes.",
            stars = 2,
            color = Color(0xFF9575CD),
            isSelected = selectedDifficulty == "intermedio",
            onClick = { onDifficultyChange("intermedio") }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        DifficultyItem(
            title = "Difícil",
            description = "Conecta descubrimientos y detalles.",
            stars = 3,
            color = DataMujerPink,
            isSelected = selectedDifficulty == "difícil",
            onClick = { onDifficultyChange("difícil") }
        )
        
        Spacer(modifier = Modifier.height(48.dp))
        
        Button(
            onClick = onStartGame,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DataMujerPink)
        ) {
            Text("Comenzar quiz", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
        
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun DifficultyItem(
    title: String,
    description: String,
    stars: Int,
    color: Color,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .then(if (isSelected) Modifier.border(2.dp, color, RoundedCornerShape(24.dp)) else Modifier),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected) 0.dp else 2.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Row {
                    repeat(stars) {
                        Icon(
                            imageVector = Icons.Default.StarBorder,
                            contentDescription = null,
                            tint = color,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Column(modifier = Modifier.weight(1f)) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.Black)
                Text(text = description, fontSize = 14.sp, color = Color.Gray)
            }
            
            Icon(
                imageVector = if (isSelected) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                contentDescription = null,
                tint = if (isSelected) color else Color.LightGray,
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@Composable
fun GameQuizContent(questions: List<QuizQuestion>, difficulty: String, onFinish: () -> Unit) {
    if (questions.isEmpty()) return

    val scope = rememberCoroutineScope()
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf(-1) }
    var confirmed by remember { mutableStateOf(false) }
    var points by remember { mutableStateOf(0) }
    var quizFinished by remember { mutableStateOf(false) }
    
    var timeElapsed by remember { mutableStateOf(0) }
    var correctAnswersCount by remember { mutableStateOf(0) }

    LaunchedEffect(quizFinished) {
        if (!quizFinished) {
            while (true) {
                delay(1000)
                timeElapsed++
            }
        }
    }

    val currentQuestion = questions[currentQuestionIndex]

    if (quizFinished) {
        Box(modifier = Modifier.fillMaxWidth().height(600.dp)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Default.Star, contentDescription = null, tint = DataMujerYellow, modifier = Modifier.size(72.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text("¡Reto Terminado!", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
                Spacer(modifier = Modifier.height(8.dp))
                
                val minutes = timeElapsed / 60
                val seconds = timeElapsed % 60
                val timeStr = if (minutes > 0) "${minutes}m ${seconds}s" else "${seconds} segundos"
                
                Text("Tiempo: $timeStr", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = DataMujerTeal)
                Text("Has acumulado $points puntos de ciencia.", fontSize = 16.sp, color = Color.Gray)
                
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = onFinish,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = DataMujerTeal)
                ) {
                    Text("Volver al inicio", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
            
            // Confetti if user gets enough correct answers based on difficulty
            val threshold = when (difficulty) {
                "fácil" -> 3
                "intermedio" -> 5
                else -> 7 // "difícil"
            }
            if (correctAnswersCount >= threshold) {
                ConfettiOverlay()
            }
        }
    } else {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            
            // Header Row with Back Button to exit quiz early
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = onFinish,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(1.dp, Color.LightGray.copy(alpha = 0.5f), CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Salir del quiz",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                }
                
                // Live Chronometer
                val minutes = timeElapsed / 60
                val seconds = timeElapsed % 60
                val liveTimeStr = "%02d:%02d".format(minutes, seconds)
                
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "⏱ $liveTimeStr",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = DataMujerDark
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Reto científico",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = DataMujerDark
            )
            Text(
                text = "Pregunta ${currentQuestionIndex + 1} de ${questions.size}",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Progress Bar
            LinearProgressIndicator(
                progress = { (currentQuestionIndex + 1).toFloat() / questions.size.toFloat() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = DataMujerTeal,
                trackColor = Color.LightGray.copy(alpha = 0.4f)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Dark Question Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = DataMujerDark)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFEBEBFF))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = currentQuestion.category.uppercase(),
                            color = Color(0xFF5C59AA),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = currentQuestion.question,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 26.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Elige una opción",
                        color = Color.White.copy(alpha = 0.6f),
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Options List
            val optionPrefixes = listOf("A", "B", "C", "D")
            currentQuestion.options.forEachIndexed { idx, optionText ->
                val isSelected = selectedOptionIndex == idx
                val isCorrect = idx == currentQuestion.correctOptionIndex
                
                val borderColor = when {
                    confirmed && isCorrect -> Color(0xFF4CAF50) // Green
                    confirmed && isSelected && !isCorrect -> Color(0xFFF44336) // Red
                    isSelected -> Color(0xFF9575CD)
                    else -> Color.Transparent
                }
                
                val backgroundColor = when {
                    confirmed && isCorrect -> Color(0xFFE8F5E9)
                    confirmed && isSelected && !isCorrect -> Color(0xFFFFEBEE)
                    else -> Color.White
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                        .clickable(enabled = !confirmed) { selectedOptionIndex = idx }
                        .then(if (borderColor != Color.Transparent) Modifier.border(2.dp, borderColor, RoundedCornerShape(20.dp)) else Modifier),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = backgroundColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = if (isSelected || confirmed) 0.dp else 2.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        val iconBgColor = when {
                            confirmed && isCorrect -> Color(0xFF4CAF50)
                            confirmed && isSelected && !isCorrect -> Color(0xFFF44336)
                            isSelected -> Color(0xFF9575CD)
                            else -> Color(0xFFF5F5F5)
                        }

                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                                .background(iconBgColor),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = optionPrefixes[idx],
                                color = if (isSelected || (confirmed && isCorrect)) Color.White else Color.Gray,
                                fontWeight = FontWeight.Bold,
                                fontSize = 14.sp
                            )
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = optionText,
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = if (isSelected || (confirmed && isCorrect)) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Check Answer Button
            Button(
                onClick = {
                    if (selectedOptionIndex != -1 && !confirmed) {
                        confirmed = true
                        if (selectedOptionIndex == currentQuestion.correctOptionIndex) {
                            points += 40
                            correctAnswersCount++
                        }
                        
                        scope.launch {
                            delay(2000)
                            if (currentQuestionIndex + 1 < questions.size) {
                                currentQuestionIndex++
                                selectedOptionIndex = -1
                                confirmed = false
                            } else {
                                quizFinished = true
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DataMujerPink),
                enabled = selectedOptionIndex != -1 && !confirmed
            ) {
                Text(
                    text = if (confirmed) "Cargando..." else "Comprobar respuesta", 
                    fontSize = 16.sp, 
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "🔥 $points puntos de ciencia", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFFE57373))
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun ConfettiOverlay() {
    val infiniteTransition = rememberInfiniteTransition(label = "confetti")
    val colors = listOf(DataMujerTeal, DataMujerPink, DataMujerYellow, Color.Blue, Color.Green, Color.Magenta)
    
    val particles = remember {
        List(60) {
            Triple(
                Random.nextFloat(), // x position
                Random.nextFloat(), // y offset initial
                colors.random()      // color
            )
        }
    }

    val yAnim by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "yPos"
    )

    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        
        // If height is 0 (can happen in scrollable containers during first frames), use a default
        val actualHeight = if (canvasHeight > 0) canvasHeight else 2000f

        particles.forEach { particle ->
            val (x, yOffset, color) = particle
            // Calculate progress with offset to stagger start times
            val progress = (yAnim + yOffset) % 1f
            
            drawCircle(
                color = color,
                radius = 5.dp.toPx(),
                center = Offset(
                    x = x * canvasWidth,
                    y = progress * actualHeight
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    App_Data_MujerTheme {
        HomeScreen(
            username = "Fiorella", 
            onCategoryClick = {}, 
            onAboutClick = {},
            onScientistClick = {}
        )
    }
}
