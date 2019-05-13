package com.example.weatherForecast.Model;
/**
 * Created by NileshPatel on 2019-05-10.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherDetails {

    @SerializedName("city")
    private City city;
    @SerializedName("cod")
    @Expose
    private String cod;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("list")
    private ArrayList<DetailedList> list = new ArrayList<>();

    public City getCity() {
        return city;
    }


    public String getCod() {
        return cod;
    }


    public String getMessage() {
        return message;
    }


    public ArrayList<DetailedList> getList() {
        return list;
    }


}