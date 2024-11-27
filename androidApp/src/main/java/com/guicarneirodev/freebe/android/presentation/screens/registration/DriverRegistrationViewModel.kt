package com.guicarneirodev.freebe.android.presentation.screens.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DriverRegistrationViewModel : ViewModel() {
    private val _state = MutableStateFlow(DriverRegistrationState())
    val state: StateFlow<DriverRegistrationState> = _state.asStateFlow()

    fun onEvent(event: DriverRegistrationEvent) {
        when (event) {
            is DriverRegistrationEvent.NameChanged -> {
                _state.value = _state.value.copy(name = event.name)
            }
            is DriverRegistrationEvent.CpfChanged -> {
                if (event.cpf.length <= 11) {
                    _state.value = _state.value.copy(cpf = event.cpf.filter { it.isDigit() })
                }
            }
            is DriverRegistrationEvent.RntrcChanged -> {
                _state.value = _state.value.copy(rntrc = event.rntrc)
            }
            is DriverRegistrationEvent.BirthDateChanged -> {
                if (event.birthDate.length <= 8) {
                    _state.value = _state.value.copy(birthDate = event.birthDate.filter { it.isDigit() })
                }
            }
            is DriverRegistrationEvent.CnhNumberChanged -> {
                _state.value = _state.value.copy(cnhNumber = event.cnhNumber)
            }
            is DriverRegistrationEvent.CnhCategoryChanged -> {
                _state.value = _state.value.copy(cnhCategory = event.category.uppercase())
            }
            is DriverRegistrationEvent.CnhExpirationChanged -> {
                if (event.expiration.length <= 8) {
                    _state.value = _state.value.copy(cnhExpiration = event.expiration.filter { it.isDigit() })
                }
            }
            is DriverRegistrationEvent.VehiclePlateChanged -> {
                _state.value = _state.value.copy(vehiclePlate = event.plate.uppercase())
            }
            is DriverRegistrationEvent.RenavamChanged -> {
                _state.value = _state.value.copy(renavam = event.renavam)
            }
            is DriverRegistrationEvent.VehicleTypeChanged -> {
                _state.value = _state.value.copy(vehicleType = event.type)
            }
            is DriverRegistrationEvent.LoadCapacityChanged -> {
                _state.value = _state.value.copy(loadCapacity = event.capacity)
            }
            is DriverRegistrationEvent.BodyworkTypeChanged -> {
                _state.value = _state.value.copy(bodyworkType = event.type)
            }
            is DriverRegistrationEvent.CompartmentLengthChanged -> {
                _state.value = _state.value.copy(compartmentLength = event.length)
            }
            is DriverRegistrationEvent.CompartmentWidthChanged -> {
                _state.value = _state.value.copy(compartmentWidth = event.width)
            }
            is DriverRegistrationEvent.CompartmentHeightChanged -> {
                _state.value = _state.value.copy(compartmentHeight = event.height)
            }
        }
    }

    fun onRegisterClick() {
        viewModelScope.launch {
            try {
                _state.value = _state.value.copy(
                    isLoading = true,
                    error = null
                )

                if (!validateFields()) {
                    return@launch
                }

                // TODO: Implementar chamada para API/Repository
                delay(1500) // Simulando chamada de rede

                _state.value = _state.value.copy(
                    isLoading = false,
                    registrationSuccess = true
                )

            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message ?: "Erro ao realizar cadastro"
                )
            }
        }
    }

    private fun validateFields(): Boolean {
        val currentState = _state.value

        when {
            currentState.name.length < 3 -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "Nome deve ter pelo menos 3 caracteres"
                )
                return false
            }
            !isValidCPF(currentState.cpf) -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "CPF inválido"
                )
                return false
            }
            currentState.rntrc.length < 8 -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "RNTRC inválido"
                )
                return false
            }
            !isValidDate(currentState.birthDate) -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "Data de nascimento inválida"
                )
                return false
            }
            currentState.cnhNumber.length < 11 -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "Número da CNH inválido"
                )
                return false
            }
            !isValidCnhCategory(currentState.cnhCategory) -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "Categoria da CNH inválida"
                )
                return false
            }
            !isValidDate(currentState.cnhExpiration) -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "Data de validade da CNH inválida"
                )
                return false
            }
            !isValidPlate(currentState.vehiclePlate) -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "Placa do veículo inválida"
                )
                return false
            }
            currentState.renavam.length != 11 -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "RENAVAM inválido"
                )
                return false
            }
            currentState.vehicleType.isBlank() -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "Selecione o tipo do veículo"
                )
                return false
            }
            currentState.loadCapacity.isBlank() -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "Informe a capacidade de carga"
                )
                return false
            }
            currentState.bodyworkType.isBlank() -> {
                _state.value = currentState.copy(
                    isLoading = false,
                    error = "Selecione o tipo de carroceria"
                )
                return false
            }
        }

        return true
    }

    private fun isValidCPF(cpf: String): Boolean {
        val numbers = cpf.filter { it.isDigit() }
        if (numbers.length != 11) return false

        // Implementar validação completa do CPF
        return true // Simplificado para o exemplo
    }

    private fun isValidDate(date: String): Boolean {
        try {
            val formatter = DateTimeFormatter.ofPattern("ddMMyyyy")
            val parsedDate = LocalDate.parse(date, formatter)
            return true
        } catch (e: Exception) {
            return false
        }
    }

    private fun isValidCnhCategory(category: String): Boolean {
        val validCategories = listOf("A", "B", "C", "D", "E", "AB", "AC", "AD", "AE")
        return validCategories.contains(category.uppercase())
    }

    private fun isValidPlate(plate: String): Boolean {
        // Implementar validação de placa
        // Formato antigo: ABC-1234
        // Formato Mercosul: ABC1D23
        return plate.length in listOf(7, 8)
    }
}