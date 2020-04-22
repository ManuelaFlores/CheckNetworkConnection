package com.manuflowers.broadcastreceiverdemo

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager


class NetworkUtil(private val connectivityManager: ConnectivityManager) {

    val isConnected: Boolean
    get() {
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    val type: Int
    get() = connectivityManager.activeNetworkInfo?.type ?: 1
}

fun provideConnectivityManager(application: Application): ConnectivityManager {
    return application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
}