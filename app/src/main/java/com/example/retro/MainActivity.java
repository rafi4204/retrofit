package com.example.retro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetUserData service = RetroInstance.getRetrofitInstance().create(GetUserData.class);

        Call<List<RetroUser>> call = service.getAllUser();

        call.enqueue(new Callback<List<RetroUser>>() {

            @Override

            public void onResponse(Call<List<RetroUser>> call, Response<List<RetroUser>> response) {


               // Log.d("2","this is !!!!!!!!!!!!!!!!!!");

                generateDataList(response.body());
             /*  List<RetroUser> user=response.body();

                for(RetroUser el: user){
                    Log.d("1",el.getBody());
                }*/


            }



            @Override

            public void onFailure(Call<List<RetroUser>> call, Throwable t) {



                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }

        });


    }
    private void generateDataList(List<RetroUser> photoList) {


        Log.d("2","this is !!!!!!!!!!!!!!!!!!");

        recyclerView = findViewById(R.id.customRecyclerView);

        adapter = new CustomAdapter(this,photoList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }
}
