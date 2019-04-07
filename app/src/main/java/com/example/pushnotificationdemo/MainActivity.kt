package com.example.pushnotificationdemo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun abc(view: View) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notification = NotificationCompat.Builder(this@MainActivity, "dxdiag")
            notification.setAutoCancel(true)
            notification.setContentTitle("Demo Notification")
            notification.setContentText("This is just a demo notification for O")
            notification.setSmallIcon(R.mipmap.ic_launcher_round)
            val arr = LongArray(3)
            arr[0] = 500
            arr[1] = 500
            arr[2] = 500
            notification.setVibrate(arr)
            notification.setDefaults(Notification.DEFAULT_SOUND)
            val mChannel = NotificationChannel("dxdiag", "My Notification", NotificationManager.IMPORTANCE_DEFAULT)
            val manager = this@MainActivity.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(mChannel)
            val intent = Intent(this@MainActivity, MainActivity::class.java)
            val ar = arrayOfNulls<Intent>(1)
            ar[0] = intent
            val pIntent = PendingIntent.getActivities(this@MainActivity, 0, ar, 0)
            notification.setContentIntent(pIntent)
            manager.notify(69, notification.build())
        }
    }
}
