package com.example.musicdemoapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.app.Service;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.IOException;

public class MusicService extends Service {
    private MediaPlayer mediaPlayer;
    private static final String CHANNEL_ID = "MusicChannel";
    private static final int NOTIFICATION_ID = 1;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String audioUrl = intent.getStringExtra("audioUrl");


        if(audioUrl != null){
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(audioUrl);
                mediaPlayer.prepareAsync();
                mediaPlayer.setOnPreparedListener(mp -> {
                    mp.start();
                   // startForeground(NOTIFICATION_ID, createNotification());

                });
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

