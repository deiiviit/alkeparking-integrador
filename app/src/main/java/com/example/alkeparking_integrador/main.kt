package com.example.alkeparking_integrador

import java.util.*
import kotlin.time.Duration.Companion.minutes
import kotlin.time.DurationUnit
import kotlin.time.toDuration

fun main() {
    //se crean objetos de prueba, para validar que no se exceda del cupo máximo permitido ni que repita placa
    val dif=-135
    val fecha = Calendar.getInstance()
    fecha.add(Calendar.MINUTE, dif)

    val car = Vehicle("AA111AA", VehicleType.CAR, fecha, "DISCOUNT_CARD_001")
    val car1 = Vehicle("AA111AB", VehicleType.CAR, fecha)
    val car2 = Vehicle("AA111AC", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car3 = Vehicle("AA111AD", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car4 = Vehicle("AA111AE", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car5 = Vehicle("AA111AF", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")


    //se crea el arreglo con los carros creados
    var vehiclesArray = arrayOf(
        car,
        car1,
        car3,
        car4,
        car5,
    )

    //Inicializo parking con mutableSet vacio
    val parking = Parking(mutableSetOf())
    //itero sobre el arreglo creado ypara ir añadiendo los carros
    vehiclesArray.forEach { println(parking.checkIn(it)) }
    println()

    println("IMPRESION DE SET \n")
    parking.listVehicles().forEachIndexed { index, s -> println("Vehicle $index: Plate  $s") }
    println("\n")
    println("BORRADO CON UNA DIFERENCIA DE ${dif*-1} Minutos \n")


    parking.delVehicle(car)
    println()
    parking.delVehicle(car1)

    println()
    parking.delVehicle(car2)



    //val moto = Vehicle("BA111AA", VehicleType.MOTORCYCLE, Calendar.getInstance())
    //val minibus = Vehicle("CA111AA", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    //val bus = Vehicle("DA111AA", VehicleType.BUS, Calendar.getInstance())
//    val busCopy = Vehicle("DA111AA", VehicleType.BUS, Calendar.getInstance())
//    val bus2 = Vehicle("FA111AA", VehicleType.BUS, Calendar.getInstance())


    //println(parking.vehicles.contains(car))
    //println(parking.vehicles.contains(moto))
    //println(parking.vehicles.contains(minibus))
    //println(parking.vehicles.contains(bus))

    //println(parking.vehicles.size)


//    println(parking.vehicles.contains(busCopy))
//    println(parking.vehicles.size)
//    println(parking.vehicles.contains(bus2))


}
