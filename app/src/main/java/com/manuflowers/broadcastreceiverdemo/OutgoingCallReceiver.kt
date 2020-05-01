package com.manuflowers.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.AsyncTask


class OutgoingCallReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val phoneNum = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER)
        AsyncTask.execute {
            val preferences: SharedPreferences = context.getSharedPreferences(
                "MyPrefs",
                Context.MODE_PRIVATE
            )
            val editor = preferences.edit()
            editor.putString("phone", phoneNum)
            editor.commit()
        }
    }
}