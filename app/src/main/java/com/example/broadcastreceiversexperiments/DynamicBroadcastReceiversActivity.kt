package com.example.broadcastreceiversexperiments

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.broadcastreceiversexperiments.broadcastreceivers.DynamicBroadcastReceivers
import com.example.broadcastreceiversexperiments.databinding.ActivityDynamicBroadcastReceiversBinding
// if want broadcast receiver active as long as whole app is running -
// register broadcast receiver in  onCreate of Application class
class DynamicBroadcastReceiversActivity : AppCompatActivity() {
    var binding:ActivityDynamicBroadcastReceiversBinding? = null
    val dynamicBroadcastReceivers by lazy{
        DynamicBroadcastReceivers()
    }
    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context,DynamicBroadcastReceiversActivity ::class.java)
                .apply {

                }
            context.startActivity(starter)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDynamicBroadcastReceiversBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
        }
    }

    override fun onStart() {
        super.onStart()
        //// trigger when app goes in foreground
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(dynamicBroadcastReceivers, filter)
//        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION) // can be added more than one action

    }

    override fun onStop() {
        super.onStop()
        // trigger when app goes in background
        unregisterReceiver(dynamicBroadcastReceivers)
    }

}