package com.example.bachelorsproject.data.local.sharedpreferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class SharedPref(application: Application) {

    private val data: SharedPreferences = application.getSharedPreferences("Share", Context.MODE_PRIVATE)

    var isFirst: Boolean by PreferencesDelegate(data,"isFirst",true)

}