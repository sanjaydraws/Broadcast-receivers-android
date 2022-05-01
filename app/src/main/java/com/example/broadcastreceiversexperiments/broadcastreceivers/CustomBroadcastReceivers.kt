package com.example.broadcastreceiversexperiments.broadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.example.broadcastreceiversexperiments.constants.COM_EXAMPLE_EXAMPLE_ACTION
import com.example.broadcastreceiversexperiments.constants.COM_EXAMPLE_EXTRA_TEXT

/**
 * example of implicit broadcast
 * send and receive an implicit custom broadcast with an intent action string that we define ourselves
 * */
class CustomBroadcastReceivers :BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if(COM_EXAMPLE_EXAMPLE_ACTION == intent?.action){
            val receivedText = intent.getStringExtra(COM_EXAMPLE_EXTRA_TEXT)
            Log.d("CustomBroadcast", "onReceive: $receivedText")
            Toast.makeText(context, receivedText, Toast.LENGTH_LONG).show()
        }
    }
}