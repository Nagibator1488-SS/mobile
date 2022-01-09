package com.example.pp

import android.content.ContentValues.TAG
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.pp.databinding.ActivityMapsBinding
import android.widget.Toast
import com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
import com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CustomCap
import com.google.android.gms.maps.model.Dash
import com.google.android.gms.maps.model.Dot
import com.google.android.gms.maps.model.Gap
import com.google.android.gms.maps.model.JointType
import com.google.android.gms.maps.model.PatternItem
import com.google.android.gms.maps.model.Polygon
import com.google.android.gms.maps.model.PolygonOptions
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.RoundCap
import java.io.File
import java.io.BufferedReader
import java.io.InputStream
import com.google.firebase.database.DatabaseReference

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener













class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    override fun onMapReady(googleMap: GoogleMap) {
        val database = FirebaseDatabase.getInstance("https://pp11-f1688-default-rtdb.firebaseio.com/")
        val myRef = database.getReference("Trees")
        //val rootRef = FirebaseDatabase.getInstance("https://pp11-f1688-default-rtdb.firebaseio.com/").reference
        //val gameRef = rootRef.child("Trees")

        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (ds in dataSnapshot.children) {
                    val url = ds.getValue(String::class.java)
                    Log.d("TAG", url!!)
                    print("ПРИВЕТТТТТТ")
                    print(url[0])
                }
            }
            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val polylineOptions = PolygonOptions()
            .add(LatLng(56.84025166249376, 60.645847556199215)).add(LatLng(56.84025166249376, 60.6562850526489))
            .add(LatLng(56.84725047511955, 60.6562850526489)).add(LatLng(56.84725047511955, 60.645847556199215))
            .strokeColor(Color.MAGENTA).strokeWidth(3f)

        mMap.addPolygon(polylineOptions)
        val polylineOptions1 = PolylineOptions()
            .add(LatLng(56.84025166249376, 60.6473386271206)).add(LatLng(56.84725047511955, 60.6473386271206))
            .add(LatLng(56.84725047511955, 60.64882969804198)).add(LatLng(56.84025166249376, 60.64882969804198))
            .add(LatLng(56.840251662493766, 60.65032076896336)).add(LatLng(56.84725047511955, 60.65032076896336))
            .add(LatLng(56.84725047511955, 60.65181183988475)).add(LatLng(56.84025166249376, 60.65181183988475))
            .add(LatLng(56.84025166249376, 60.65330291080613)).add(LatLng(56.84725047511955, 60.65330291080613))
            .add(LatLng(56.84725047511955, 60.654793981727515)).add(LatLng(56.84025166249376, 60.654793981727515))
            .add(LatLng(56.84025166249376, 60.6562850526489)).add(LatLng(56.84725047511955, 60.6562850526489))
            .color(Color.MAGENTA).width(3f)

        mMap.addPolyline(polylineOptions1)

        mMap.addPolygon(polylineOptions)
        val polylineOptions2 = PolylineOptions()
            .add(LatLng(56.84125149286888, 60.645847556199215)).add(LatLng(56.84125149286888, 60.6562850526489))
            .add(LatLng(56.842251323243985, 60.6562850526489)).add(LatLng(56.842251323243985, 60.645847556199215))
            .add(LatLng(56.8432511536191, 60.645847556199215)).add(LatLng(56.8432511536191, 60.6562850526489))
            .add(LatLng(56.844250983994215, 60.6562850526489)).add(LatLng(56.844250983994215, 60.645847556199215))
            .add(LatLng(56.84525081436933, 60.645847556199215)).add(LatLng(56.84525081436933, 60.6562850526489))
            .add(LatLng(56.84625064474444, 60.6562850526489)).add(LatLng(56.84625064474444, 60.645847556199215))
            .add(LatLng(56.84725047511955, 60.645847556199215)).add(LatLng(56.84725047511955, 60.6562850526489))
            .color(Color.MAGENTA).width(3f)

        mMap.addPolyline(polylineOptions2)


        val sydney1 = LatLng(56.840751577681324, 60.6465930916599)
        val sydney2 = LatLng(56.840751577681324, 60.648084162581284)
        val sydney3 = LatLng(56.840751577681324, 60.64957523350267)
        val sydney4 = LatLng(56.840751577681324, 60.651066304424056)
        val sydney5 = LatLng(56.840751577681324, 60.65255737534544)
        val sydney6 = LatLng(56.840751577681324, 60.65404844626682)
        val sydney7 = LatLng(56.840751577681324, 60.6555395171882)
        val sydney8 = LatLng(56.84175140805643, 60.6465930916599)
        val sydney9 = LatLng(56.84175140805643, 60.648084162581284)
        val sydney10 = LatLng(56.84175140805643, 60.64957523350267)
        val sydney11 = LatLng(56.84175140805643, 60.651066304424056)
        val sydney12 = LatLng(56.84175140805643, 60.65255737534544)
        val sydney13 = LatLng(56.84175140805643, 60.65404844626682)
        val sydney14 = LatLng(56.84175140805643, 60.6555395171882)
        val sydney15 = LatLng(56.842751238431546, 60.6465930916599)
        val sydney16 = LatLng(56.842751238431546, 60.648084162581284)
        val sydney17 = LatLng(56.842751238431546, 60.64957523350267)
        val sydney18 = LatLng(56.842751238431546, 60.651066304424056)
        val sydney19 = LatLng(56.842751238431546, 60.65255737534544)
        val sydney20 = LatLng(56.842751238431546, 60.65404844626682)
        val sydney21 = LatLng(56.842751238431546, 60.6555395171882)
        val sydney22 = LatLng(56.84375106880666, 60.6465930916599)
        val sydney23 = LatLng(56.84375106880666, 60.648084162581284)
        val sydney24 = LatLng(56.84375106880666, 60.64957523350267)
        val sydney25 = LatLng(56.84375106880666, 60.651066304424056)
        val sydney26 = LatLng(56.84375106880666, 60.65255737534544)
        val sydney27 = LatLng(56.84375106880666, 60.65404844626682)
        val sydney28 = LatLng(56.84375106880666, 60.6555395171882)
        val sydney29 = LatLng(56.844750899181776, 60.6465930916599)
        val sydney30 = LatLng(56.844750899181776, 60.648084162581284)
        val sydney31 = LatLng(56.844750899181776, 60.64957523350267)
        val sydney32 = LatLng(56.844750899181776, 60.651066304424056)
        val sydney33 = LatLng(56.844750899181776, 60.65255737534544)
        val sydney34 = LatLng(56.844750899181776, 60.65404844626682)
        val sydney35 = LatLng(56.844750899181776, 60.6555395171882)
        val sydney36 = LatLng(56.84575072955688, 60.6465930916599)
        val sydney37 = LatLng(56.84575072955688, 60.648084162581284)
        val sydney38 = LatLng(56.84575072955688, 60.64957523350267)
        val sydney39 = LatLng(56.84575072955688, 60.651066304424056)
        val sydney40 = LatLng(56.84575072955688, 60.65255737534544)
        val sydney41 = LatLng(56.84575072955688, 60.65404844626682)
        val sydney42 = LatLng(56.84575072955688, 60.6555395171882)
        val sydney43 = LatLng(56.846750559932, 60.6465930916599)
        val sydney44 = LatLng(56.846750559932, 60.648084162581284)
        val sydney45 = LatLng(56.846750559932, 60.64957523350267)
        val sydney46 = LatLng(56.846750559932, 60.651066304424056)
        val sydney47 = LatLng(56.846750559932, 60.65255737534544)
        val sydney48 = LatLng(56.846750559932, 60.65404844626682)
        val sydney49 = LatLng(56.846750559932, 60.6555395171882)
        mMap.addMarker(MarkerOptions().position(sydney1).title("54"))
        mMap.addMarker(MarkerOptions().position(sydney2).title("96"))
        mMap.addMarker(MarkerOptions().position(sydney3).title("125"))
        mMap.addMarker(MarkerOptions().position(sydney4).title("103"))
        mMap.addMarker(MarkerOptions().position(sydney5).title("76"))
        mMap.addMarker(MarkerOptions().position(sydney6).title("112"))
        mMap.addMarker(MarkerOptions().position(sydney7).title("51"))
        mMap.addMarker(MarkerOptions().position(sydney8).title("94"))
        mMap.addMarker(MarkerOptions().position(sydney9).title("55"))
        mMap.addMarker(MarkerOptions().position(sydney10).title("88"))
        mMap.addMarker(MarkerOptions().position(sydney11).title("139"))
        mMap.addMarker(MarkerOptions().position(sydney12).title("51"))
        mMap.addMarker(MarkerOptions().position(sydney13).title("63"))
        mMap.addMarker(MarkerOptions().position(sydney14).title("93"))
        mMap.addMarker(MarkerOptions().position(sydney15).title("100"))
        mMap.addMarker(MarkerOptions().position(sydney16).title("151"))
        mMap.addMarker(MarkerOptions().position(sydney17).title("124"))
        mMap.addMarker(MarkerOptions().position(sydney18).title("83"))
        mMap.addMarker(MarkerOptions().position(sydney19).title("51"))
        mMap.addMarker(MarkerOptions().position(sydney20).title("91"))
        mMap.addMarker(MarkerOptions().position(sydney21).title("94"))
        mMap.addMarker(MarkerOptions().position(sydney22).title("91"))
        mMap.addMarker(MarkerOptions().position(sydney23).title("170"))
        mMap.addMarker(MarkerOptions().position(sydney24).title("171"))
        mMap.addMarker(MarkerOptions().position(sydney25).title("146"))
        mMap.addMarker(MarkerOptions().position(sydney26).title("122"))
        mMap.addMarker(MarkerOptions().position(sydney27).title("47"))
        mMap.addMarker(MarkerOptions().position(sydney28).title("93"))
        mMap.addMarker(MarkerOptions().position(sydney29).title("250"))
        mMap.addMarker(MarkerOptions().position(sydney30).title("91"))
        mMap.addMarker(MarkerOptions().position(sydney31).title("144"))
        mMap.addMarker(MarkerOptions().position(sydney32).title("123"))
        mMap.addMarker(MarkerOptions().position(sydney33).title("100"))
        mMap.addMarker(MarkerOptions().position(sydney34).title("60"))
        mMap.addMarker(MarkerOptions().position(sydney35).title("72"))
        mMap.addMarker(MarkerOptions().position(sydney36).title("95"))
        mMap.addMarker(MarkerOptions().position(sydney37).title("111"))
        mMap.addMarker(MarkerOptions().position(sydney38).title("151"))
        mMap.addMarker(MarkerOptions().position(sydney39).title("102"))
        mMap.addMarker(MarkerOptions().position(sydney40).title("109"))
        mMap.addMarker(MarkerOptions().position(sydney41).title("91"))
        mMap.addMarker(MarkerOptions().position(sydney42).title("106"))
        mMap.addMarker(MarkerOptions().position(sydney43).title("38"))
        mMap.addMarker(MarkerOptions().position(sydney44).title("44"))
        mMap.addMarker(MarkerOptions().position(sydney45).title("161"))
        mMap.addMarker(MarkerOptions().position(sydney46).title("147"))
        mMap.addMarker(MarkerOptions().position(sydney47).title("211"))
        mMap.addMarker(MarkerOptions().position(sydney48).title("158"))
        mMap.addMarker(MarkerOptions().position(sydney49).title("84"))

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney24))
    }


}