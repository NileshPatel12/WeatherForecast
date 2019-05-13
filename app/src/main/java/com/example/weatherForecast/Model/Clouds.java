package com.example.weatherForecast.Model;
/**
 * Created by NileshPatel on 2019-05-10.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {
    @SerializedName("all")
    @Expose
    private String all;

    public String getAll() {
        return all;
    }

}
