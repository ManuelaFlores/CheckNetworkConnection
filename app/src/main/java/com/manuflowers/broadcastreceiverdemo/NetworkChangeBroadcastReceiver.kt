package com.manuflowers.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import org.koin.core.KoinComponent

class NetworkChangeBroadcastReceiver constructor(
    val statusInternet: (Boolean) -> Unit,
   private var networkUtil: NetworkUtil
) : BroadcastReceiver(), KoinComponent {

    override fun onReceive(context: Context?, intent: Intent?) {

        if (networkUtil.isConnected && (networkUtil.type == ConnectivityManager.TYPE_WIFI ||
                    networkUtil.type == ConnectivityManager.TYPE_MOBILE)
        )
            statusInternet(true)
        else
            statusInternet(false)
    }
}