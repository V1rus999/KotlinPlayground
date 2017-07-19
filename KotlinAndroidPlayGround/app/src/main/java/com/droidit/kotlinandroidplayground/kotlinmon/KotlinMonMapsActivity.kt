package com.droidit.kotlinandroidplayground.kotlinmon

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.droidit.kotlinandroidplayground.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import java.util.*
import kotlin.concurrent.scheduleAtFixedRate


class KotlinMonMapsActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener {

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, KotlinMonMapsActivity::class.java))
        }
    }

    private lateinit var mMap: GoogleMap
    private lateinit var locationTimer: Timer
    private var youMarker: Marker? = null
    private val smilies = ArrayList<HappyFace>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_mon_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            111 -> {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startCheckingLocation()
                } else {
                    Log.e("Error in Permission", "No Permission for location")
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val permissionCheck = PermissionChecker()
        permissionCheck.checkLocationPermission(this, {
            loadSmilies()
            startCheckingLocation()
        })
    }

    fun resizeMapIcons(iconId: Int, width: Int, height: Int): Bitmap {
        val imageBitmap = BitmapFactory.decodeResource(resources, iconId)
        val resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false)
        return resizedBitmap
    }

    fun loadSmilies() {
        smilies.add(HappyFace("Smily1", 20.0, -26.149601, 27.92, R.drawable.happy_face))
        smilies.add(HappyFace("Smily2", 22.0, -26.2, 27.91, R.drawable.happy_face))

        for ((name, _, lat, long, resId) in smilies) {
            mMap.addMarker(MarkerOptions().position(LatLng(lat, long)).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons(resId!!, 100, 100))).title(name))
        }
    }

    fun startCheckingLocation() {
        locationTimer = Timer()
        locationTimer.scheduleAtFixedRate(0, 3000, { checkCurrentLocation() })
    }

    @SuppressLint("MissingPermission")
    fun checkCurrentLocation() {
        runOnUiThread {
            val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 3, 3f, this)
        }
    }

    fun l(message: String) = Log.e(KotlinMonMapsActivity.toString(), message)

    override fun onLocationChanged(p0: Location?) {
        val locationMe = LatLng(p0!!.latitude, p0.longitude)
        youMarker?.remove()
        youMarker = mMap.addMarker(MarkerOptions().position(locationMe).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons(R.drawable.jenkinspepe, 100, 100))).title("Me"))
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(youMarker!!.position, 12f))
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        l("onStatusChanged")
    }

    override fun onProviderEnabled(p0: String?) {
        l("onProviderEnabled")
    }

    override fun onProviderDisabled(p0: String?) {
        l("onProviderDisabled")
    }

    override fun onPause() {
        super.onPause()
        locationTimer.cancel()
    }
}
