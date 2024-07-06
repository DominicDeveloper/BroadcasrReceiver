package com.asadbek.broadcastreceiver

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.SystemClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.asadbek.broadcastreceiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var myBroadcastReceiver: MyBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myBroadcastReceiver = MyBroadcastReceiver()

        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(myBroadcastReceiver,intentFilter)

        binding.btnAlarm.setOnClickListener {
            val time = SystemClock.elapsedRealtime() // hozirgi vaqt + 10000
            val intent = Intent(this,MyReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this,1,intent, PendingIntent.FLAG_MUTABLE)
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,time,10000,pendingIntent)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        // dasturdan chiqqanimizdan keyin budulnik ishdan to`xtashi uchun
        unregisterReceiver(myBroadcastReceiver)
    }
}