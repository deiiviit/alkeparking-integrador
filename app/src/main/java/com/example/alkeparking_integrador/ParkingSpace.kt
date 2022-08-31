package com.example.alkeparking_integrador

import java.util.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.microseconds
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.minutes
import kotlin.time.DurationUnit
import kotlin.time.toDuration


const val MINUTES_IN_MILLISECONDS = 60000

data class ParkingSpace(var vehicle: Vehicle) {
    val amount:Int?=null

    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - vehicle.checkInTime.timeInMillis) / MINUTES_IN_MILLISECONDS

   /*
    if(parking.vehicles.contains(vehicle)){
        checkOutVehicle(vehicle.plate,amount,::onSuccess)
    }else{
        checkOutVehicle(vehicle.plate,amount,::onError)
    }
   */

    private fun calculateFee():Int{

        println("time ${vehicle.checkInTime.timeInMillis}  ${Calendar.getInstance().timeInMillis}  La diferencia es ${parkedTime} minutos")
        if(parkedTime> 120){
            val plus= ((parkedTime.minutes.minus(120.toDuration(DurationUnit.MINUTES))).div(15.toDuration(DurationUnit.MINUTES)))*5
            //println("plus $plus  ${plus.toInt()}")
            return vehicle.type.value + plus.toInt()
        }else{
             return vehicle.type.value
        }
    }

    fun onSuccess(){
       println("Successful, the amount is:  ${this.calculateFee()}")
   }

    fun onError(){
        println("An error occurred")
    }



    fun checkOutVehicle(plate:String, operation:() ->Unit){
        operation()
    }



}


