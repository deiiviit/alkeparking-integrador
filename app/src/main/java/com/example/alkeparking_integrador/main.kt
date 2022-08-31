package com.example.alkeparking_integrador

import java.util.*

fun main() {
    //se crean objetos de prueba, para validar que no se exceda del cupo máximo permitido ni que repita placa
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car1 = Vehicle("AA111AB", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car2 = Vehicle("AA111AC", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car3 = Vehicle("AA111AD", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car4 = Vehicle("AA111AE", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car5 = Vehicle("AA111AF", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car6 = Vehicle("AA111AG", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car7 = Vehicle("AA111AH", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car8 = Vehicle("AA111AI", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car9 = Vehicle("AA111AJ", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car10 = Vehicle("AA111AK", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car11 = Vehicle("AA111AL", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car12 = Vehicle("AA111AM", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car13 = Vehicle("AA111AN", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car14 = Vehicle("AA111AO", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car15 = Vehicle("AA111AP", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car16 = Vehicle("AA111AQ", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car17 = Vehicle("AA111AR", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car18 = Vehicle("AA111AS", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car19 = Vehicle("AA111AT", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car20 = Vehicle("AA111AU", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val car21 = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")

    //se crea el arreglo con los carros creados
    var vehiclesArray = arrayOf(
        car,
        car1,
        car2,
        car3,
        car4,
        car5,
        car6,
        car7,
        car8,
        car9,
        car10,
        car11,
        car12,
        car13,
        car14,
        car15,
        car16,
        car17,
        car18,
        car19,
        car20,
        car21
    )

    //Inicializo parking con mutableSet vacio
    val parking = Parking(mutableSetOf())
    //itero sobre el arreglo creado ypara ir añadiendo los carros
    vehiclesArray.forEach { println(parking.checkIn(it)) }


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
