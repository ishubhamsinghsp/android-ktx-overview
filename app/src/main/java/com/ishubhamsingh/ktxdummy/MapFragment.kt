package com.ishubhamsingh.ktxdummy

import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.maps.android.geometry.Point
import com.google.maps.android.ktx.addCircle
import com.google.maps.android.ktx.addMarker
import com.google.maps.android.ktx.awaitMap
import com.google.maps.android.ktx.utils.component1
import com.google.maps.android.ktx.utils.component2
import com.google.maps.android.ktx.utils.geometry.component1
import com.google.maps.android.ktx.utils.geometry.component2
import com.ishubhamsingh.ktxdummy.databinding.FragmentMapBinding

/**
 * Created by Shubham Singh on 1/2/21.
 */
class MapFragment:Fragment(), OnMapReadyCallback {

    private var _binding: FragmentMapBinding? = null
    private val binding get() = _binding

    private var mGoogleMap: GoogleMap? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMapBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        //  Method 1
        mapFragment.getMapAsync(this)

        // Method 2
        mapFragment.getMapAsync { googleMap ->
            mGoogleMap = googleMap
        }

        // Method 3
        lifecycle.coroutineScope.launchWhenCreated {
            mGoogleMap = mapFragment.awaitMap()

            mGoogleMap?.addMarker {
                position(LatLng(0.0,0.0))
                title("My Marker")
                icon(BitmapDescriptorFactory.defaultMarker())
            }
        }

        // Destructuring
        val location = LatLng(0.0,0.0)

        val lat = location.latitude
        val lng = location.longitude

        val (latKtx, lngKtx) = location


        val point = Point(0.1,0.9)

        val x = point.x
        val y = point.y

        val (xKtx, yKtx) = point

    }

    override fun onMapReady(p0: GoogleMap?) {
        mGoogleMap = p0

        mGoogleMap?.addMarker(
            MarkerOptions()
                .position(LatLng(0.0,0.0))
                .title("My Marker")
                .icon(BitmapDescriptorFactory.defaultMarker())
        )

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}