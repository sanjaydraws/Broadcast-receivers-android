package com.example.broadcastreceiversexperiments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.broadcastreceiversexperiments.broadcastreceivers.ExampleBroadcastReceivers
import com.example.broadcastreceiversexperiments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // register broadcast receiver
    val exampleBroadcastReceivers by lazy{
        ExampleBroadcastReceivers()
    }
    var binding:ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
        }

        binding?.dynamicBr?.setOnClickListener {
            DynamicBroadcastReceiversActivity.start(this)
        }
        binding?.textDetectWifiState?.setOnClickListener {
            DetectWifiStateActivity.start(this)
        }
        binding?.textCustomBr?.setOnClickListener {
            CustomBroadcastReceiversActivity.start(this)
        }
    }

    override fun onStart() {
        super.onStart()
//        //// trigger when app goes in foreground
//        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
////        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION) // can be added more than one action
//        registerReceiver(exampleBroadcastReceivers,filter)

    }

    override fun onStop() {
        super.onStop()
//        unregisterReceiver(exampleBroadcastReceivers) // trigger when app goes in background
    }


}



