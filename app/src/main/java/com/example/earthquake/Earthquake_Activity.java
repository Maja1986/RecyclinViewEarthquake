package com.example.earthquake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Earthquake_Activity extends AppCompatActivity {

    private EartquakeAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        progressDoalog = new ProgressDialog(this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        recyclerView = findViewById(R.id.my_recycler_view);
        /*Create handle for the RetrofitInstance interface*/
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<EarthquakeResponse> call = service.getAllEarthquakes();
        call.enqueue(new Callback<EarthquakeResponse>() {
            @Override
            public void onResponse(Call<EarthquakeResponse> call, Response<EarthquakeResponse> response) {

                progressDoalog.dismiss();
                generateDataList(response.body());
            }


            @Override
            public void onFailure(Call<EarthquakeResponse> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getBaseContext(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(EarthquakeResponse earthquakes) {

        adapter = new EartquakeAdapter(this, earthquakes.getFeatures());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}