package com.example.ximeiliu.contactlist.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ximeiliu on 23/01/17.
 */

class Geo {
    @SerializedName("lat")
    private String lat;
    @SerializedName("lng")
    private String lng;

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
}
