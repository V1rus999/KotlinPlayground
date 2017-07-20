package com.droidit.kotlinandroidplayground.kotlinmon

import android.location.Location
import com.google.android.gms.maps.model.Marker

/**
 * Created by johannesC on 2017/07/19.
 */
data class HappyFace(val name: String, val power: Double = 0.0, val lat: Double, val long: Double, val resId: Int?, var marker: Marker? = null)

fun HappyFace.location(): Location {
    val loc = Location(this.name)
    loc.latitude = this.lat
    loc.longitude = this.long
    return loc
}

fun HappyFace.checkCollision(location: Location): Boolean =
        this.location().distanceTo(location) < 50
