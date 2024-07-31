package com.example.newsapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.databinding.ItemshowBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

class Adapter(private val articleList:List<Article>): RecyclerView.Adapter<Adapter.Myviewholder>() {
    class Myviewholder(val binding: ItemshowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val binding= ItemshowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return Myviewholder(binding)
    }
    override fun getItemCount(): Int {
        return articleList.size
    }



    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
       val currentItem=articleList[position]
        holder.binding.Heading.text=currentItem.title
        holder.binding.Description.text=currentItem.description
        holder.binding.authorsName.text=currentItem.author
        holder.binding.PublishDate.text=currentItem.publishedAt

        val imageUrl = currentItem.url
        Log.d("Adapter", "Loading image URL: $imageUrl")
        Picasso.get().load(currentItem.url).into(holder.binding.imageView,object : Callback {
            override fun onSuccess() {
                Log.d("Adapter", "Image loaded successfully: $imageUrl")
            }

            override fun onError(e: Exception?) {
                Log.e("Adapter", "Error loading image: $imageUrl", e)
            }
        })

    }
}