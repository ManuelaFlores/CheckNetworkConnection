package com.manuflowers.broadcastreceiverdemo

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import androidx.arch.core.executor.testing.InstantTaskExecutorRule


class OutgoingCallReceiverTest {
     var mOutgoingCallReceiver: OutgoingCallReceiver? = null
     var mContext: Context? = null

    private val mockPhoneNo = 959777974

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mOutgoingCallReceiver = OutgoingCallReceiver()
        mContext = mock(Context::class.java)
    }

    @Test
    fun test_receiver_all_intent() {
        val intent = Intent(Intent.ACTION_NEW_OUTGOING_CALL)
        intent.putExtra(Intent.EXTRA_PHONE_NUMBER, mockPhoneNo)
        mOutgoingCallReceiver!!.onReceive(mContext!!, intent)
        AsyncTask.execute {
            val preferences = mContext!!.getSharedPreferences(
                "MyPrefs",
                Context.MODE_PRIVATE
            )
            // Verify that the received phone no data is correct.
            val phone = preferences.getString("phone", null)
            assertEquals(mockPhoneNo, phone)
        }
    }
}