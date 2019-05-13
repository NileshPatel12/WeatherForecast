package com.example.weatherForecast.Model;
/**
 * Created by NileshPatel on 2019-05-10.
 */

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("population")
    @Expose
    private String population;

    public String getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPopulation() {
        return population;
    }


}

