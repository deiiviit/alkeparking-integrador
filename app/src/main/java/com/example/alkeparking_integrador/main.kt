package com.example.alkeparking_integrador

import java.util.*

fun main() {
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto = Vehicle("BA111AA", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus = Vehicle("CA111AA", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus = Vehicle("DA111AA", VehicleType.BUS, Calendar.getInstance())
    val parking = Parking(mutableSetOf(car,moto,minibus,bus))
//    val busCopy = Vehicle("DA111AA", VehicleType.BUS, Calendar.getInstance())
//    val bus2 = Vehicle("FA111AA", VehicleType.BUS, Calendar.getInstance())


    println(parking.vehicles.contains(car))
    println(parking.vehicles.contains(moto))
    println(parking.vehicles.contains(minibus))
    println(parking.vehicles.contains(bus))


//    println(parking.vehicles.contains(busCopy))
//    println(parking.vehicles.size)
//    println(parking.vehicles.contains(bus2))

}