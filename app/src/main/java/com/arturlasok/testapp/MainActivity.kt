package com.arturlasok.testapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.rememberNavController
import com.arturlasok.testapp.navigation.NavigationComponent
import com.arturlasok.testapp.ui.theme.MainToDoTheme
import com.arturlasok.testapp.util.TAG
import com.arturlasok.testapp.util.UiText
import com.arturlasok.testapp.util.isOnline
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


// Datastore init
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "ustawienia")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //Internet Monitor
    @Inject
    lateinit var isOnline: isOnline
    //viewModel
    val viewModel: MainActivityViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

        //ui State
        var thisuiState: MainActivityUiState by mutableStateOf(MainActivityUiState.Loading)


        //Splash screen
        splashScreen.setKeepOnScreenCondition {
          when(thisuiState) {
              MainActivityUiState.Loading -> true
              is MainActivityUiState.ScreenReady -> false
          }
        }

        //Data Store
        val IS_DARK_THEME = booleanPreferencesKey("dark_theme_on")
        val dataFromStore : Flow<Boolean> =  applicationContext.dataStore.data.map { pref->
            pref[IS_DARK_THEME] ?: false
        }
        //Internet On?
        isOnline.runit()

        // Update the uiState
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState
                    .onEach {
                        thisuiState = it
                        Log.i(TAG,"Data is changed MA")
                    }.launchIn(this)
            }
        }

        setContent {
            //navController
            val navController = rememberNavController()
            //accompanist for system bars controller
            val systemUiController = rememberSystemUiController()
            // data store for dark theme
            val dataStoreDarkTheme = dataFromStore.collectAsState(false)
            MainToDoTheme(dataStoreDarkTheme.value) {
                //theme?
                when(dataStoreDarkTheme.value) {
                    false -> {
                        systemUiController.setSystemBarsColor(Color(0xFF072C49))
                    }
                    true -> {
                        systemUiController.setSystemBarsColor(Color(0xFF2E2828))
                    }
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LaunchedEffect(key1 = true, block = {
                        delay(5000)
                        thisuiState = MainActivityUiState.ScreenReady

                    } )
                    Column() {
                        Text(text = "Theme_dark: "+ dataStoreDarkTheme.value.toString() + " \nNetwork avilable: ${isOnline.isNetworkAvailable.value}" + " \nUiState: "+thisuiState.toString()  +
                            "\nLang: "+ UiText.StringResource(R.string.app_language,"asd").asString(),)
                        Button(onClick = {
                            lifecycleScope.launch {
                                applicationContext.dataStore.edit { settings->
                                    val currentStoreValue = settings[IS_DARK_THEME] ?: false
                                    settings[IS_DARK_THEME] = !currentStoreValue
                                    viewModel.setDarkActiveTo(settings[IS_DARK_THEME] ?: false)
                                }
                            }

                        }) {
                            Text("change light/dark")
                        }
                        NavigationComponent(navController = navController)
                    }



                }
            }
        }
    }
}

