package com.example.broadcastreceiversexperiments.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

class DynamicBroadcastReceivers:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
       if(ConnectivityManager.CONNECTIVITY_ACTION == intent?.action){
            val noConnectivity = intent.getBooleanExtra(
                ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
            )
            if(noConnectivity){
                // when no connection
                Toast.makeText(context, "disconnected",Toast.LENGTH_LONG).show()
            }else{
                // have connection
                Toast.makeText(context, "Connected",Toast.LENGTH_LONG).show()
            }
        }

    }
}