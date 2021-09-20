package com.example.broadcastreceiversexperiments

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.widget.Toast

// register in manifest
/* when system  events defined in manifest happens(another entry point for app)
  brodcast triggerred, onReceive() will happen -- implicit broadcast

  static -> to define broadcast reciver in manifest, even if app is not currently running

  explicit broadcast receivers - calling directly by class name

 for dynamic receiver -> don't need to define in mainfest

 */

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


        if(ConnectivityManager.CONNECTIVITY_ACTION == intent?.action){
            val noConnectivity = intent.getBooleanExtra(
                ConnectivityManager.EXTRA_NO_CONNECTIVITY,false
            )
            if(noConnectivity){
                // when no connection
                context?.toast("disconnected" )
            }else{
                // have connection
                context?.toast("connected")
            }
        }



    }

}