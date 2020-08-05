package com.make.iot.AppIOT1.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.make.iot.AppIOT1.Model.Data;
import com.make.iot.AppIOT1.R;
import com.make.iot.AppIOT1.Service.APIRetrofitClient;
import com.make.iot.AppIOT1.Service.APIService;
import com.make.iot.AppIOT1.Service.DataService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView temp1, temp2, hum1, hum2;
    SwitchCompat switchCompat_hc, switchCompat_led;
    int id = 1583992;
    String AppKey = "9c50f7194f38a84e658ba6194598dd27";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        GetData(id, AppKey);
    }

    private void GetData(int id, String AppId) {
        DataService dataService = APIService.getService();
        Call<Data> dataCall = dataService.GetDataWeather(id, AppId);
        dataCall.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                Log.d("BBB", response.body().getName());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });
    }

    private void anhxa() {
        temp1 = findViewById(R.id.temp1);
        temp2 = findViewById(R.id.temp2);
        hum1 = findViewById(R.id.hum1);
        hum2 = findViewById(R.id.hum2);
        switchCompat_hc = findViewById(R.id.switch_hc_sr501);
        switchCompat_led = findViewById(R.id.switch_led);
    }
}