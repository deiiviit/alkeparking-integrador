package com.example.alkeparking_integrador

import java.util.*
import kotlin.math.ceil

const val MINUTES_IN_MILLISECONDS = 60000

data class ParkingSpace(var vehicle: Vehicle) {

    private val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS

    // Check if the vehicle was parked
    fun checkIn(wasCarAdded: Boolean) {
        if (wasCarAdded) {
            println("Welcome to AlkeParking!")

        } else {
            println("Sorry, the check-in failed")
        }
    }

    // Calculate the amount to pay
    private fun calculateFee(
        vehicleType: VehicleType,
        parkedTime: Long,
        hasDiscountCard: Boolean
    ): Int {
        var fee = vehicleType.value + 5 * ceil(minutesExtra(parkedTime) / 15.0)
        if (hasDiscountCard) {
            fee = ceil(fee * 0.85)
        }
        return fee.toInt()
    }

    // Give the final fee to pay
    private fun onSuccess(fee: Int) {
        println("Your fee is: $$fee. Come back soon!")
    }

    // Error message
    private fun onError() {
        println("Sorry, the check-out failed")
    }

    // Calculate the extra minutes
    private fun minutesExtra(parkedTime: Long): Double {
        return maxOf((parkedTime - 120).toDouble(), 0.0)
    }

    // Calculate the amount to pay and if the vehicle was parked or not
    fun checkOutVehicle(plate: String) {
        val fee = calculateFee(vehicle.type, parkedTime, vehicle.discountCard != null)
        if (vehicle.plate == plate) {
            onSuccess(fee)
        } else {
            onError()
        }
    }
}


