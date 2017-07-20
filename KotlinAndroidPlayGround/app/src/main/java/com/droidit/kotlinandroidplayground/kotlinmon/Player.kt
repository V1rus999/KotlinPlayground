package com.droidit.kotlinandroidplayground.kotlinmon

import android.location.Location
import com.google.android.gms.maps.model.Marker

/**
 * Created by johannesC on 2017/07/20.
 */
data class Player(val name: String, var power: Double = 0.0, var lat: Double? = null, var long: Double? = null, val resId: Int, var marker: Marker? = null)

fun Player.location(): Location {
    val loc = Location(this.name)
    loc.latitude = this.lat!!
    loc.longitude = this.long!!
    return loc
}