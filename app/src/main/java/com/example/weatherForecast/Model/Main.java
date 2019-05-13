package com.example.weatherForecast.Model;
/**
 * Created by NileshPatel on 2019-05-10.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main {
    @SerializedName("temp")
    @Expose
    private String temp;
    @SerializedName("temp_min")
    @Expose
    private String temp_min;
    @SerializedName("grnd_level")
    @Expose
    private String grnd_level;
    @SerializedName("temp_kf")
    @Expose
    private String temp_kf;
    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("sea_level")
    @Expose
    private String sea_level;
    @SerializedName("temp_max")
    @Expose
    private String temp_max;

    public String getTemp() {
        return temp;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public String getGrnd_level() {
        return grnd_level;
    }

    public String getTemp_kf() {
        return temp_kf;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getPressure() {
        return pressure;
    }

    public String getSea_level() {
        return sea_level;
    }

    public String getTemp_max() {
        return temp_max;
    }

}
