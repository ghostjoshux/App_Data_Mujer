package com.example.app_data_mujer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_data_mujer.ui.theme.*

@Composable
fun HelenCzerskiDetailScreen(
    onBack: () -> Unit,
    onFollowExploring: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(0) } // 0: Biografía, 1: Aportes, 2: Curiosidades
    var isFavorite by remember { mutableStateOf(FavoritesManager.isFavorite("Helen Czerski")) }
    val scrollState = rememberScrollState()

    val primaryPurple = Color(0xFF5C3398)
    val cardBg = Color.White

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

                IconButton(
                    onClick = { 
                        FavoritesManager.toggleFavorite("Helen Czerski")
                        isFavorite = FavoritesManager.isFavorite("Helen Czerski")
                    },
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .border(1.dp, Color.LightGray.copy(alpha = 0.5f), CircleShape)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorito",
                        tint = if (isFavorite) DataMujerPink else Color.Gray,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
            ) {
                Button(
                    onClick = onFollowExploring,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryPurple)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = null, tint = Color.White)
                        Text(
                            text = "Seguir explorando →",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
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
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Profile Header with Photo & Quote bubble
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Circular Portrait
                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                        .border(3.dp, primaryPurple, CircleShape)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.helen_czerski_portada),
                        contentDescription = "Helen Czerski",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Quote Card
                Card(
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text(
                            text = "\"Lo cotidiano está lleno de física esperando ser observada.\"",
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.DarkGray,
                            lineHeight = 16.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "— HELEN CZERSKI",
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = primaryPurple
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Name and Category Badge
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Helen Czerski",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = DataMujerDark
                    )

                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = primaryPurple.copy(alpha = 0.1f)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(text = "⚛️", fontSize = 12.sp)
                            Text(
                                text = "FÍSICA",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = primaryPurple
                            )
                        }
                    }
                }

                Text(
                    text = "Física de océanos y burbujas",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Tabs Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TabButton(title = "Biografía", isSelected = selectedTab == 0, onClick = { selectedTab = 0 }, activeColor = primaryPurple)
                TabButton(title = "Aportes", isSelected = selectedTab == 1, onClick = { selectedTab = 1 }, activeColor = primaryPurple)
                TabButton(title = "Curiosidades", isSelected = selectedTab == 2, onClick = { selectedTab = 2 }, activeColor = primaryPurple)
            }

            HorizontalDivider(color = Color.LightGray.copy(alpha = 0.5f), thickness = 1.dp)

            Spacer(modifier = Modifier.height(24.dp))

            // Tab Content with generous spacing
            when (selectedTab) {
                0 -> HelenBiografiaContent(cardBg, primaryPurple)
                1 -> HelenAportesContent(cardBg, primaryPurple)
                2 -> HelenCuriosidadesContent(cardBg, primaryPurple)
            }

            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
fun HelenBiografiaContent(cardBg: Color, primaryColor: Color) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // ¿Quién fue? Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(primaryColor.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Person, contentDescription = null, tint = primaryColor, modifier = Modifier.size(18.dp))
                    }
                    Text(text = "¿Quién fue?", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Física, oceanógrafa, autora y comunicadora científica que estudia cómo las burbujas y las olas influyen en el océano y el clima.",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )
            }
        }

        // Info Grid (Nacimiento, Lugar, Nacionalidad)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Icon(Icons.Default.Cake, contentDescription = null, tint = primaryColor, modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Nacimiento", fontSize = 12.sp, color = Color.Gray)
                    Text(text = "1 de noviembre de 1978", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
                }
            }

            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Icon(Icons.Default.LocationOn, contentDescription = null, tint = primaryColor, modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Lugar de nacimiento", fontSize = 12.sp, color = Color.Gray)
                    Text(text = "Manchester, Inglaterra", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Icon(Icons.Default.Public, contentDescription = null, tint = primaryColor, modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Nacionalidad", fontSize = 12.sp, color = Color.Gray)
                    Text(text = "Británica", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
                }
            }

            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Icon(Icons.AutoMirrored.Filled.MenuBook, contentDescription = null, tint = primaryColor, modifier = Modifier.size(24.dp))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Especialidad", fontSize = 12.sp, color = Color.Gray)
                    Text(text = "Física de océanos y burbujas", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
                }
            }
        }

        // Fechas importantes Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(primaryColor.copy(alpha = 0.1f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Event, contentDescription = null, tint = primaryColor, modifier = Modifier.size(18.dp))
                    }
                    Text(text = "Fechas importantes", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
                }
                Spacer(modifier = Modifier.height(16.dp))

                TimelineItem(year = "2001", text = "Se graduó en física en la Universidad de Cambridge.")
                Spacer(modifier = Modifier.height(12.dp))
                TimelineItem(year = "2006", text = "Obtuvo el doctorado en física teórica.")
                Spacer(modifier = Modifier.height(12.dp))
                TimelineItem(year = "2011", text = "Comenzó a presentar destacados programas científicos para la BBC.")
                Spacer(modifier = Modifier.height(12.dp))
                TimelineItem(year = "2023", text = "Publicó su aclamado libro The Blue Machine sobre los océanos.")
            }
        }

        // Footer Quote Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F5FC)),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Row(
                modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "❝", fontSize = 36.sp, color = primaryColor, fontWeight = FontWeight.Bold)
                Text(
                    text = "Lo cotidiano está lleno de física esperando ser observada.",
                    fontSize = 13.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.DarkGray,
                    lineHeight = 18.sp
                )
            }
        }
    }
}

@Composable
fun HelenAportesContent(cardBg: Color, primaryColor: Color) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Header card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Default.Science, contentDescription = null, tint = primaryColor)
                    Text(text = "Principales aportes", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
                }
            }
        }

        // Bubbles physics Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Física de las burbujas", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Investiga la física de las burbujas y el intercambio de gases entre el océano y la atmósfera.",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )
            }
        }

        // Row of 2 cards (Breaking waves & Scientific communication)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Estudio de olas rompientes", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "Analiza cómo se forman y rompen las olas y su papel en los procesos oceánicos.", fontSize = 12.sp, color = Color.Gray, lineHeight = 16.sp)
                }
            }

            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Divulgación científica", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "Comunica la ciencia mediante libros, radio y televisión, acercando la física al público.", fontSize = 12.sp, color = Color.Gray, lineHeight = 16.sp)
                }
            }
        }

        // Impact card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Impacto en la ciencia y la sociedad", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Ayuda a mejorar la comprensión de procesos oceánicos relevantes para modelos climáticos y fortalece la cultura científica.",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )
            }
        }
    }
}

@Composable
fun HelenCuriosidadesContent(cardBg: Color, primaryColor: Color) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        // Header card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Default.Lightbulb, contentDescription = null, tint = DataMujerYellow)
                    Text(text = "Datos curiosos", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Campañas en el mar", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Ha trabajado en campañas científicas internacionales directamente en alta mar.",
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    lineHeight = 18.sp
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Objetos cotidianos", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Usa objetos cotidianos para explicar física compleja de forma accesible e intuitiva.",
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    lineHeight = 18.sp
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Profesora en UCL", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Es profesora e investigadora en University College London (UCL).",
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    lineHeight = 18.sp
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Medalla Kelvin", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Recibió la Medalla Kelvin del Institute of Physics en 2018 por su trabajo en divulgación.",
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    lineHeight = 18.sp
                )
            }
        }
    }
}
