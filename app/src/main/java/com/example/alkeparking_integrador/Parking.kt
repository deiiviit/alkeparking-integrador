package com.example.alkeparking_integrador

// Why do we use vehicles as a Set?
// Set contains the HashCode function, which makes sure the element is unique

const val MAXIMUM_CAPACITY: Int = 20

data class Parking(var vehicles: MutableSet<Vehicle>) {

    // Check if the vehicle was parked
    private fun checkIn(vehicleAdded: Boolean) {
        if (vehicleAdded) {
            println("Welcome to AlkeParking!")
        } else {
            println("Sorry, the check-in failed")
        }
    }

    // Add vehicle to the parking
    fun addVehicle(vehicle: Vehicle): Boolean {
        var wasAdded = false
        if (vehicles.size < MAXIMUM_CAPACITY) {
            wasAdded = vehicles.add(vehicle)
        }
        checkIn(wasAdded)
        return wasAdded
    }

    // Remove vehicle from the parking
    fun removeVehicle(vehicle: Vehicle) {
        val parkingSpace = ParkingSpace(vehicle)
        val vehicleFound = vehicles.find { it == vehicle }
        vehicleFound?.let {
            parkingSpace.checkOutVehicle(it.plate)
            vehicles.remove(vehicle)
        } ?: parkingSpace.onError()
    }

    // list all vehicles
    fun listVehicles() {
        val listVehicles = vehicles.map { it.plate }
        println("Vehicles in the parking: $listVehicles")
        println("Total vehicles: ${vehicles.size}")
    }
}

