package com.example.alkeparking_integrador

import java.util.*


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


