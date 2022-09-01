package com.example.alkeparking_integrador

const val MAXIMUM_CAPACITY: Int = 20

data class Parking(var vehicles: MutableSet<Vehicle>) {

    // Add vehicle to the parking
    fun addVehicle(vehicle: Vehicle): Boolean {
        var wasAdded = false
        val parkingSpace = ParkingSpace(vehicle)
        if (vehicles.size < MAXIMUM_CAPACITY) {
            wasAdded = vehicles.add(vehicle)
        }
        parkingSpace.checkIn(wasAdded)
        return wasAdded
    }

    // Remove vehicle from the parking
    fun removeVehicle(plate: String) {
        val vehicleFound = vehicles.find { it.plate == plate }
        vehicleFound?.let {
            val parkingSpace = ParkingSpace(it)
            vehicles.remove(vehicleFound)
            parkingSpace.checkOutVehicle(plate)
        } ?: println("Sorry, the check-out failed")
    }

    // list all vehicles
    fun listVehicles() {
        val platesList = vehicles.map { it.plate }
        println("Vehicles in the parking: $platesList")
        println("Total vehicles: ${vehicles.size}")
    }
}

