package com.example.weatherForecast;

/**
 * Created by NileshPatel on 2019-05-11.
 */

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import com.example.weatherForecast.Common.Constant;
import com.example.weatherForecast.Common.PreferenceHelper;
import com.example.weatherForecast.Model.WeatherDetails;
import com.example.weatherForecast.NetworkRequest.RequestInterface;
import com.example.weatherForecast.NetworkRequest.RetrofitController;
import com.example.weatherForecast.Utils.Utils;

import org.apache.commons.io.FileUtils;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskScheduler extends Service {
    public RequestInterface requestInterface;

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        PreferenceHelper.getInstance().intialization(this);
        final Bundle bundle = intent.getExtras();
        assert bundle != null;
        try {
            requestWeatherAPI(bundle.getString(Constant.LATITUDE), bundle.getString(Constant.LONGITUDE));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Service.START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    public void requestWeatherAPI(final String lat, final String lon) throws IOException {

        if (Utils.checkConnectivity(this)) {
            if (getCacheDir().exists()) {
                FileUtils.deleteDirectory(getCacheDir());
            }
            requestInterface = RetrofitController.getInstance(this).create(RequestInterface.class);
            Call<WeatherDetails> calleque = requestInterface.getWeatherDetails(lat, lon, Constant.TEMP_UNITS, Constant.API_KEY);
            calleque.enqueue(new Callback<WeatherDetails>() {
                @Override
                public void onResponse(Call<WeatherDetails> call, Response<WeatherDetails> response) {
                    if (Utils.checkConnectivity(getBaseContext())) {
                        if (response.body() != null) {
                            if (response.body().getCod().equals(Constant.SUCCESS_RESPONSE)) {
                                PreferenceHelper.getInstance().setLatitude(Utils.getConvertedDecimal(lat));
                            } else {
                                Toast.makeText(getBaseContext(), getResources().getText(R.string.msg_api_error, response.body().getCod()), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<WeatherDetails> call, Throwable t) {
                    Toast.makeText(getBaseContext(), getResources().getText(R.string.msg_call_failed, t.getMessage()), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
