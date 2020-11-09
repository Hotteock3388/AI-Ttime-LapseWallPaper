package com.example.ai_timelapse_wallpaper

import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Message
import androidx.core.app.NotificationCompat
import java.util.*

class MyService : Service() {
    var Notifi_M: NotificationManager? = null
    var thread: ServiceThread? = null

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Notifi_M =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val handler = myServiceHandler()
        thread = ServiceThread(handler)
        thread!!.stopForever()
        return START_STICKY
    }

    //서비스가 종료될 때 할 작업
    override fun onDestroy() {
        val handler = myServiceHandler()

        thread = ServiceThread(handler)
        thread!!.start()
    }

    fun stop() {
        val handler = myServiceHandler()

        thread = ServiceThread(handler)
        thread!!.stopForever()
    }

    inner class myServiceHandler : Handler() {
        override fun handleMessage(msg: Message) {
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val intent = Intent(this@MyService, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            val pendingIntent =
                PendingIntent.getActivity(this@MyService, 0, intent, PendingIntent.FLAG_ONE_SHOT)
            val soundUri =
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                @SuppressLint("WrongConstant") val notificationChannel =
                    NotificationChannel(
                        "my_notification",
                        "n_channel",
                        NotificationManager.IMPORTANCE_MAX
                    )
                notificationChannel.description = "description"
                notificationChannel.name = "Channel Name"
                assert(notificationManager != null)
                notificationManager.createNotificationChannel(notificationChannel)
            }
            val notificationBuilder =
                NotificationCompat.Builder(this@MyService)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setLargeIcon(
                        BitmapFactory.decodeResource(
                            resources,
                            R.drawable.ic_launcher_foreground
                        )
                    )
                    .setContentTitle("Title")
                    .setContentText("ContentText")
                    .setAutoCancel(true)
                    .setSound(soundUri)
                    .setContentIntent(pendingIntent)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setOnlyAlertOnce(true)
                    .setChannelId("my_notification")
                    .setColor(Color.parseColor("#ffffff"))
            assert(notificationManager != null)
            val m = (Date().time / 1000L % Int.MAX_VALUE).toInt()
            val cal = Calendar.getInstance()
            val hour = cal[Calendar.HOUR_OF_DAY]
            if (hour == 18) {
                notificationManager.notify(m, notificationBuilder.build())
                thread!!.stopForever()
            } else if (hour == 22) {
                notificationManager.notify(m, notificationBuilder.build())
                thread!!.stopForever()
            }
        }
    }
}