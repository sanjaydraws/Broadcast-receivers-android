package com.example.broadcastreceiversexperiments.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ExampleExplicitBroadcastReceivers3: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "ExampleExplicitBroadcastReceivers3 triggered ${intent?.getStringExtra("SEND_EXTRA")}", Toast.LENGTH_LONG).show()
    }
}