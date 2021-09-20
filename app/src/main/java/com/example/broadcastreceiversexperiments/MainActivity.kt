package com.example.broadcastreceiversexperiments

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    // register broadcast receiver (dynamic)
    val exampleBroadcastReceivers by lazy{
        ExampleBroadcastReceivers()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        //// trigger when app goes in foreground
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
//        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION) // can be added more than one action
        registerReceiver(exampleBroadcastReceivers,filter)

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(exampleBroadcastReceivers) // trigger when app goes in background
    }


    // if want broadcast receiver active as long as whole app is running -  register broadcast receiver in  onCreate of Application class
    // if  want broadcast receive active in background - register broadcast receiver in on create and unregister on onDestroy - keep active lifecycle of activity
}



