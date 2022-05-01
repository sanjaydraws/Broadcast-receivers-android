package com.example.broadcastreceiversexperiments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.broadcastreceiversexperiments.broadcastreceivers.ExampleExplicitBroadcastReceivers
import com.example.broadcastreceiversexperiments.databinding.ActivityDynamicBroadcastReceiversBinding
import com.example.broadcastreceiversexperiments.databinding.ActivityExplicitBroadcastReceiversBinding

class ExplicitBroadcastReceiversActivity : AppCompatActivity() {
    var binding :ActivityExplicitBroadcastReceiversBinding? = null

    companion object{
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context,ExplicitBroadcastReceiversActivity ::class.java)
                .apply {

                }
            context.startActivity(starter)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplicitBroadcastReceiversBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
        }
    }



}