package com.example.ai_timelapse_wallpaper.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.activity.MainActivity

class ChangeWallPaperService : Service() {

    private lateinit var mReceiver: CustomReceiver
    private val CHANNEL_ID = "Time-Lapse"
    private val FOREGROUND_ID = 333888
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        mReceiver = CustomReceiver()
        val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
        registerReceiver(mReceiver, filter)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        //repeatLog()
        if (intent != null) {
            if (intent.action == null) {
                if (mReceiver == null) {
                    mReceiver = CustomReceiver()
                    val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
                    registerReceiver(mReceiver, filter)
                }
            }
        }
        startForegroundService()


        return START_STICKY
    }

    private fun repeatLog() {
        val t = Thread(Runnable {
            for (i in 0 until 100000){
                Thread.sleep(500)
                Log.d("TestLog", "Timelapse $i")
            }
        })
        t.start()
    }

    private fun startForegroundService(){

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
        builder.setSmallIcon(R.mipmap.ic_launcher)
        builder.setContentTitle("TimeLapse")
        builder.setContentText("Foreground 서비스 실행중")

        //PendingIntent를 사용해서 Notification을 누르면 MainActivity가 켜지게 함
        val notiIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notiIntent, 0)
        builder.setContentIntent(pendingIntent)

        //Notification Channel이 Oreo(SDK V.26)이후부터 생김
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(NotificationChannel(CHANNEL_ID, "기본 채널", NotificationManager.IMPORTANCE_DEFAULT))
        }

        startForeground(FOREGROUND_ID, builder.build())
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mReceiver != null) {
            unregisterReceiver(mReceiver)
        }
    }

    //서비스가 이미 실행중인지 확인
    fun Context.isServiceRunning(serviceClass: Class<*>): Boolean {
        val activityManager = getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

        for (service in activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                Log.d("isServiceRunning", "Service is running")
                return true
            }
        }
        return false
    }

}
