package com.example.newsapp

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class instanceOfRetrofit {

    companion object {


        fun getInstanceOfRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()


        }



    }
}