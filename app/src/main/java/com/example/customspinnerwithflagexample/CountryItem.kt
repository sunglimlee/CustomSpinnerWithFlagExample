package com.example.customspinnerwithflagexample

class CountryItem(var mCountryItem : String, var mFlagImage : Int) {
    fun getCountryName() : String {
        return mCountryItem
    }
    fun getFlagImage() : Int {
        return mFlagImage
    }
}