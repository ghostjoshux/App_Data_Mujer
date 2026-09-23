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
fun EmmyNoetherDetailScreen(
    onBack: () -> Unit,
    onFollowExploring: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(0) } // 0: Biografía, 1: Aportes, 2: Curiosidades
    var isFavorite by remember { mutableStateOf(false) }
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
                    onClick = { isFavorite = !isFavorite },
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
                        painter = painterResource(id = R.drawable.emmy_noether_perfil),
                        contentDescription = "Emmy Noether",
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
                            text = "\"La simetría revela las reglas invisibles del universo.\"",
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic,
                            color = Color.DarkGray,
                            lineHeight = 16.sp
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "— EMMY NOETHER",
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
                        text = "Emmy Noether",
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
                            Text(text = "π", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryPurple)
                            Text(
                                text = "MATEMÁTICAS",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = primaryPurple
                            )
                        }
                    }
                }

                Text(
                    text = "Matemáticas",
                    fontSize = 15.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 2.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Info row (Location, Birth, Death)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        InfoItem(icon = Icons.Default.LocationOn, label = "Erlangen,\nAlemania")
                        VerticalDivider(modifier = Modifier.height(36.dp), color = Color.LightGray.copy(alpha = 0.5f))
                        InfoItem(icon = Icons.Default.CalendarToday, label = "23 de marzo\nde 1882")
                        VerticalDivider(modifier = Modifier.height(36.dp), color = Color.LightGray.copy(alpha = 0.5f))
                        InfoItem(icon = Icons.Default.Event, label = "14 de abril\nde 1935")
                    }
                }
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
                0 -> EmmyBiografiaContent(cardBg, primaryPurple)
                1 -> EmmyAportesContent(cardBg, primaryPurple)
                2 -> EmmyCuriosidadesContent(cardBg, primaryPurple)
            }

            Spacer(modifier = Modifier.height(48.dp))
        }
    }
}

@Composable
fun EmmyBiografiaContent(cardBg: Color, primaryColor: Color) {
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
                    text = "Matemática que transformó el álgebra moderna y estableció una conexión fundamental entre simetrías y leyes de conservación.",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )
            }
        }

        // Info Grid (Nacionalidad & Especialidad)
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
                    Text(text = "Alemana", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = DataMujerDark)
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
                    Text(text = "Álgebra abstracta y física matemática", fontSize = 13.sp, fontWeight = FontWeight.Bold, color = DataMujerDark, maxLines = 3)
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

                TimelineItem(year = "1907", text = "Obtuvo el doctorado en la Universidad de Erlangen.")
                Spacer(modifier = Modifier.height(12.dp))
                TimelineItem(year = "1915", text = "Llegó a Göttingen invitada por David Hilbert y Felix Klein.")
                Spacer(modifier = Modifier.height(12.dp))
                TimelineItem(year = "1918", text = "Publicó el famoso teorema de Noether sobre simetrías y leyes de conservación.")
                Spacer(modifier = Modifier.height(12.dp))
                TimelineItem(year = "1933", text = "Emigró a Estados Unidos tras ser expulsada por el régimen nazi.")
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
                    text = "Su teorema es esencial en mecánica, relatividad y física de partículas; su álgebra estructuró gran parte de la matemática actual.",
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
fun EmmyAportesContent(cardBg: Color, primaryColor: Color) {
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

        // Noether Theorem Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = cardBg),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(text = "Teorema de Noether", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Relaciona cada simetría continua de un sistema físico con una cantidad conservada (como la energía o el momento angular).",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    lineHeight = 20.sp
                )
            }
        }

        // Row of 2 cards (Rings & Ideals & Modern Algebra)
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
                    Text(text = "Teoría de anillos e ideales", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "Desarrolló la teoría de anillos e ideales, base del álgebra abstracta moderna.", fontSize = 12.sp, color = Color.Gray, lineHeight = 16.sp)
                }
            }

            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = cardBg),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Álgebra moderna", fontSize = 14.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(text = "Fundó métodos centrales del álgebra abstracta que siguen siendo fundamentales en la actualidad.", fontSize = 12.sp, color = Color.Gray, lineHeight = 16.sp)
                }
            }
        }
    }
}

@Composable
fun EmmyCuriosidadesContent(cardBg: Color, primaryColor: Color) {
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
                Text(text = "Cursos bajo el nombre de Hilbert", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Durante años, debido a las restricciones de género, sus cursos en Göttingen aparecieron oficialmente anunciados bajo el nombre de David Hilbert.",
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
                Text(text = "Elogio de Einstein", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Albert Einstein la describió en una carta al New York Times como el genio matemático creativo más importante producido desde que comenzó la educación superior de las mujeres.",
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
                Text(text = "Bryn Mawr College", fontSize = 15.sp, fontWeight = FontWeight.Bold, color = primaryColor)
                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Tras escapar de la persecución nazi en Alemania, encontró refugio y continuó su brillante labor académica en Estados Unidos.",
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    lineHeight = 18.sp
                )
            }
        }
    }
}
