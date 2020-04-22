package com.manuflowers.broadcastreceiverdemo

import android.app.Application
import com.manuflowers.broadcastreceiverdemo.di.servicesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BroadcastReceiverDemoApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@BroadcastReceiverDemoApplication)
            modules(listOf(
                servicesModule
            ))
        }
    }
}