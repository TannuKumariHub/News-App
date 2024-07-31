package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query




//https://www.googleapis.com/books/v1/volumes?q=time&printType=all&key=AIzaSyAhoE_hgu1vQrPwBtKSeU-XOi5wVNH18_A
//https://www.googleapis.com/books/v1/volumes?q=flowers&filter=free-ebooks&key=AIzaSyAhoE_hgu1vQrPwBtKSeU-XOi5wVNH18_A
//https://www.googleapis.com/books/v1/volumes?q=flowers&filter=ebooks&key=AIzaSyAhoE_hgu1vQrPwBtKSeU-XOi5wVNH18_A
//https://www.googleapis.com/books/v1/volumes?q=flowers&filter=paid-ebooks&key=AIzaSyAhoE_hgu1vQrPwBtKSeU-XOi5wVNH18_A
//https://www.googleapis.com/books/v1/volumes?q=time&printType=magazines&key=AIzaSyAhoE_hgu1vQrPwBtKSeU-XOi5wVNH18_A
//https://www.googleapis.com/books/v1/volumes?q=time&printType=books&key=AIzaSyAhoE_hgu1vQrPwBtKSeU-XOi5wVNH18_A

//const val base_url = "https://www.googleapis.com/books/v1/"
const val API_KEY="ded4aed87e784c5cad3bd43d9d6afdba"


interface ApiInterface {

     // General query
    @GET("v2/top-headlines")
     fun getAllData(
          @Query("country") country: String,
          @Query("pageSize") pageSize: Int,
          @Query("apiKey") apiKey: String = API_KEY

//          @Query("printType") printType: String = "all"
            //https://www.googleapis.com/books/v1/volumes?apikey=AIzaSyAhoE_hgu1vQrPwBtKSeU-XOi5wVNH18_A
     ): Call<MainData>

    @GET("v2/top-headlines")
    fun getCategory(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String = API_KEY

//          @Query("printType") printType: String = "all"
        //https://www.googleapis.com/books/v1/volumes?apikey=AIzaSyAhoE_hgu1vQrPwBtKSeU-XOi5wVNH18_A
    ): Call<MainData>

    @GET("v2/everything")
    fun getEverything(
        @Query("pageSize") pageSize: Int,
        @Query("apiKey") apiKey: String = API_KEY

//          @Query("printType") printType: String = "all"
        //https://www.googleapis.com/books/v1/volumes?apikey=AIzaSyAhoE_hgu1vQrPwBtKSeU-XOi5wVNH18_A
    ): Call<MainData>

  /*   // Query with printType
     @GET("volumes")
     fun getDataByPrintType(
          @Query("q") query: String,
          @Query("printType") printType: String,
          @Query("key") apiKey: String = API_KEY
     ): Call<MainDataClass>

     // Query with filter (free-ebooks)
     @GET("volumes")
     fun getFreeEbooks(
          @Query("q") query: String,
          @Query("filter") filter: String = "free-ebooks",
          @Query("key") apiKey: String = API_KEY
     ): Call<MainDataClass>

     // Query with filter (ebooks)
     @GET("volumes")
     fun getEbooks(
          @Query("q") query: String,
          @Query("filter") filter: String = "ebooks",
          @Query("key") apiKey: String = API_KEY
     ): Call<MainDataClass>

     // Query with filter (paid-ebooks)
     @GET("volumes")
     fun getPaidEbooks(
          @Query("q") query: String,
          @Query("filter") filter: String = "paid-ebooks",
          @Query("key") apiKey: String = API_KEY
     ): Call<MainDataClass>

     // Query with printType (books)
     @GET("volumes")
     fun getBooks(
          @Query("q") query: String,
          @Query("printType") printType: String = "books",
          @Query("key") apiKey: String = API_KEY
     ): Call<MainDataClass>

     // Query with printType (magazines)
     @GET("volumes")
     fun getMagazines(
          @Query("q") query: String,
          @Query("printType") printType: String = "magazines",
          @Query("key") apiKey: String = API_KEY
     ): Call<MainDataClass>
}


//   https://www.googleapis.com/books/v1/volumes?api_key=$api_key&q=all
//     https://www.googleapis.com/books/v1/volumes?api_key=$api_key&printType=books
*/
}