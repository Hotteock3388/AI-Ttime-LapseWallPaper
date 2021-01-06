package com.example.ai_timelapse_wallpaper.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import com.example.ai_timelapse_wallpaper.R
import com.example.ai_timelapse_wallpaper.Singleton

class MyServiceTest : Service() {


    // 서비스가 최초 생성될 때만 호출
    override fun onCreate() {

    }

    // startService()로 서비스를 시작할 때 호출
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Singleton.gMediaPlayer().stop()
        Singleton.sMediaPlayer(MediaPlayer.create(applicationContext, R.raw.sad))
        Singleton.gMediaPlayer().start()
        Log.d("TestLog", "서비스 시작 1")
        return START_REDELIVER_INTENT
    }


    // bindService()로 바인딩을 실행할 때 호출
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }


    override fun stopService(name: Intent?): Boolean {

        Singleton.gMediaPlayer().stop()
        Log.d("TestLog", "서비스 중지 1")

        return super.stopService(name)
    }

    // unbindService()로 바인딩을 해제할 때 호출
    override fun onUnbind(intent: Intent?): Boolean {

        Singleton.gMediaPlayer().stop()
        Log.d("TestLog", "서비스 중지 1")
        return super.onUnbind(intent)
    }

    // 이미 onUnbind()가 호출된 후에 bindService()로 바인딩을 실행할 때 호출
    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    // 서비스가 소멸될 때 호출
    override fun onDestroy() {
        super.onDestroy()
        //Singleton.gMediaPlayer().stop()
        Log.d("TestLog", "서비스 종료")
    }

}
