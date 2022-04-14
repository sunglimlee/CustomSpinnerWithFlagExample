package com.example.customspinnerwithflagexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var mCountryList : ArrayList<CountryItem>
    private lateinit var mAdapter : CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initList()
        val spinner : Spinner = findViewById(R.id.spinner_countries)

        mAdapter = CountryAdapter(this@MainActivity, mCountryList)
        spinner.adapter = mAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                // AdapterView가 중요하나? 그럼 View는????
                // 그럼 AdapterView는 ListView나 Spinner 여기서는 Spinner가 되고
                // 거기서 getItemAtPosition(position)을 해서 Casting을 하면 countryItem을 얻을 수 있구나..
                // https://www.intertech.com/android-adapters-adapterviews/#:~:text=An%20AdapterView%20is%20a%20group,read%20about%20AdapterView%20widgets%20here).
                val countryItem : CountryItem =  p0?.getItemAtPosition(p2) as CountryItem
                val clickedCountryName : String = countryItem.getCountryName()
                Toast.makeText(this@MainActivity, clickedCountryName, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun initList() {
        mCountryList = ArrayList<CountryItem>()
        mCountryList.add(CountryItem("AirPlane", R.drawable.ic_airplane))
        mCountryList.add(CountryItem("Camera", R.drawable.ic_camera))
        mCountryList.add(CountryItem("Human", R.drawable.ic_human))


    }
}