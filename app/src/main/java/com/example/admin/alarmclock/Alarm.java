package com.example.admin.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver {
    static MediaPlayer mp;
    @Override




    public void onReceive (Context context, Intent intent)
    {
         mp = MediaPlayer.create(context, Settings.System.DEFAULT_ALARM_ALERT_URI);
         mp.setLooping(true);
        mp.start();
        Toast.makeText(context, "wake up", Toast.LENGTH_LONG).show();
    }


}
