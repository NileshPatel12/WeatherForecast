package com.example.weatherForecast.Model;
/**
 * Created by NileshPatel on 2019-05-10.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind {
    @SerializedName("deg")
    @Expose
    private String deg;
    @SerializedName("speed")
    @Expose
    private String speed;

    public String getDeg() {
        return deg;
    }

    public String getSpeed() {
        return speed;
    }

}
