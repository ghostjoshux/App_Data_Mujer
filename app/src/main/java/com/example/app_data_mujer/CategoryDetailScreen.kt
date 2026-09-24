package com.example.app_data_mujer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_data_mujer.ui.theme.*

data class ScientistStory(
    val name: String,
    val tag: String,
    val details: String,
    val emoji: String,
    val cardBgColor: Color,
    val imageRes: Int? = null
)

@Composable
fun CategoryDetailScreen(
    categoryName: String,
    onBack: () -> Unit,
    onScientistClick: (String) -> Unit,
    onAboutClick: () -> Unit
) {
    val (emoji, headerColor) = when (categoryName.lowercase()) {
        "matemáticas", "matematicas" -> "🧮" to Color(0xFFFCDD81)
        "física", "fisica" -> "⚛️" to Color(0xFF8CD8DA)
        "química", "quimica" -> "🧪" to Color(0xFFF4B2DE)
        "biología", "biologia" -> "🔬" to Color(0xFFC9C1FF)
        "medicina" -> "🩺" to Color(0xFFF4B2DE)
        "astronomía", "astronomia" -> "☄️" to DataMujerDark
        "computación", "computacion" -> "👩‍💻" to Color(0xFFC9C1FF)
        "ingeniería", "ingenieria" -> "⚙️" to Color(0xFF8CD8DA)
        else -> "📚" to DataMujerTeal
    }

    val isMatematicas = categoryName.equals("Matemáticas", ignoreCase = true) || categoryName.equals("Matematicas", ignoreCase = true)
    val isFisica = categoryName.equals("Física", ignoreCase = true) || categoryName.equals("Fisica", ignoreCase = true)

    val scientists = when {
        isMatematicas -> listOf(
            ScientistStory("Sophie Germain", "TEORÍA DE NÚMEROS Y ELASTICIDAD", "Francia • 1776–1831", "🧮", Color(0xFFFCDD81), imageRes = R.drawable.sophie_germain),
            ScientistStory("Sofía Kovalevskaya", "ECUACIONES DIFERENCIALES Y MECÁNICA", "Imperio ruso • 1850–1891", "⚛️", Color(0xFF8CD8DA), imageRes = R.drawable.sofia_k),
            ScientistStory("Emmy Noether", "ÁLGEBRA ABSTRACTA", "Alemania • 1882–1935", "📐", Color(0xFFC9C1FF), imageRes = R.drawable.emmy_noether),
            ScientistStory("Maryam Mirzakhani", "GEOMETRÍA", "Irán • 1977–2017", "📏", Color(0xFFF4B2DE), imageRes = R.drawable.maryam_m_portada),
            ScientistStory("Sun-Yung Alice Chang", "ANÁLISIS GEOMÉTRICO", "China • 1948–Actualidad", "📊", Color(0xFFFCDD81), imageRes = R.drawable.sung_yung_portada)
        )
        isFisica -> listOf(
            ScientistStory("Lise Meitner", "FÍSICA NUCLEAR", "Australia-Hungría • 1878–1968", "⚛️", Color(0xFF8CD8DA), imageRes = R.drawable.lisa_meitner_portada),
            ScientistStory("Mary Tsingou", "FÍSICA MATEMÁTICA", "Estados Unidos • 1928–Actualidad", "🖥️", Color(0xFFC9C1FF), imageRes = R.drawable.mary_tsinguo_portada),
            ScientistStory("Donna Strickland", "LÁSERES DE ALTA INTENSIDAD", "Canadá • 1959–Actualidad", "🔴", Color(0xFFF4B2DE), imageRes = R.drawable.donna_strickland),
            ScientistStory("Helen Czerski", "FÍSICA DE OCÉANOS", "Inglaterra • 1978–Actualidad", "🌊", Color(0xFFFCDD81))
        )
        else -> emptyList()
    }

    Scaffold(
        containerColor = Color(0xFFEDF7F9),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(1.dp, Color.LightGray.copy(alpha = 0.5f), CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Regresar",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                }

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
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Category Header Row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(headerColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = emoji, fontSize = 32.sp)
                }

                Column {
                    Text(
                        text = categoryName,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = DataMujerDark
                    )
                    Text(
                        text = if (scientists.isNotEmpty()) "${scientists.size} historias disponibles" else "Próximamente",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            if (scientists.isNotEmpty()) {
                // Grid of Scientist Cards
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(scientists) { scientist ->
                        var isFavorite by remember { mutableStateOf(FavoritesManager.isFavorite(scientist.name)) }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { onScientistClick(scientist.name) },
                            shape = RoundedCornerShape(20.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White),
                            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp)
                            ) {
                                // Top image or emoji box
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(100.dp)
                                        .clip(RoundedCornerShape(14.dp))
                                        .background(scientist.cardBgColor),
                                    contentAlignment = Alignment.Center
                                ) {
                                    if (scientist.imageRes != null) {
                                        Image(
                                            painter = painterResource(id = scientist.imageRes),
                                            contentDescription = scientist.name,
                                            contentScale = ContentScale.Crop,
                                            modifier = Modifier.fillMaxSize()
                                        )
                                    } else {
                                        Text(text = scientist.emoji, fontSize = 40.sp)
                                    }
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                // Tag pill and Heart Icon row
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Surface(
                                        shape = RoundedCornerShape(8.dp),
                                        color = Color(0xFFFFF6D6),
                                        modifier = Modifier.weight(1f).padding(end = 4.dp)
                                    ) {
                                        Text(
                                            text = scientist.tag,
                                            fontSize = 9.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = Color(0xFF8B6508),
                                            maxLines = 1,
                                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                        )
                                    }

                                    IconButton(
                                        onClick = { 
                                            FavoritesManager.toggleFavorite(scientist.name)
                                            isFavorite = FavoritesManager.isFavorite(scientist.name)
                                        },
                                        modifier = Modifier.size(24.dp)
                                    ) {
                                        Icon(
                                            imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                            contentDescription = "Favorito",
                                            tint = if (isFavorite) DataMujerPink else Color.Gray,
                                            modifier = Modifier.size(18.dp)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(6.dp))

                                // Scientist Name
                                Text(
                                    text = scientist.name,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = DataMujerDark,
                                    maxLines = 1
                                )

                                Spacer(modifier = Modifier.height(2.dp))

                                // Details / Country & dates
                                Text(
                                    text = scientist.details,
                                    fontSize = 11.sp,
                                    color = Color.Gray,
                                    maxLines = 1
                                )
                            }
                        }
                    }
                }
            } else {
                // Coming Soon State for other categories
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Default.Build,
                                contentDescription = null,
                                tint = DataMujerTeal,
                                modifier = Modifier.size(48.dp)
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = "¡Próximamente!",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                color = DataMujerDark
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Las historias y científicas para la categoría de $categoryName estarán disponibles muy pronto en Data Mujer.",
                                fontSize = 14.sp,
                                color = Color.Gray,
                                textAlign = TextAlign.Center,
                                lineHeight = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
