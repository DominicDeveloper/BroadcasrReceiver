package com.asadbek.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.asadbek.broadcastreceiver.utils.NetworkHelper

class MyBroadcastReceiver:BroadcastReceiver() {
    // ma`lum bir vaqtdan keyin shu yerdagi amallar bajariladi
    override fun onReceive(context: Context?, intent: Intent?) {
        val networkHelper = NetworkHelper(context!!)
        if (networkHelper.isNetworkConnected()){
            Toast.makeText(context, "Tarmoqqa ulangan...", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Tarmoqqa ulanmagan...", Toast.LENGTH_SHORT).show()
        }

    }
}