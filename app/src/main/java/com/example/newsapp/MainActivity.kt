package com.example.newsapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity

import androidx.viewpager2.widget.ViewPager2

import com.example.newsapp.databinding.ActivityMainBinding

import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FragmentPageAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Search.setOnClickListener {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
            openFragment(SearchFragment())
        }


//        binding.fav.setOnClickListener {
//            val i = Intent(this, FavoriteFragment::class.java)
//            startActivity(i)
//        }
        adapter=FragmentPageAdapter(supportFragmentManager,lifecycle,6)
        binding.FragmentContainer.adapter=adapter

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("All"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Business"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Entertainment"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Sports"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Science"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Technology"))


        //val retrofitService=instanceOfRetrofit.getInstanceOfRetrofit().create(ApiInterface::class.java)

        // Notify ViewPager2 when TabLayout is selected

      binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
          override fun onTabSelected(tab: TabLayout.Tab?) {
              tab?.let {
                  binding.FragmentContainer.currentItem = it.position
              }
          }

          override fun onTabUnselected(tab: TabLayout.Tab?) {

          }

          override fun onTabReselected(tab: TabLayout.Tab?) {

          }

      })

      //need to notify tablayout

        binding.FragmentContainer.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
                }

        })



    }

    private fun openFragment(searchFragment: SearchFragment) {
        Toast.makeText(this, "Opening fragment", Toast.LENGTH_SHORT).show()
        binding.FragmentContainer.visibility = View.GONE
        binding.tabLayout.visibility = View.GONE
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, searchFragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

}