package com.example.ai_timelapse_wallpaper

import android.os.Handler


class ServiceThread(handler: MyService.myServiceHandler) : Thread() {
    private lateinit var handler : Handler
    var isRun = true

    fun ServiceThread(handler: Handler) {
        this.handler = handler
    }
    fun  stopForever() {
        synchronized (this) { this.isRun = false; }
    }

     override fun run() {
        //반복적으로 수행할 작업을 한다.
        while (isRun) { handler.sendEmptyMessage( 0 )    //쓰레드에 있는 핸들러에게 메세지를 보냄
             try { Thread.sleep( 1000 ) //1초씩 쉰다.
                  } catch (e : Exception) {

             }
        }
    }
}

