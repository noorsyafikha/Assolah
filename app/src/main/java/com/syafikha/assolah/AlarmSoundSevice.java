package com.syafikha.assolah;

/**
 * Created by Acer on 12/19/2017.
 */

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class AlarmSoundSevice extends Service {
    private MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Start media player
        mediaPlayer = MediaPlayer.create(this, R.raw.azan1);
        mediaPlayer.start();
        mediaPlayer.setLooping(false);//set l1ooping true to run it infinitely
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //On destory stop and release the media player
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            mediaPlayer.reset();
            mediaPlayer.release();
        }
    }
}

