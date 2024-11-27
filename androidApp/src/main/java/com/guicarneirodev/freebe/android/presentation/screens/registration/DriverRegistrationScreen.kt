package com.guicarneirodev.freebe.android.presentation.screens.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.guicarneirodev.freebe.android.presentation.utils.MaskVisualTransformation
import org.koin.androidx.compose.koinViewModel

data class DriverRegistrationState(
    val name: String = "",
    val cpf: String = "",
    val rntrc: String = "",
    val birthDate: String = "",
    val cnhNumber: String = "",
    val cnhCategory: String = "",
    val cnhExpiration: String = "",
    val vehiclePlate: String = "",
    val renavam: String = "",
    val vehicleType: String = "",
    val loadCapacity: String = "",
    val bodyworkType: String = "",
    val compartmentLength: String = "",
    val compartmentWidth: String = "",
    val compartmentHeight: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val registrationSuccess: Boolean = false
)

@Composable
fun DriverRegistrationScreen(
    viewModel: DriverRegistrationViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.primaryContainer
                    )
                )
            )
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cadastro do Motorista",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            modifier = Modifier.padding(vertical = 24.dp)
        )

        // Card de Dados Pessoais
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Dados Pessoais",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )

                RegistrationTextField(
                    value = state.name,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.NameChanged(it)) },
                    label = "Nome Completo",
                    keyboardType = KeyboardType.Text
                )

                RegistrationTextField(
                    value = state.cpf,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.CpfChanged(it)) },
                    label = "CPF",
                    keyboardType = KeyboardType.Number,
                    visualTransformation = MaskVisualTransformation("###.###.###-##")
                )

                RegistrationTextField(
                    value = state.rntrc,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.RntrcChanged(it)) },
                    label = "RNTRC",
                    keyboardType = KeyboardType.Number
                )

                RegistrationTextField(
                    value = state.birthDate,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.BirthDateChanged(it)) },
                    label = "Data de Nascimento",
                    keyboardType = KeyboardType.Number,
                    visualTransformation = MaskVisualTransformation("##/##/####")
                )

                RegistrationTextField(
                    value = state.cnhNumber,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.CnhNumberChanged(it)) },
                    label = "Número da CNH",
                    keyboardType = KeyboardType.Number
                )

                RegistrationTextField(
                    value = state.cnhCategory,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.CnhCategoryChanged(it)) },
                    label = "Categoria da CNH",
                    keyboardType = KeyboardType.Text
                )

                RegistrationTextField(
                    value = state.cnhExpiration,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.CnhExpirationChanged(it)) },
                    label = "Validade da CNH",
                    keyboardType = KeyboardType.Number,
                    visualTransformation = MaskVisualTransformation("##/##/####")
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Card de Dados do Veículo
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Dados do Veículo",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )

                RegistrationTextField(
                    value = state.vehiclePlate,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.VehiclePlateChanged(it)) },
                    label = "Placa do Veículo",
                    keyboardType = KeyboardType.Text,
                    visualTransformation = MaskVisualTransformation("###-####")
                )

                RegistrationTextField(
                    value = state.renavam,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.RenavamChanged(it)) },
                    label = "RENAVAM",
                    keyboardType = KeyboardType.Number
                )

                // Dropdown para tipo de veículo
                ExposedDropdownMenuBox(
                    value = state.vehicleType,
                    options = listOf("Truck", "Carreta", "Bitrem", "Rodotrem"),
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.VehicleTypeChanged(it)) },
                    label = "Tipo de Veículo"
                )

                RegistrationTextField(
                    value = state.loadCapacity,
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.LoadCapacityChanged(it)) },
                    label = "Capacidade de Carga (ton)",
                    keyboardType = KeyboardType.Number
                )

                // Dropdown para tipo de carroceria
                ExposedDropdownMenuBox(
                    value = state.bodyworkType,
                    options = listOf("Baú", "Sider", "Graneleiro", "Tanque", "Refrigerado"),
                    onValueChange = { viewModel.onEvent(DriverRegistrationEvent.BodyworkTypeChanged(it)) },
                    label = "Tipo de Carroceria"
                )

                Text(
                    text = "Dimensões do Compartimento",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(top = 8.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    RegistrationTextField(
                        value = state.compartmentLength,
                        onValueChange = { viewModel.onEvent(DriverRegistrationEvent.CompartmentLengthChanged(it)) },
                        label = "Comprimento (m)",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier.weight(1f)
                    )

                    RegistrationTextField(
                        value = state.compartmentWidth,
                        onValueChange = { viewModel.onEvent(DriverRegistrationEvent.CompartmentWidthChanged(it)) },
                        label = "Largura (m)",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier.weight(1f)
                    )

                    RegistrationTextField(
                        value = state.compartmentHeight,
                        onValueChange = { viewModel.onEvent(DriverRegistrationEvent.CompartmentHeightChanged(it)) },
                        label = "Altura (m)",
                        keyboardType = KeyboardType.Number,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {  },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary
            )
        ) {
                Text("Cadastrar")
        }
    }
}

@Composable
fun ExposedDropdownMenuBox(
    value: String,
    options: List<String>,
    onValueChange: (String) -> Unit,
    label: String
) {
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            label = { Text(label) },
            trailingIcon = {
                Icon(
                    imageVector = if (expanded)
                        Icons.Default.KeyboardArrowUp
                    else
                        Icons.Default.KeyboardArrowDown,
                    contentDescription = if (expanded) "Menos opções" else "Mais opções"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onValueChange(option)
                        expanded = false
                    }
                )
            }
        }

        // Área clicável transparente sobre o TextField
        Box(
            modifier = Modifier
                .matchParentSize()
                .clickable { expanded = !expanded }
        )
    }
}

@Composable
fun RegistrationTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        visualTransformation = visualTransformation,
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
        )
    )
}