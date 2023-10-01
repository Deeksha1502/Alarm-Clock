package com.example.admin.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;

import android.content.Intent;
import android.os.Handler;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class stpwtc extends AppCompatActivity {

    Handler myhandler=new Handler();
    private Button start;
    private Button stop;
    private TextView counter;


    int i=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stpwtc);

        start=findViewById(R.id.start);
        stop=findViewById(R.id.stop);
        counter=findViewById(R.id.count);
    }

    public void start(View v)
    {
        i=1;
        myhandler.postDelayed(Threadcount,5000);
    }
    public void stop(View v)
    {
        myhandler.removeCallbacks(Threadcount);
    }
    public Runnable Threadcount=new Runnable()
    {
        @Override
        public void run() {
            counter.setText(""+i);
            i++;
            myhandler.postDelayed(Threadcount,1000);
        }
    };

}