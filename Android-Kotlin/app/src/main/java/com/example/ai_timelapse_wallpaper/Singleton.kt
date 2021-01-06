package com.example.ai_timelapse_wallpaper

import android.media.MediaPlayer


object Singleton {
    var mediaPlayer : MediaPlayer = MediaPlayer()


    fun gMediaPlayer(): MediaPlayer {
        return mediaPlayer
    }

    fun sMediaPlayer(mediaPlayer: MediaPlayer) {
        this.mediaPlayer = mediaPlayer
    }


}