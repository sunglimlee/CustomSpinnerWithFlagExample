package com.example.customspinnerwithflagexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CountryAdapter(context : Context, var countryList : ArrayList<CountryItem> ) : ArrayAdapter<CountryItem>(context, 0, countryList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return initView(position, convertView, parent)
    }

    fun initView(position: Int, convertView: View?, parent: ViewGroup) : View {
        var mConvertView : View? = convertView
        if (mConvertView == null) {
            mConvertView = LayoutInflater.from(context).inflate(R.layout.country_spinner_row, parent, false)
        }
        val imageView : ImageView = mConvertView!!.findViewById(R.id.image_view_flag)
        val textView : TextView = mConvertView!!.findViewById(R.id.text_view_name)
        val currentItem : CountryItem? = getItem(position)
        if (currentItem != null) {
            imageView.setImageResource(currentItem.getFlagImage())
            textView.setText(currentItem.getCountryName())
        }
        return mConvertView as View
    }
}