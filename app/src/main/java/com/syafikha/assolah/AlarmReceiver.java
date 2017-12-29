package com.syafikha.assolah;

/**
 * Created by Acer on 12/19/2017.
 */

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

import static android.support.v4.content.WakefulBroadcastReceiver.completeWakefulIntent;
import static android.support.v4.content.WakefulBroadcastReceiver.startWakefulService;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Notification received!", Toast.LENGTH_LONG).show();
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);

        //Stop sound service to play sound for alarm
        context.startService(new Intent(context, AlarmSoundSevice.class));

        //This will send a notification message and show notification in notification tray
        ComponentName comp = new ComponentName(context.getPackageName(),
                AlarmNotificationServices.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
    }
}
