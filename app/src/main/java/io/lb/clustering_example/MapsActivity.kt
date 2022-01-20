package io.lb.clustering_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterManager

class MapsActivity : AppCompatActivity() {

    private val users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync {
            setUpClusterManager(it)
        }
    }

    private fun setUpClusterManager(map: GoogleMap) {
        val clusterManager = ClusterManager<User>(this, map)
        map.setOnCameraIdleListener(clusterManager)

        setupUsers()
        clusterManager.addItems(users)
        clusterManager.cluster()
    }

    private fun setupUsers() {
        val latLngs = arrayListOf(
            LatLng(22.572645, 88.363892),
            LatLng(22.841150, 88.126373),
            LatLng(22.693029, 86.953110),
            LatLng(22.225420, 88.781273),
            LatLng(22.330883, 88.270040),
            LatLng(22.698742, 88.688636),
        )

        for (i in latLngs.indices) {
            users.add(User("Account$i", latLngs[i]))
        }
    }
}