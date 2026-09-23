package com.example.app_data_mujer

import androidx.compose.foundation.Image
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.animation.core.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
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

            Image(
                painter = painterResource(id = R.drawable.logo_data_mujer),
                contentDescription = "Data Mujer Logo",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 80.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Descubre a las mujeres\nque cambiaron la\nciencia",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = DataMujerDark,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 32.dp),
                lineHeight = 34.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Explora historias, aportes y curiosidades de\ncientíficas increíbles de todo el mundo.",
                fontSize = 16.sp,
                color = DataMujerGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            IllustrationGraphic()

            Spacer(modifier = Modifier.height(32.dp))

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

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Una experiencia educativa de Data Mujer",
                fontSize = 14.sp,
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
    val infiniteTransition = rememberInfiniteTransition(label = "illustrationAnimation")

    val discScale by infiniteTransition.animateFloat(
        initialValue = 0.90f,
        targetValue = 1.12f,
        animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "discScale"
    )

    val discFloat by infiniteTransition.animateFloat(
        initialValue = -8f,
        targetValue = 8f,
        animationSpec = infiniteRepeatable(
            animation = tween(2200, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "discFloat"
    )

    val pinkFloat by infiniteTransition.animateFloat(
        initialValue = -10f,
        targetValue = 10f,
        animationSpec = infiniteRepeatable(
            animation = tween(1600, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pinkFloat"
    )

    val tealFloat by infiniteTransition.animateFloat(
        initialValue = 10f,
        targetValue = -10f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "tealFloat"
    )

    Box(
        modifier = Modifier
            .size(width = 280.dp, height = 180.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(DataMujerLavender),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Circle with Yellow Center (Pulsing and floating safely)
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .graphicsLayer {
                        translationY = discFloat
                        scaleX = discScale
                        scaleY = discScale
                    }
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
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
                        .size(width = 95.dp, height = 55.dp)
                        .graphicsLayer {
                            translationY = pinkFloat
                        }
                        .clip(RoundedCornerShape(12.dp))
                        .background(DataMujerPink),
                    contentAlignment = Alignment.Center
                ) {
                    Text("♀", color = Color.White, fontSize = 22.sp)
                }

                // Teal Box with Sparkle
                Box(
                    modifier = Modifier
                        .size(width = 110.dp, height = 55.dp)
                        .graphicsLayer {
                            translationY = tealFloat
                        }
                        .clip(RoundedCornerShape(12.dp))
                        .background(DataMujerTeal),
                    contentAlignment = Alignment.Center
                ) {
                    Text("✦", color = Color.White, fontSize = 22.sp)
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
