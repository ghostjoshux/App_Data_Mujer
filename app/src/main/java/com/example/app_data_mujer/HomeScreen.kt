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
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CompassCalibration
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

data class CategoryItem(
    val name: String,
    val countText: String,
    val emoji: String,
    val backgroundColor: Color,
    val textColor: Color = Color.Black
)

@Composable
fun HomeScreen(username: String, onCategoryClick: (String) -> Unit, onAboutClick: () -> Unit) {
    var selectedTab by remember { mutableStateOf("explorar") }

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

    val scrollState = rememberScrollState()

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
                .verticalScroll(scrollState)
        ) {
            // Header Row
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
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
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

            // Dynamic grid calculation inside standard Column to scroll the whole screen smoothly
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
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    App_Data_MujerTheme {
        HomeScreen(
            username = "Fiorella", 
            onCategoryClick = {}, 
            onAboutClick = {}
        )
    }
}
