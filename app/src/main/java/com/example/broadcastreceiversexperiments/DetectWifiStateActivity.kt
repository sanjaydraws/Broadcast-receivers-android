package com.example.broadcastreceiversexperiments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.broadcastreceiversexperiments.databinding.ActivityDetectWifiStateBinding
import com.example.broadcastreceiversexperiments.databinding.ActivityDynamicBroadcastReceiversBinding
import android.net.wifi.WifiManager
import android.widget.CompoundButton
import android.content.BroadcastReceiver
import android.content.IntentFilter


// to detect wifi state
// add change wifi state and access wifi state

// wifi state receiver is sticky broadcast receiver
// non sticky - expire after send and process by system
class DetectWifiStateActivity : AppCompatActivity() {
    var binding: ActivityDetectWifiStateBinding? = null
    val wifiManager by lazy {
        applicationContext.getSystemService(WIFI_SERVICE) as? WifiManager
    }

    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, DetectWifiStateActivity::class.java)
                .apply {

                }
            context.startActivity(starter)
        }
    }

    private val wifiStateReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            // contains information of wifi state
            val wifiStateExtra = intent.getIntExtra(
                WifiManager.EXTRA_WIFI_STATE,
                WifiManager.WIFI_STATE_UNKNOWN
            )
            when (wifiStateExtra) {
                WifiManager.WIFI_STATE_ENABLED -> {
                    binding?.wifiSwitch?.setChecked(true)
                    binding?.wifiSwitch?.setText("WiFi is ON")
                }
                WifiManager.WIFI_STATE_DISABLED -> {
                    binding?.wifiSwitch?.setChecked(false)
                    binding?.wifiSwitch?.setText("WiFi is OFF")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetectWifiStateBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
        }
        binding?.wifiSwitch?.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                wifiManager?.isWifiEnabled = true
                binding?.wifiSwitch?.text = "WiFi is ON"
            } else {
                wifiManager?.isWifiEnabled = false
                binding?.wifiSwitch?.text = "WiFi is OFF"
            }
        })
//        if(wifiManager?.isWifiEnabled == true){
//            binding?.wifiSwitch?.isChecked = true
//            binding?.wifiSwitch?.setText("Wi fi is On")
//        }else{
//            binding?.wifiSwitch?.isChecked = false
//            binding?.wifiSwitch?.setText("Wi fi is Off")
//        }
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION)// define BR will trigger
        registerReceiver(wifiStateReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(wifiStateReceiver)
    }
}
