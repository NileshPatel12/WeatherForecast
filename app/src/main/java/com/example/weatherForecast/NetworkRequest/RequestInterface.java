package com.example.weatherForecast.NetworkRequest;
/**
 * Created by NileshPatel on 2019-05-11.
 */

        import com.example.weatherForecast.Common.Constant;
        import com.example.weatherForecast.Model.WeatherDetails;

        import okhttp3.ResponseBody;
        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Query;
        import retrofit2.http.Url;

public interface RequestInterface {


    @GET(Constant.END_URL)
    Call<WeatherDetails> getWeatherDetails(@Query(Constant.LAT_PARAMETER) String lat, @Query(Constant.LON_PARAMETER) String lon, @Query(Constant.UNITS_PARAMETER) String units, @Query(Constant.APPID_PARAMETER) String appID);

    @GET
    Call<ResponseBody> fetchImage(@Url String url);
}
