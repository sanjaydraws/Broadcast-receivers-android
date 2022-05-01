package com.example.broadcastreceiversexperiments.broadcastreceivers

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

 for dynamic receiver -> don't need to define in mainfest , comment it

 */
// example broadcast receivers
class ExampleBroadcastReceivers:BroadcastReceiver (){



    override fun onReceive(context: Context?, intent: Intent?) {
        if(Intent.ACTION_BOOT_COMPLETED == intent?.action){
            Toast.makeText(context, "Boot Completed",Toast.LENGTH_LONG).show()
        }

        // not working after 25 if register in manifest because battery low
        if(ConnectivityManager.CONNECTIVITY_ACTION == intent?.action){
            Toast.makeText(context, "connectivity changed",Toast.LENGTH_LONG).show()

        }





    }

}