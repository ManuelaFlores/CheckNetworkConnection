package com.manuflowers.broadcastreceiverdemo

import android.net.ConnectivityManager


class NetworkUtil internal constructor(private val connectivityManager: ConnectivityManager) {

    val isConnected: Boolean
    get() {
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    val type: Int
    get() = connectivityManager.activeNetworkInfo?.type ?: 1
}