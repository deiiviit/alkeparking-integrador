package com.example.alkeparking_integrador.modelo

import com.example.alkeparking_integrador.domain.Parking
import com.example.alkeparking_integrador.modelo.Vehicle
import com.example.alkeparking_integrador.modelo.VehicleType
import java.util.*

fun main() {
    // set fake date to test
    val dateCheckIn = Calendar.getInstance()
    dateCheckIn.add(Calendar.MINUTE, -135)
    println(dateCheckIn.time)
    val car = Vehicle("AA111AA", VehicleType.CAR, dateCheckIn)
    val car1 = Vehicle("AA111AB", VehicleType.CAR, dateCheckIn, "DISCOUNT_CARD_001")
    val moto = Vehicle("AA111AC", VehicleType.MOTORCYCLE, dateCheckIn)
    val moto2 = Vehicle("AA111AC", VehicleType.MOTORCYCLE, dateCheckIn)
    val minibus = Vehicle("AA111AD", VehicleType.MINIBUS, dateCheckIn, "DISCOUNT_CARD_002")
    val bus = Vehicle("AA111AE", VehicleType.BUS, dateCheckIn, "DISCOUNT_CARD_003")

    // create array of vehicles
    val vehiclesArray = arrayOf(
        car,
        car1,
        moto,
        minibus,
        bus,
        moto2
    )

    // Initiate the parking lot
    val parking = Parking(mutableSetOf())

    //iterate over the array of vehicles and add them to the parking lot
    vehiclesArray.forEach { parking.addVehicle(it) }

    // removes vehicles from the parking lot and run checkOut
    parking.removeVehicle(car)
    parking.removeVehicle(car1)
    parking.removeVehicle(moto)
    parking.removeVehicle(moto2)

    // print all the vehicles in the parking lot
    parking.listVehicles().forEachIndexed { index, s -> println("Vehicle $index: Plate  $s") }

    parking.getTotalRecord()

}
