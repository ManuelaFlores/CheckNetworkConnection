package com.manuflowers.broadcastreceiverdemo.di

import com.manuflowers.broadcastreceiverdemo.NetworkUtil
import com.manuflowers.broadcastreceiverdemo.provideConnectivityManager
import org.koin.dsl.module

val servicesModule = module {
    single { provideConnectivityManager(get()) }
    single {
        NetworkUtil(get())
    }
}