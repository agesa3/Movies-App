package com.beatrice.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.WorkManager
import com.beatrice.moviesapp.presentation.navigation.MoviesNavHost
import com.beatrice.moviesapp.presentation.view.theme.MoviesAppTheme
import com.beatrice.moviesapp.sync.oneTimeTask
import com.beatrice.moviesapp.sync.periodicSyncTask
import dagger.hilt.android.AndroidEntryPoint
import logcat.logcat

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val workManager by lazy {
        WorkManager.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        schedulePeriodicTask()
        setContent {
            MoviesAppTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MoviesNavHost(navController = navController)
                }
            }
        }
    }

    private fun schedulePeriodicTask() {
        logcat("TAAASKS") { "How many times was I called? Main" }
        workManager.enqueue(
            oneTimeTask,
        )
//        workManager.enqueueUniquePeriodicWork(
//            "syncWork", // TODO: Extract to a variable
//            ExistingPeriodicWorkPolicy.KEEP,
//            periodicSyncTask,
//        )
    }

}