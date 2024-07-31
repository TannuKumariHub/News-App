package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.databinding.FragmentSportsBinding

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SportsFragment : Fragment() {

    private val apiKey = "ded4aed87e784c5cad3bd43d9d6afdba" // Replace with your actual API key
    private lateinit var adapter: Adapter
    private lateinit var binding: FragmentSportsBinding
    private var articleList = mutableListOf<Article>() // Mutable list to hold fetched data

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportsBinding.inflate(inflater, container, false)

        // Initialize RecyclerView and Adapter
        adapter = Adapter(articleList)
        binding.recyclerViewOfFreeEbooks.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewOfFreeEbooks.adapter = adapter

        findNews()

        return binding.root
    }

    private fun findNews() {
        val retrofitData = instanceOfRetrofit.getInstanceOfRetrofit().create(ApiInterface::class.java)
        retrofitData.getCategory("in", "sports",20, apiKey).enqueue(object : Callback<MainData?> {
            override fun onResponse(call: Call<MainData?>, response: Response<MainData?>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data != null) {
                        Log.d("AllFragment", data.toString())
                        articleList.clear()
                        articleList.addAll(data.articles)
                        adapter.notifyDataSetChanged()
                    } else {
                        Log.d("AllFragment", "No data found")
                    }
                } else {
                    Log.d("AllFragment", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<MainData?>, t: Throwable) {
                Log.e("AllFragment", "Failed to fetch data: ${t.message}", t)
            }
        })
    }
}