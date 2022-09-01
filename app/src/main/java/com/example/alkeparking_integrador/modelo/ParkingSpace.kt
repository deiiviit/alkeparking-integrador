package com.example.alkeparking_integrador.modelo

import java.util.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
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

    fun calculateFee(parkedTime:Long,type: VehicleType):Int{

        if(parkedTime.minutes> 120.toDuration(DurationUnit.MINUTES)){
            val plus= ((parkedTime.minutes.minus(120.toDuration(DurationUnit.MINUTES))).div(15.toDuration(DurationUnit.MINUTES)))*5
            return type.value + plus.toInt()
        }else{
             return type.value
        }

    }

    fun onSuccess(amount:Int){
       println("Successful, the amount is:  $amount")
   }

    fun onError(){
        println("An error occurred")
    }



    fun checkOutVehicle(plate:String,amount:Int?,operation:(Int?) ->String){
        operation(amount)
    }

}


