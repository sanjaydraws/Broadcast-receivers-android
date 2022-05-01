package com.example.broadcastreceiversexperiments

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.broadcastreceiversexperiments.broadcastreceivers.CustomBroadcastReceivers
import com.example.broadcastreceiversexperiments.databinding.ActivityCustomBroadcastReceiversBinding
import com.example.broadcastreceiversexperiments.databinding.ActivityDynamicBroadcastReceiversBinding

class CustomBroadcastReceiversActivity : AppCompatActivity() {
    var binding: ActivityCustomBroadcastReceiversBinding? = null
    val customBroadcastReceivers by lazy{
        CustomBroadcastReceivers()
    }
    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, CustomBroadcastReceiversActivity::class.java)
                .apply {

                }
            context.startActivity(starter)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomBroadcastReceiversBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
        }
        val filter = IntentFilter(constants.COM_EXAMPLE_EXAMPLE_ACTION);
        registerReceiver(customBroadcastReceivers,filter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(customBroadcastReceivers)
    }

}