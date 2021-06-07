package ru.skillbranch.gameofthrones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.skillbranch.gameofthrones.api.RetrofitInstance
import ru.skillbranch.gameofthrones.data.local.entities.House
import ru.skillbranch.gameofthrones.util.Constants

class MainActivity : AppCompatActivity() {

    //Initialize variable
    val DIGIT_PATTERN = Regex("[^0-9]")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val retrofitObject = RetrofitInstance

        for ((key,value) in Constants.NEED_HOUSES) {

            retrofitObject.api.getHouse(value)
                    .enqueue(object : Callback<List<House>> {
                        override fun onResponse(
                                call: Call<List<House>>,
                                response: Response<List<House>>
                        ) {

                            val house = response.body()
                            var characterList = listOf<String>()

                            house?.forEach { it ->
                                characterList = it.swornMembers.map { DIGIT_PATTERN.replace(it, "") }

                            }
                            println("$value : $characterList")

                        }

                        override fun onFailure(call: Call<List<House>>, t: Throwable) {
                            println("ОШИБКА: " + t.message)
                        }
                    })
        }





        /*//Assign variable
        tabLayout = tab_layout
        viewPager = view_pager

        val arrayList = arrayListOf<String>()

        arrayList.addAll(NEED_HOUSES.keys)

        //Prepare view pager
        prepareViewPager(viewPager,arrayList)

        //Setup with view pager
        tabLayout.setupWithViewPager(viewPager)*/
    }

    private fun prepareViewPager(viewPager: ViewPager?, arrayList: ArrayList<String>) {
        //Initialize main adapter
        val adapter = MainAdapter(supportFragmentManager)
        //Initialize main fragment
//        var fragment = MainFragment()
//        repeat(arrayList.size) {
//            val bundle = Bundle()
//            //Put string
//            bundle.putString("Title", arrayList[it])
//            //Set argument
//            fragment.arguments = bundle
//            //Add fragment
//            adapter.addFragment(fragment,arrayList[it])
//            //Define new fragment
//            fragment = MainFragment()
//
//        }
        //Set adapter
        viewPager?.adapter = adapter

    }

    class MainAdapter(fm: FragmentManager, behavior: Int = BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) : FragmentPagerAdapter(fm, behavior) {
        //Initialize array list
        private val arrayList: ArrayList<String> = arrayListOf()
        private val fragmentList: ArrayList<Fragment> = arrayListOf()

        //Create constructor
        fun addFragment(fragment: Fragment, title : String){
            arrayList.add(title)
            fragmentList.add(fragment)
        }

        override fun getCount(): Int {
            //Return fragment size
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            //Return fragment position
            return fragmentList[position]
        }
        override fun getPageTitle(position: Int) : CharSequence{
            //Return arrayList position
            return arrayList[position]
        }

    }
}