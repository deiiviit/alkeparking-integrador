package com.example.alkeparking_integrador.domain

import com.example.alkeparking_integrador.modelo.ParkingSpace
import com.example.alkeparking_integrador.modelo.Vehicle

// Why do we use vehicles as a Set?
// Set contains the HashCode function, which makes sure the element is unique


//Constant to limit the number of vehicles allowed
const val MAXIMUM_CAPACITY: Int = 20

//Property totalRecord of type Pair where the total number of vehicles that have left the parking lot and the profits will be stored
var totalRecord: Pair<Int, Int> = Pair(0, 0)

data class Parking(var vehicles: MutableSet<Vehicle>) {
    /**
     * Method in charge of adding a vehicle to the MutableSet
     *The existence of the vehicle by license plate in the MutableSet is validated
     * * The maximum number of vehicles that can be held in the parking lot is validated
     * * @param vehicle Object to add in the MutableSet
     * @return Boolean true if it could be added successfully or false otherwise
     */
    fun addVehicle(vehicle: Vehicle): Boolean {
        var wasAdded = false
        if (vehicle in vehicles) {
            println("Sorry, the has check-in failed")
            return wasAdded
        }
        if (vehicles.size < MAXIMUM_CAPACITY) {
            wasAdded = vehicles.add(vehicle)
        }
        checkIn(wasAdded)
        return wasAdded
    }

    /**
     * Method that validates if the vehicle was added or not
     * Method called from addVehicle
     * @param vehicleAdded Indicates if the vehicle was added
     */
    private fun checkIn(vehicleAdded: Boolean) {
        if (vehicleAdded) {
            println("Welcome to AlkeParking!")
        } else {
            println("Sorry, the check-in failed")
        }
    }

    /**
     * Method responsible for removing a vehicle from the MutableSet
     * An instance of parkingSpace is created to call the checkOutVehicle method and calculateFee
     * .find is used to know if the vehicle that receives the method as an object is in the MutableSet
     * Through the parkingSpace instance, the checkOutVehicle method is accessed
     * The vehicle object is removed from the MutableSet
     * @param vehicle Object to delete in the MutableSet
     */
    fun removeVehicle(vehicle: Vehicle) {
        val parkingSpace = ParkingSpace(vehicle)
        //parkingSpace.checkOutVehicle(it.plate)
        parkingSpace.checkOutVehicle(
            vehicle.plate,
            { (parkingSpace.onSuccess(parkingSpace.fee)) },
            { parkingSpace.onError() },
            vehicles
        )
        if (vehicles.remove(vehicle)) {
            vehicles.remove(vehicle)
            updateTotalRecord(parkingSpace)
        }
    }

    /**
     * Method that prints a list of plates of the entered vehicles
     */
//    fun listVehicles(): MutableSet<String> {
//        return vehicles.map { println(vehicles) }.toMutableSet()
//    }

    /**
     * Method that updates the number of vehicles removed from the parking lot with the total earnings
     *Two variables are used to store the number of withdrawn vehicles and the rate of each of them
     */
    private fun updateTotalRecord(parkingSpace: ParkingSpace) {
        val totalVehiclesChecked = totalRecord.first + 1
        val totalEarnings = totalRecord.second + (parkingSpace.fee ?: 0)
        totalRecord = totalRecord.copy(first = totalVehiclesChecked, second = totalEarnings)
    }

    /**
     * Method that obtains the number of vehicles and the total rate of each one by accessing each field of the pair
     * Prints a message showing the number of outgoing vehicles and the total earnings
     */
    fun getTotalRecord() {
        println("${totalRecord.first} vehicles have checked out and have earnings of $${totalRecord.second}")
    }
}

