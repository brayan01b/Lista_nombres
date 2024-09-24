package com.example.navegacion.Screen

import PersonasViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.lifecycle.viewmodel.compose.viewModel


import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color


@Composable
fun ScreenA(navController: NavController, viewModel: PersonasViewModel = viewModel()) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var apellido by rememberSaveable { mutableStateOf("") }
    var edad by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Ingrese sus datos", color = Color.Blue)
        Spacer(modifier = Modifier.height(26.dp))
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Ingrese su nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(26.dp))
        TextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Ingrese su apellido") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(26.dp))
        TextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Ingrese su edad") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()

        )
        Spacer(modifier = Modifier.height(26.dp))
        Button(onClick = {
            if (nombre.isNotEmpty() && apellido.isNotEmpty() && edad.isNotEmpty()) {
                // Agregar persona al ViewModel
                viewModel.agregarPersona(nombre, apellido, edad)

                // Navegar a ScreenB
                navController.navigate("screen_b")
            }
        }) {
            Text("Ir a Pantalla B")
        }
    }
}
