package com.manuflowers.broadcastreceiverdemo

import android.app.Application
import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.layout_no_internet_connection.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val networkUtil: NetworkUtil by inject()

    private val networkChangeBroadcastReceiver by lazy {
        NetworkChangeBroadcastReceiver(
            networkUtil = networkUtil,
            statusInternet = { statusInternet ->
                if (statusInternet) {
                    noInternetConnectionConstraintLayout.visibility = View.GONE
                } else {
                    noInternetConnectionConstraintLayout.visibility = View.VISIBLE
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
