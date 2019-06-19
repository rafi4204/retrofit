package com.example.retro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetUserData service = RetroInstance.getRetrofitInstance().create(GetUserData.class);

        Call<List<RetroUser>> call = service.getAllUser();

        call.enqueue(new Callback<List<RetroUser>>() {

            @Override

            public void onResponse(Call<List<RetroUser>> call, Response<List<RetroUser>> response) {



                List<RetroUser> user=response.body();

                for(RetroUser el: user){
                    Log.d("1",el.getBody());
                }


            }



            @Override

            public void onFailure(Call<List<RetroUser>> call, Throwable t) {



                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }

        });


    }
}
