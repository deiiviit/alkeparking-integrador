package com.example.alkeparking_integrador

import java.util.*
import kotlin.math.ceil

const val MINUTES_IN_MILLISECONDS = 60000

data class ParkingSpace(var vehicle: Vehicle) {

    var fee: Int? = null

    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS


    // Calculate the fee
    private fun calculateFee(
        vehicleType: VehicleType,
        parkedTime: Long,
        discountCard: Boolean
    ): Int {
        var fee = vehicleType.value + 5 * ceil(timeExtra(parkedTime) / 15.0)
        if (discountCard) {
            fee = ceil(fee * 0.85)
        }
        return fee.toInt()
    }

    // Give the final fee to pay
    fun onSuccess(fee: Int) {
        this.fee = fee
        println("Your fee is: $$fee. Come back soon!")
    }

    // Error message
    fun onError() {
        println("Sorry, the check-out failed")
    }

    // Calculate the extra minutes
    private fun timeExtra(parkedTime: Long): Double {
        return maxOf((parkedTime - 120).toDouble(), 0.0)
    }

    // Calculate the amount to pay and if the vehicle was parked or not
    fun checkOutVehicle(plate: String) {
        if (vehicle.plate == plate) {
            val fee = calculateFee(vehicle.type, parkedTime, vehicle.discountCard != null)
            onSuccess(fee)
        } else {
            onError()
        }
    }
}
