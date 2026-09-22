package com.example.app_data_mujer

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_data_mujer.ui.theme.*

@Composable
fun InfoDataMujerScreen(onBack: () -> Unit) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Header Top with back arrow overlaying the waves
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                WavyHeader()

                // Small Back Button
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 48.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Regresar",
                        tint = Color.Black,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Central Logo
            Image(
                painter = painterResource(id = R.drawable.logo_data_mujer),
                contentDescription = "Data Mujer Logo",
                modifier = Modifier
                    .size(140.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Main Title
            Text(
                text = "Ciencia con más voces",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = DataMujerDark,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description text
            Text(
                text = "Data Mujer impulsa oportunidades,\neducación y participación de las mujeres en\nciencia y tecnología.",
                fontSize = 15.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp,
                modifier = Modifier.padding(horizontal = 32.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Mission Box
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFE4F5F6))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "NUESTRA MISIÓN",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = DataMujerTeal
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Nuestra misión es impulsar a las mujeres de todas las edades a incursionar en el campo de las ciencias de datos y brindarles capacitación y acompañamiento para que puedan desarrollarse profesionalmente en esta área, mejorar su calidad de vida y aportar al desarrollo socioeconómico del país.",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = DataMujerDark,
                        lineHeight = 22.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Links Section Header
            Text(
                text = "Conoce más",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = DataMujerDark,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 24.dp, end = 24.dp, bottom = 12.dp),
                textAlign = TextAlign.Start
            )

            // Links List Items
            InfoLinkItem(
                text = "datamujer.com",
                bulletColor = DataMujerTeal,
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.datamujer.com/"))
                    context.startActivity(intent)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            InfoLinkItem(
                text = "asociacion@datamujer.com",
                bulletColor = DataMujerPink,
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:asociacion@datamujer.com")
                    }
                    context.startActivity(intent)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            InfoLinkItem(
                text = "San José, Costa Rica",
                bulletColor = Color(0xFF9575CD),
                onClick = {}
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun InfoLinkItem(text: String, bulletColor: Color, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF7F9FA))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(bulletColor)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                fontSize = 15.sp,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoDataMujerScreenPreview() {
    App_Data_MujerTheme {
        InfoDataMujerScreen(onBack = {})
    }
}
