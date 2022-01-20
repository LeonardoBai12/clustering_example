package io.lb.clustering_example

import com.google.maps.android.clustering.ClusterItem
import com.google.android.gms.maps.model.LatLng

class User(
    var userName: String,
    var latLng: LatLng,
): ClusterItem {
    override fun getPosition(): LatLng {
        return latLng
    }

    override fun getTitle(): String {
        return userName
    }

    override fun getSnippet(): String {
        return ""
    }
}