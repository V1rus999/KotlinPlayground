package com.droidit.kotlinandroidplayground.kotlinmon

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat

/**
 * Created by johannesC on 2017/07/19.
 */
class PermissionChecker {

    fun checkLocationPermission(context: Activity, hasPermCallback: () -> Unit) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(context, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 111)
                return
            } else {
                hasPermCallback()
                return
            }
        } else {
            hasPermCallback()
        }
    }
}