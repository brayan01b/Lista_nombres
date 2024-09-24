package com.example.navegacion.Screen

import PersonasViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp

@Composable
fun ScreenB(navController: NavController, viewModel: PersonasViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (viewModel.listaPersonas.isEmpty()) {
            Text("No hay personas registradas")
        } else {
            // Mostrar la lista de personas
            viewModel.listaPersonas.forEach { persona ->
                Text("Nombre: ${persona.first}, Apellido: ${persona.second}, Edad: ${persona.third}")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("Volver a Pantalla A")
        }
    }
}
