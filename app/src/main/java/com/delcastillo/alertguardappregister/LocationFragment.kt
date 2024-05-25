package com.delcastillo.alertguardappregister

import androidx.fragment.app.Fragment
import com.delcastillo.appregister.R

class LocationFragment : Fragment(R.layout.fragment_location) {

//    private lateinit var fusedLocationClient: FusedLocationProviderClient
//    private lateinit var locationCallback: LocationCallback
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_location)
//
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
//
//        // Location callback to receive location updates
//        locationCallback = object : LocationCallback() {
//            override fun onLocationResult(locationResult: LocationResult) {
//                val location = locationResult.lastLocation
//                if (location != null) {
//                    // Use the location data
//                    Toast.makeText(this@Location, "Location: ${location.latitude}, ${location.longitude}", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//
//        // Check for location permissions
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
//                this,
//                Manifest.permission.ACCESS_COARSE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            // Request permissions
//            ActivityCompat.requestPermissions(
//                this,
//                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
//                1001
//            )
//            return
//        }
//
//        startLocationUpdates()
//
//        val woman: ImageView = findViewById(R.id.Woman)
//        woman.setOnClickListener {
//            val intent = Intent(this, Profile::class.java)
//            startActivity(intent)
//        }
//
//        val locationback: Button = findViewById(R.id.locationbackbtn)
//        locationback.setOnClickListener {
//            val intent = Intent(this, DashboardFragment::class.java)
//            startActivity(intent)
//        }
//    }
//
//    private fun startLocationUpdates() {
//        val locationRequest = LocationRequest.create().apply {
//            interval = 10000 // 10 seconds
//            fastestInterval = 5000 // 5 seconds
//            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
//        }
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
//            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            return
//        }
//        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null)
//    }
//
//    override fun onPause() {
//        super.onPause()
//        fusedLocationClient.removeLocationUpdates(locationCallback)
//    }
//
//    override fun onResume() {
//        super.onResume()
//        startLocationUpdates()
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 1001) {
//            if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
//                startLocationUpdates()
//            } else {
//                Toast.makeText(this, "Permission denied. Unable to start location updates.", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}