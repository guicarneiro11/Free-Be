package com.guicarneirodev.freebe.android.presentation.screens.registration

sealed class DriverRegistrationEvent {
    data class NameChanged(val name: String) : DriverRegistrationEvent()
    data class CpfChanged(val cpf: String) : DriverRegistrationEvent()
    data class RntrcChanged(val rntrc: String) : DriverRegistrationEvent()
    data class BirthDateChanged(val birthDate: String) : DriverRegistrationEvent()
    data class CnhNumberChanged(val cnhNumber: String) : DriverRegistrationEvent()
    data class CnhCategoryChanged(val category: String) : DriverRegistrationEvent()
    data class CnhExpirationChanged(val expiration: String) : DriverRegistrationEvent()
    data class VehiclePlateChanged(val plate: String) : DriverRegistrationEvent()
    data class RenavamChanged(val renavam: String) : DriverRegistrationEvent()
    data class VehicleTypeChanged(val type: String) : DriverRegistrationEvent()
    data class LoadCapacityChanged(val capacity: String) : DriverRegistrationEvent()
    data class BodyworkTypeChanged(val type: String) : DriverRegistrationEvent()
    data class CompartmentLengthChanged(val length: String) : DriverRegistrationEvent()
    data class CompartmentWidthChanged(val width: String) : DriverRegistrationEvent()
    data class CompartmentHeightChanged(val height: String) : DriverRegistrationEvent()
}