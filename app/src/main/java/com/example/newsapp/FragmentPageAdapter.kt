package com.example.newsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val tabCount:Int)
    : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return tabCount // Total number of fragments
    }

    override fun createFragment(position: Int): Fragment {
        // Return the appropriate fragment based on the position
        return when (position) {
            0 -> AllFragment()
            1 -> BusinessFragment()
            2 -> EntertainmentFragment()
            3 -> SportsFragment()
            4 -> ScienceFragment()
            5 -> TechnologyFragment()
            else -> AllFragment() // Default to AllFragment if position is out of range
        }
    }
}
