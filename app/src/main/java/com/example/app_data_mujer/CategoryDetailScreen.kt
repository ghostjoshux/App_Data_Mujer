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
    val (emoji, headerColor, screenBgColor) = when (categoryName.lowercase()) {
        "matemáticas", "matematicas" -> Triple("🧮", Color(0xFFFCDD81), Color(0xFFFDE79D))
        "física", "fisica" -> Triple("⚛️", Color(0xFF8CD8DA), Color(0xFFB1EBEB))
        "química", "quimica" -> Triple("🧪", Color(0xFFF4B2DE), Color(0xFFF8CFF0))
        "biología", "biologia" -> Triple("🔬", Color(0xFFC9C1FF), Color(0xFFDCD6FF))
        "medicina" -> Triple("🩺", Color(0xFFF4B2DE), Color(0xFFF8CFF0))
        "astronomía", "astronomia" -> Triple("☄️", DataMujerDark, Color(0xFFD6DBF8))
        "computación", "computacion" -> Triple("👩‍💻", Color(0xFFC9C1FF), Color(0xFFDCD6FF))
        "ingeniería", "ingenieria" -> Triple("⚙️", Color(0xFF8CD8DA), Color(0xFFB1EBEB))
        else -> Triple("📚", DataMujerTeal, Color(0xFFEDF7F9))
    }

    val isMatematicas = categoryName.equals("Matemáticas", ignoreCase = true) || categoryName.equals("Matematicas", ignoreCase = true)
    val isFisica = categoryName.equals("Física", ignoreCase = true) || categoryName.equals("Fisica", ignoreCase = true)
    val isQuimica = categoryName.equals("Química", ignoreCase = true) || categoryName.equals("Quimica", ignoreCase = true)
    val isBiologia = categoryName.equals("Biología", ignoreCase = true) || categoryName.equals("Biologia", ignoreCase = true)
    val isMedicina = categoryName.equals("Medicina", ignoreCase = true)
    val isAstronomia = categoryName.equals("Astronomía", ignoreCase = true) || categoryName.equals("Astronomia", ignoreCase = true)
    val isComputacion = categoryName.equals("Computación", ignoreCase = true) || categoryName.equals("Computacion", ignoreCase = true)
    val isIngenieria = categoryName.equals("Ingeniería", ignoreCase = true) || categoryName.equals("Ingenieria", ignoreCase = true)

    val scientists = when {
        isMatematicas -> listOf(
            ScientistStory("Sophie Germain", "TEORÍA DE NÚMEROS Y ELASTICIDAD", "Francia • 1776–1831", "🧮", Color(0xFFFCDD81), imageRes = R.drawable.sophie_germain),
            ScientistStory("Sofía Kovalevskaya", "ECUACIONES Y MECÁNICA", "Imperio ruso • 1850–1891", "⚛️", Color(0xFF8CD8DA), imageRes = R.drawable.sofia_k),
            ScientistStory("Emmy Noether", "ÁLGEBRA ABSTRACTA", "Alemania • 1882–1935", "📐", Color(0xFFC9C1FF), imageRes = R.drawable.emmy_noether),
            ScientistStory("Maryam Mirzakhani", "GEOMETRÍA", "Irán • 1977–2017", "📏", Color(0xFFF4B2DE), imageRes = R.drawable.maryam_m_portada),
            ScientistStory("Sun-Yung Alice Chang", "ANÁLISIS GEOMÉTRICO", "China • 1948–Actualidad", "📊", Color(0xFFFCDD81), imageRes = R.drawable.sung_yung_portada)
        )
        isFisica -> listOf(
            ScientistStory("Lise Meitner", "FÍSICA NUCLEAR", "Australia-Hungría • 1878–1968", "⚛️", Color(0xFF8CD8DA), imageRes = R.drawable.lisa_meitner_portada),
            ScientistStory("Mary Tsingou", "FÍSICA MATEMÁTICA", "Estados Unidos • 1928–Actualidad", "🖥️", Color(0xFFC9C1FF), imageRes = R.drawable.mary_tsinguo_portada),
            ScientistStory("Donna Strickland", "LÁSERES DE ALTA INTENSIDAD", "Canadá • 1959–Actualidad", "🔴", Color(0xFFF4B2DE), imageRes = R.drawable.donna_strickland),
            ScientistStory("Helen Czerski", "FÍSICA DE OCÉANOS", "Inglaterra • 1978–Actualidad", "🌊", Color(0xFFFCDD81), imageRes = R.drawable.helen_czerski_portada)
        )
        isQuimica -> listOf(
            ScientistStory("Stephanie Kwolek", "QUÍMICA DE POLÍMEROS", "Estados Unidos • 1923–2014", "🧪", Color(0xFFF4B2DE), imageRes = R.drawable.stephanie_kwolek_portada),
            ScientistStory("Marie-Anne Pierrette Paulze-Lavoisier", "DOCUMENTACIÓN CIENTÍFICA", "Francia • 1758–1836", "🧪", Color(0xFF8CD8DA), imageRes = R.drawable.marie_anne_portada),
            ScientistStory("Irène Joliot-Curie", "RADIOQUÍMICA", "Francia • 1897–1956", "⚗️", Color(0xFFC9C1FF), imageRes = R.drawable.irene_portada),
            ScientistStory("Marie Curie", "RADIOACTIVIDAD", "Polonia • 1867–1934", "⚛️", Color(0xFFFCDD81), imageRes = R.drawable.marie_curie_portada),
            ScientistStory("Rosalind Franklin", "CRISTALOGRAFÍA", "Inglaterra • 1920–1958", "🧬", Color(0xFFF4B2DE), imageRes = R.drawable.rosalind_franklin_portada)
        )
        isBiologia -> listOf(
            ScientistStory("Margarita Salas", "BIOQUÍMICA MOLECULAR", "España • 1938–2019", "🔬", Color(0xFFC9C1FF), imageRes = R.drawable.margarita_salas_portada),
            ScientistStory("Barbara McClintock", "CITOGENÉTICA", "Estados Unidos • 1902–1992", "🌽", Color(0xFFFCDD81), imageRes = R.drawable.barbara_mcclintock_portada),
            ScientistStory("Lynn Margulis", "BIOLOGÍA EVOLUTIVA", "Estados Unidos • 1938–2011", "🦠", Color(0xFF8CD8DA), imageRes = R.drawable.lynn_margulis_portada),
            ScientistStory("Nettie Stevens", "GENÉTICA Y CITOLOGÍA", "Estados Unidos • 1861–1912", "🧬", Color(0xFFF4B2DE), imageRes = R.drawable.nettie_stevens_portada),
            ScientistStory("Elizabeth Blackburn", "BIOLOGÍA MOLECULAR", "Australiana • 1948–Actualidad", "🔬", Color(0xFFC9C1FF), imageRes = R.drawable.elizabeth_blackburn_portada)
        )
        isMedicina -> listOf(
            ScientistStory("Rosalyn Yalow", "FÍSICA MÉDICA", "Estados Unidos • 1921–2011", "🩺", Color(0xFFFCDD81), imageRes = R.drawable.rosalyn_yalow_portada),
            ScientistStory("Flora de Pablo", "BIOLOGÍA CELULAR", "España • 1952–Actualidad", "🩺", Color(0xFFF4B2DE), imageRes = R.drawable.flora_de_pablo_portada),
            ScientistStory("Cecilia Grierson", "MEDICINA Y SALUD PÚBLICA", "Argentina • 1859–1934", "🏥", Color(0xFF8CD8DA), imageRes = R.drawable.cecilia_grierson_portada),
            ScientistStory("Patricia Bath", "OFTALMOLOGÍA", "Estados Unidos • 1942–2019", "👁️", Color(0xFFC9C1FF), imageRes = R.drawable.patricia_bath_portada),
            ScientistStory("Margaret Sanger", "SALUD REPRODUCTIVA", "Estados Unidos • 1879–1966", "🩺", Color(0xFFF4B2DE), imageRes = R.drawable.margaret_sanger_portada)
        )
        isAstronomia -> listOf(
            ScientistStory("Caroline Herschel", "OBSERVACIÓN ASTRONÓMICA", "Alemania • 1750–1848", "🔭", Color(0xFFC9C1FF), imageRes = R.drawable.caroline_herschel_portada),
            ScientistStory("Maria Mitchell", "ASTRONOMÍA OBSERVACIONAL", "Estados Unidos • 1818–1889", "🔭", Color(0xFFC9C1FF), imageRes = R.drawable.maria_mitchell_portada),
            ScientistStory("Henrietta Swan Leavitt", "FOTOMETRÍA ESTELAR", "Estados Unidos • 1868–1921", "⭐", Color(0xFFFCDD81), imageRes = R.drawable.henrietta_swan_leavitt_portada),
            ScientistStory("Annie Jump Cannon", "CLASIFICACIÓN ESPECTRAL", "Estados Unidos • 1863–1941", "🌟", Color(0xFF8CD8DA), imageRes = R.drawable.annie_jump_cannon_portada),
            ScientistStory("Nancy Grace Roman", "ASTRONOMÍA ESPACIAL", "Estados Unidos • 1925–2018", "🛰️", Color(0xFFF4B2DE), imageRes = R.drawable.nancy_grace_roman_portada)
        )
        isComputacion -> listOf(
            ScientistStory("Ada Lovelace", "ALGORITMOS Y TEORÍA", "Inglaterra • 1815–1852", "💻", Color(0xFFC9C1FF), imageRes = R.drawable.ada_lovelace_portada),
            ScientistStory("Evelyn Berezin", "PROCESAMIENTO DE TEXTO", "Estados Unidos • 1925–2018", "⌨️", Color(0xFFC9C1FF), imageRes = R.drawable.evelyn_berezin_portada),
            ScientistStory("Grace Murray Hopper", "COMPILADORES Y LENGUAJES", "Estados Unidos • 1906–1992", "💻", Color(0xFFC9C1FF), imageRes = R.drawable.grace_murray_hopper_portada),
            ScientistStory("Jude Milhon", "CULTURA HACKER Y REDES", "Estados Unidos • 1939–2003", "🌐", Color(0xFFC9C1FF), imageRes = R.drawable.jude_milhon_portada),
            ScientistStory("Lynn Conway", "DISEÑO VLSI Y ARQUITECTURA", "Estados Unidos • 1938–2024", "🔌", Color(0xFFC9C1FF), imageRes = R.drawable.lynn_conway_portada)
        )
        isIngenieria -> listOf(
            ScientistStory("Hedy Lamarr", "COMUNICACIONES", "Austria-Hungría • 1914–2000", "📻", Color(0xFFFCDD81), imageRes = R.drawable.hedy_lamarr_portadas),
            ScientistStory("Emily Warren Roebling", "CONSTRUCCIÓN CIVIL", "Estados Unidos • 1843–1903", "🌉", Color(0xFFFCDD81), imageRes = R.drawable.emily_warren_roebling_portadas),
            ScientistStory("Edith Clarke", "INGENIERÍA ELÉCTRICA", "Estados Unidos • 1883–1959", "⚡", Color(0xFFFCDD81), imageRes = R.drawable.edith_clarkeedith_clarke_portadas),
            ScientistStory("Elisa Leonida Zamfirescu", "INGENIERÍA QUÍMICA", "Rumanía • 1887–1973", "⚗️", Color(0xFFFCDD81), imageRes = R.drawable.elisa_leonida_zamfirescu_portadas),
            ScientistStory("Beatrice Shilling", "INGENIERÍA AERONÁUTICA", "Inglaterra • 1909–1990", "✈️", Color(0xFFFCDD81), imageRes = R.drawable.beatrice_shilling_portadas)
        )
        else -> emptyList()
    }

    Scaffold(
        containerColor = screenBgColor,
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
                                        color = screenBgColor,
                                        modifier = Modifier.weight(1f).padding(end = 4.dp)
                                    ) {
                                        Text(
                                            text = scientist.tag,
                                            fontSize = 8.5.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = DataMujerDark,
                                            maxLines = 2,
                                            lineHeight = 11.sp,
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
