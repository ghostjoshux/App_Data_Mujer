package com.example.app_data_mujer

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_data_mujer.ui.theme.*

@Composable
fun StartScreen(onNavigateToLogin: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            WavyHeader()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "DATA\nMUJER",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = DataMujerDark,
                textAlign = TextAlign.Center,
                lineHeight = 36.sp
            )

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Descubre a las mujeres\nque cambiaron la\nciencia",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = DataMujerDark,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp),
                lineHeight = 34.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Explora historias, aportes y curiosidades de\ncientíficas increíbles de todo el mundo.",
                fontSize = 16.sp,
                color = DataMujerGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 48.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            IllustrationGraphic()

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onNavigateToLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = DataMujerDark),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = "Comenzar a explorar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Una experiencia educativa de Data Mujer",
                fontSize = 12.sp,
                color = DataMujerGray,
                modifier = Modifier.padding(bottom = 32.dp)
            )
        }
    }
}

@Composable
fun WavyHeader() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
    ) {
        val width = size.width
        val height = size.height

        // Teal Wave
        val tealPath = Path().apply {
            moveTo(0f, 0f)
            lineTo(width, 0f)
            lineTo(width, height * 0.8f)
            quadraticTo(width * 0.75f, height, width * 0.5f, height * 0.9f)
            quadraticTo(width * 0.25f, height * 0.8f, 0f, height * 0.9f)
            close()
        }
        drawPath(tealPath, color = DataMujerTeal)

        // Pink Wave Detail
        val pinkPath = Path().apply {
            moveTo(0f, 0f)
            lineTo(width, 0f)
            lineTo(width, height * 0.3f)
            quadraticTo(width * 0.8f, height * 0.1f, width * 0.5f, height * 0.25f)
            quadraticTo(width * 0.2f, height * 0.4f, 0f, height * 0.2f)
            close()
        }
        drawPath(pinkPath, color = DataMujerPink)
    }
}

@Composable
fun IllustrationGraphic() {
    Box(
        modifier = Modifier
            .size(width = 280.dp, height = 180.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(DataMujerLavender),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Circle with Yellow Center
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(DataMujerYellow)
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Pink Box with Female Symbol
                Box(
                    modifier = Modifier
                        .size(width = 100.dp, height = 60.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(DataMujerPink),
                    contentAlignment = Alignment.Center
                ) {
                    Text("♀", color = Color.White, fontSize = 24.sp)
                }

                // Teal Box with Sparkle
                Box(
                    modifier = Modifier
                        .size(width = 120.dp, height = 60.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(DataMujerTeal),
                    contentAlignment = Alignment.Center
                ) {
                    Text("✦", color = Color.White, fontSize = 24.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StartScreenPreview() {
    App_Data_MujerTheme {
        StartScreen(onNavigateToLogin = {})
    }
}
