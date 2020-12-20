package com.example.myapp.service


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mars.udacity.com/";

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build();

interface ProjectService {
    @GET("realestate")
    fun getProperties():
            Call<String>
}

object ServiceProject {
    val retrofitService : ProjectService by lazy {
        retrofit.create(ProjectService::class.java)
    }
}