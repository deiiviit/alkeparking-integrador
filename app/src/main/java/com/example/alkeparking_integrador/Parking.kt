package com.example.alkeparking_integrador

// El set admites unicos, no pueden ver 2 vehiculos en el la misma plate

data class Parking(val vehicles: MutableSet<String>) {
}

