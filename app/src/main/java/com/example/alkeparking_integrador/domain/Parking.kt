package com.example.alkeparking_integrador.domain

import com.example.alkeparking_integrador.modelo.ParkingSpace
import com.example.alkeparking_integrador.modelo.Vehicle


// El set admites unicos, no pueden ver 2 vehiculos en el la misma plate

const val MAXIMUM_CAPACITY: Int = 20

//Se crea la propiedad total registro y estará inicializada en 0, tanto cantidad de vehiculos salientes como las ganancias
var totalRecord: Pair<Int, Int> = Pair(0, 0)

data class Parking(var vehicles: MutableSet<Vehicle>) {


    val listParkingSpace = mutableListOf<ParkingSpace>()
    fun initOrResetParkingSpaces() {
        vehicles.forEach {
            val parkingSpaceAux = ParkingSpace(it)
            listParkingSpace.add(parkingSpaceAux)
        }
    }

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
     * Metodo encargado de eliminar un vehiculo del mutableset y  llamar a checkout de parkingSpace
     */
    fun delVehicle(vehicle: Vehicle): Boolean {
        var parkingSpace = ParkingSpace(vehicle)
        if (vehicles.contains(vehicle)) {
            vehicles.remove(vehicle)
            parkingSpace?.let {
                it.checkOutVehicle(vehicle.plate) { it.onSuccess() }
                updateTotalRecord(it)
            }
            return true
        } else {
            parkingSpace?.let {
                it.checkOutVehicle(vehicle.plate) { it.onError() }
            }
            return false
        }
    }

    /**
     * Metodo para listar vehiculos por placa
     */
    fun listVehicles(): MutableSet<String> {
        val listPlates = mutableSetOf<String>()
        vehicles.forEach { listPlates.add(it.plate) }
        return listPlates
    }


    /**
     * Se llama el metodo cada vez que se elimine un vehiculo y para obtener las ganancias se encapsulo las ganancias del metodo onSuccess,
     * que a su vez hace llamado al metodo checkOut
     */
    fun updateTotalRecord(parkingSpace: ParkingSpace) {
        var totalVehiclesChecked = totalRecord.first + 1
        var totalEarnings = totalRecord.second + (parkingSpace.fee ?: 0)
        totalRecord = totalRecord.copy(first = totalVehiclesChecked, second = totalEarnings)
        println(totalRecord)
    }

}

