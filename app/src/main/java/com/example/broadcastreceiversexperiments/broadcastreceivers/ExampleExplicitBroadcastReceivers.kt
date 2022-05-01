package com.example.broadcastreceiversexperiments.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 *
  android:exported="true" means it will triggered by another app  -->
<receiver android:name=".broadcastreceivers.ExampleExplicitBroadcastReceivers"
android:exported="true"/>
 default value of exported is false if remove intent filter default
 value will be false
**/
class ExampleExplicitBroadcastReceivers:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(context, "ExampleExplicitBroadcastReceivers triggered ${intent?.getStringExtra("SEND_EXTRA")}", Toast.LENGTH_LONG).show()
    }
}

//com.example.broadcastreceiversexperiments
//com.example.broadcastreceiversexperiments.broadcastreceivers.ExampleExplicitBroadcastReceivers
