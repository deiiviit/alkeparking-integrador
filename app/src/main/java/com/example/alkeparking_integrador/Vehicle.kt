package com.example.alkeparking_integrador

import java.util.*

data class Vehicle(val plate:String, val type: VehicleType, val instance: Calendar,val card:String?=null){
    
    override fun equals(other: Any?): Boolean {
        if(other is Vehicle){
            return this.plate==other.plate
        }
        return super.equals(other)
    }


    override fun hashCode(): Int =this.plate.hashCode()
}