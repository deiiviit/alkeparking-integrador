package com.example.alkeparking_integrador

data class Vehicle(val plate:String){

    override fun equals(other: Any?): Boolean {
        if(other is Vehicle){
            return this.plate==other.plate
        }
        return super.equals(other)
    }


    override fun hashCode(): Int =this.plate.hashCode()
}