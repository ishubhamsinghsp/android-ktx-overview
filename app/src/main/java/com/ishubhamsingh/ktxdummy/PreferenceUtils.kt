package com.ishubhamsingh.ktxdummy

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import java.util.prefs.Preferences

/**
 * Created by Shubham Singh on 1/2/21.
 */
class PreferenceUtils(context: Context) {
    private var sharedPref: SharedPreferences = context.getSharedPreferences("DEFAULT_PREF",0)

    fun storeInt(key: String, value:Int) {
        sharedPref.edit()
            .putInt(key, value)
            .apply()
    }

    fun storeIntKtx(key: String, value:Int) {
        sharedPref.edit { putInt(key, value) }

        sharedPref.edit(commit = true) {  putString(key, value.toString()) }
    }

}