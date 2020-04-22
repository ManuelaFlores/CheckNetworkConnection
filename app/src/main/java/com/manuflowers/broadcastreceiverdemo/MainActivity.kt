package com.manuflowers.broadcastreceiverdemo

import android.app.Application
import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val networkUtil: NetworkUtil by inject()

    private val networkChangeBroadcastReceiver by lazy {
        NetworkChangeBroadcastReceiver(
            networkUtil = networkUtil,
            statusInternet = { statusInternet ->
                if (statusInternet) {
                    Log.e("ACTIVE", "estado activo")
                } else {
                    Log.e("INNACTIVE", "estado no activo")
                }
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(
            networkChangeBroadcastReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(networkChangeBroadcastReceiver)
    }
}
