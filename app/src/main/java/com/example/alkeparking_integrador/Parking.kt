package com.example.alkeparking_integrador

// Why do we use vehicles as a Set?
// Set contains the HashCode function, which makes sure the element is unique

const val MAXIMUM_CAPACITY: Int = 20
var totalRecord: Pair<Int, Int> = Pair(0, 0)


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
            updateTotalRecord(parkingSpace)
        } ?: parkingSpace.onError()
    }

    // list all vehicles
    fun listVehicles(): List<String> {
        return vehicles.map { ("${it.plate} ") }
    }

    // Calculate the total amount of money earned and the total number of vehicles
    private fun updateTotalRecord(parkingSpace: ParkingSpace) {
        val totalVehiclesChecked = totalRecord.first + 1
        val totalEarnings = totalRecord.second + (parkingSpace.fee ?: 0)
        totalRecord = totalRecord.copy(first = totalVehiclesChecked, second = totalEarnings)
    }
    // Show the total amount of money earned and the total number of vehicles
    fun getTotalRecord() {
        println("${totalRecord.first} vehicles have checked out and have earnings of $${totalRecord.second}")
    }
}

