package com.manuflowers.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class NetworkChangeBroadcastReceiver constructor(
    val statusInternet: (Boolean) -> Unit,
   private var networkUtil: NetworkUtil
) : BroadcastReceiver() {

    //TODO: add dependency injection
    //private lateinit var networkUtil: NetworkUtil

    override fun onReceive(context: Context?, intent: Intent?) {

        if (networkUtil.isConnected && (networkUtil.type == ConnectivityManager.TYPE_WIFI ||
                    networkUtil.type == ConnectivityManager.TYPE_MOBILE)
        )
            statusInternet(true)
        else
            statusInternet(false)
    }
}