package com.arturlasok.testapp.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey
import com.arturlasok.testapp.BaseApplication
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UstawieniaDataStore @Inject constructor(app: BaseApplication) {

    val DARK_OPT = booleanPreferencesKey("dark_theme_on")

}