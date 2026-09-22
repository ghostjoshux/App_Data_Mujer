package com.example.app_data_mujer

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app_data_mujer.ui.theme.*
import kotlinx.coroutines.delay
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onBack: () -> Unit, onLoginSuccess: (String) -> Unit) {
    var name by remember { mutableStateOf("") }
    var selectedScience by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var showErrorMsg by remember { mutableStateOf(false) }

    val sciences = listOf(
        "Matematicas", "Fisica", "Quimica", "Biologia", 
        "Medicina", "Astronomia", "Computacion", "Ingenieria"
    )

    val facts = listOf(
        "¡Las mujeres representan menos del 30% de los investigadores en el mundo!",
        "Marie Curie fue la primera persona en recibir dos premios Nobel en distintas especialidades.",
        "Ada Lovelace escribió el primer algoritmo destinado a ser procesado por una máquina.",
        "Katherine Johnson calculó las trayectorias de vuelo del proyecto Apollo de la NASA.",
        "Rosalind Franklin fue clave para descubrir la estructura de doble hélice del ADN.",
        "Grace Hopper inventó el primer compilador para un lenguaje de programación.",
        "Chien-Shiung Wu demostró experimentalmente que la ley de conservación de la paridad no se cumple.",
        "Jane Goodall revolucionó el estudio de los primates y la conservación de la naturaleza."
    )

    var currentFactIndex by remember { mutableStateOf(Random.nextInt(facts.size)) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(6000)
            var nextIndex = Random.nextInt(facts.size)
            while (nextIndex == currentFactIndex) {
                nextIndex = Random.nextInt(facts.size)
            }
            currentFactIndex = nextIndex
        }
    }

    val isFormValid = name.isNotBlank() && selectedScience.isNotBlank()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Regresar")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFEDF7F9))
            )
        },
        containerColor = Color(0xFFEDF7F9)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Logo Image
            Image(
                painter = painterResource(id = R.drawable.logo_data_mujer),
                contentDescription = "Data Mujer Logo",
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Fields
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "¿Cual es tu nombre?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                OutlinedTextField(
                    value = name,
                    onValueChange = { 
                        name = it 
                        if (it.isNotBlank() && selectedScience.isNotBlank()) showErrorMsg = false
                    },
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedBorderColor = DataMujerTeal,
                        unfocusedBorderColor = Color.LightGray
                    )
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "¿Qué ciencia le gusta?",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                
                Box(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = selectedScience,
                        onValueChange = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expanded = true },
                        readOnly = true,
                        placeholder = { Text("Selecciona una ciencia", color = Color.Gray) },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = null,
                                modifier = Modifier.clickable { expanded = true }
                            )
                        },
                        shape = RoundedCornerShape(12.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            focusedBorderColor = DataMujerTeal,
                            unfocusedBorderColor = Color.LightGray
                        ),
                        enabled = true
                    )
                    
                    // Transparent overlay to safely handle click on entire field
                    Box(
                        modifier = Modifier
                            .matchParentSize()
                            .clickable { expanded = true }
                    )

                    DropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .background(Color.White)
                    ) {
                        sciences.forEach { science ->
                            DropdownMenuItem(
                                text = { Text(science) },
                                onClick = {
                                    selectedScience = science
                                    expanded = false
                                    if (name.isNotBlank()) showErrorMsg = false
                                }
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            if (showErrorMsg) {
                Text(
                    text = "Rellene los espacios",
                    color = Color.Red,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            // Button
            Button(
                onClick = { 
                    if (!isFormValid) {
                        showErrorMsg = true
                    } else {
                        showErrorMsg = false
                        onLoginSuccess(name)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = DataMujerTeal
                ),
                shape = RoundedCornerShape(28.dp)
            ) {
                Text(
                    text = "Iniciar sesión", 
                    fontWeight = FontWeight.Bold, 
                    fontSize = 18.sp,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            // Fun Fact Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .border(1.dp, Color(0xFFE0E0E0), RoundedCornerShape(16.dp)),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Info,
                        contentDescription = null,
                        tint = Color.DarkGray,
                        modifier = Modifier
                            .size(36.dp)
                            .padding(end = 8.dp)
                    )
                    
                    AnimatedContent(
                        targetState = currentFactIndex,
                        transitionSpec = {
                            fadeIn().togetherWith(fadeOut())
                        },
                        label = "FactAnimation"
                    ) { index ->
                        val factText = facts[index]
                        val annotatedString = buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                                append("Dato Curioso: ")
                            }
                            append(factText)
                            withStyle(style = SpanStyle(color = DataMujerTeal, fontWeight = FontWeight.Medium)) {
                                append(" #DataMujer")
                            }
                        }
                        Text(
                            text = annotatedString,
                            fontSize = 13.sp,
                            color = Color.Black,
                            lineHeight = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    App_Data_MujerTheme {
        LoginScreen(onBack = {}, onLoginSuccess = {})
    }
}
