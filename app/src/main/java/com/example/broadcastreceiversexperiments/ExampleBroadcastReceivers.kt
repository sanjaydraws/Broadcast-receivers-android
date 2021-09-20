package com.example.broadcastreceiversexperiments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast



class ExampleBroadcastReceivers:BroadcastReceiver (){



    override fun onReceive(context: Context?, intent: Intent?) {
//        if(Intent.ACTION_BOOT_COMPLETED == intent?.action){
//            Toast.makeText(context, "Boot Completed",Toast.LENGTH_LONG).show()
//        }
//
//        if(ConnectivityManager.CONNECTIVITY_ACTION == intent?.action){
//            Toast.makeText(context, "connectivity changed",Toast.LENGTH_LONG).show()
//
//        }


        if (ConnectivityManager.CONNECTIVITY_ACTION == intent?.action) {
            val noConnectivity = intent.getBooleanExtra(
                ConnectivityManager.EXTRA_NO_CONNECTIVITY, false
            )
            if (noConnectivity) {
                // when no have connection
                Toast.makeText(context, "Disconnected", Toast.LENGTH_SHORT).show()
            } else {
                // when have connection
                Toast.makeText(context, "Connected", Toast.LENGTH_SHORT).show()
            }
        }
    }
}