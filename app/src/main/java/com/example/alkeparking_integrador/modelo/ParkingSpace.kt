package com.example.alkeparking_integrador.modelo

import java.util.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.DurationUnit
import kotlin.time.toDuration


const val MINUTES_IN_MILLISECONDS = 60000

data class ParkingSpace(var vehicle: Vehicle) {
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
            vehicle.discountCard?.let{
                return ((vehicle.type.value + plus.toInt())-(((vehicle.type.value + plus.toInt())*15)/100))
            } ?: run{
                return vehicle.type.value + plus.toInt()
            }
        }else{
            vehicle.discountCard?.let{
                return ((vehicle.type.value )-(((vehicle.type.value)*15)/100))
            } ?: run{
                return vehicle.type.value
            }
        }
    }

    fun onSuccess(){
        println("Your fee is ${this.calculateFee()}. Come back soon.PLATE ${vehicle.plate} ")
    }

    fun onError(){
        println("Sorry, the check-out failed PLATE ${vehicle.plate}")
    }

    fun checkOutVehicle(plate:String, operation:() ->Unit){
        operation()
    }

}


