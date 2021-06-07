package ru.skillbranch.gameofthrones.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import ru.skillbranch.gameofthrones.data.HouseFragment
import ru.skillbranch.gameofthrones.util.HouseType

class HousesPagerAdapter (fa : FragmentActivity)
    : FragmentStateAdapter(fa){
    override fun getItemCount(): Int = HouseType.values().size

    override fun createFragment(position: Int): Fragment = HouseFragment.newInstance(HouseType.values()[position].title)

}