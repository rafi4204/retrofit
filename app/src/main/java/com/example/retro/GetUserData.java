package com.example.retro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetUserData {
    @GET("/posts")
    Call<List<RetroUser>> getAllUser();
}
