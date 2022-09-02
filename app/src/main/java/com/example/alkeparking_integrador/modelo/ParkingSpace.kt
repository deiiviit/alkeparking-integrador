package com.example.alkeparking_integrador.modelo


import java.util.*
import kotlin.math.ceil

const val MINUTES_IN_MILLISECONDS = 60000

data class ParkingSpace(var vehicle: Vehicle) {

    //Variable that stores the rate to be paid for each vehicle
    var fee: Int = 0

    // Constant that stores the time of entry of a vehicle
    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS

    /**
     * Method that calculates the rate to be paid per vehicle
     * The calculation of the extra time is obtained and divided into fractions of 15 minutes to multiply it by 5 pesos that cost each additional 15 minutes
     * the base price per type of vehicle and the price of additional time are added
     *  15% discount is made to the total rate
     */
    private fun calculateFee(
        vehicleType: VehicleType,
        parkedTime: Long,
        discountCard: Boolean
    ): Int {
        var fee = vehicleType.value + 5 * ceil(calculateTimeExtra(parkedTime) / 15.0)
        if (discountCard) {
            fee = ceil(fee * 0.85)
        }
        return fee.toInt()
    }
    /**
     * Method that informs if the checkOut of the vehicle was successful and its fee to pay
     * @param fee variable containing the calculated rate
     */
    fun onSuccess(fee: Int) {
        this.fee = fee
        println("Your fee is: $$fee. Come back soon!")
    }
    /**
     * Method that informs if the checkOut of the vehicle was not successful
     */
    fun onError() {
        println("Sorry, the check-out failed")
    }
    /**
     * Method that calculates the extra time in parking for each vehicle
     */
    private fun calculateTimeExtra(parkedTime: Long): Double {
        return maxOf((parkedTime - 120).toDouble(), 0.0)
    }
    /**
     * Method that validates the departure of a vehicle
     * @param plate String that it receives to validate if the vehicle is the same
     * @param onSuccess function call on success comparative
     * @param onError  function call on failure comparative
     * @param listPlate list String to comparate with first param
     */
    fun checkOutVehicle(plate: String,onSuccess: (payment: Int) -> Unit, onError: () -> Unit,listPlate:List<String>):String{
        fee = calculateFee(vehicle.type, parkedTime, vehicle.discountCard != null)
        return if (listPlate.contains(plate)){
            onSuccess(fee)
            plate
        } else{
            onError()
            ""
        }
    }

    /*
    /**
     * Method that validates the departure of a vehicle
     * @param plate String that it receives to validate if the vehicle is the same
     */
    fun checkOutVehicle2(plate: String) {
        if (vehicle.plate == plate) {
            val fee = calculateFee(vehicle.type, parkedTime, vehicle.discountCard != null)
            onSuccess(fee)
        } else {
            onError()
        }
    }

     */
}


