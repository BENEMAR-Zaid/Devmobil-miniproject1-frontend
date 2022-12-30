package com.example.miniproject_frontend.retrofit;

import com.example.miniproject_frontend.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ConvertApi {

    @GET("/specify/{from}/{to}/{value}")
    Call<Result> getResult(@Path("from") String from,
                           @Path("to") String to,
                           @Path("value") String value);
}
