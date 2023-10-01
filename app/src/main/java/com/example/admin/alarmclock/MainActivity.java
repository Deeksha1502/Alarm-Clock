package com.example.admin.alarmclock;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private TimePicker tp;
    private Button btn_set;

    private Button stpwtc;

    Button ext;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_set=findViewById(R.id.set_alarm);
        tp=findViewById(R.id.time);
        btn_set.setOnClickListener(this);
        ext = findViewById(R.id.exit);
        stpwtc=findViewById(R.id.stp);

        stpwtc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopwatch();
            }
        });

        ext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });


    }

    @Override
    public void onClick(View view)
    {
       // Toast.makeText(this, "Your alarm is set", Toast.LENGTH_LONG).show();
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH),
                tp.getHour(),
                tp.getMinute(),0);
       // set_alarm(cal.getTimeInMillis());
        Alarm_set(cal.getTimeInMillis());



    }

    private void Alarm_set(long timeInMillis)

    {
        //Toast.makeText(this, "Your alarm is set", Toast.LENGTH_LONG).show();

        AlarmManager alarmManager = (AlarmManager)  getSystemService(Context.ALARM_SERVICE);

     Intent intent = new Intent(this,Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent,0);
        Toast.makeText(this, "Your alarm is set", Toast.LENGTH_LONG).show();
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,timeInMillis,AlarmManager.INTERVAL_DAY,pendingIntent);

        //Toast.makeText(this, "Your alarm is set", Toast.LENGTH_LONG).show();

    }

    public void stopwatch() {
        Intent i=new Intent(this,stpwtc.class);
        startActivity(i);
    }
}