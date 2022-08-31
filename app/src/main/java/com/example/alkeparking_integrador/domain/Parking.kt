package com.example.alkeparking_integrador.modelo


// El set admites unicos, no pueden ver 2 vehiculos en el la misma plate

const val MAXIMUM_CAPACITY: Int = 20

data class Parking(var vehicles: MutableSet<Vehicle>) {

    /**
     * Metodo encargado de la validacion de la placa y del llamado del método añadir vehiculo
     */
    fun checkIn(vehicle: Vehicle): String {
        var filteredVehicles = vehicles.filter { it == vehicle }
        if (filteredVehicles.isNotEmpty()) {
            return "Sorry, the has check-in failed"
        }
        return if (addVehicle(vehicle)) "Welcome to AlkeParking!" else "Sorry, the check-in failed"
    }

    /**
     * Metodo encargado de añadir vehiculo al mutableSet de vehiculo
     */
    private fun addVehicle(vehicle: Vehicle): Boolean {
        if (vehicles.size < MAXIMUM_CAPACITY) {
            vehicles.add(vehicle)
            return true
        }
        return false
    }

    /**
     * Metodo para listar vehiculos por placa
     */
    fun listVehicles(): MutableSet<String> {
        val listPlates = mutableSetOf<String>()
        vehicles.forEach { listPlates.add(it.plate) }
        return listPlates
    }
}

