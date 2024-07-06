package com.asadbek.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyReceiver:BroadcastReceiver() {
    // malum bir vaqtdan keyin shu yerdagi amallar bajariladi
    private val TAG = "MyReceiver"
    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d(TAG, "onReceive: Jring...")
        Toast.makeText(context, "Jring...", Toast.LENGTH_SHORT).show()
    }
}