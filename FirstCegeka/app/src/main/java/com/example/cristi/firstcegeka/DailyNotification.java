package com.example.cristi.firstcegeka;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class DailyNotification extends AppCompatActivity {

    Button btn ;
    int h;
    int m;
    int s;
    String Sh , Sm , Ss;
    EditText hEt;
    EditText mEt;
    EditText sEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_notification);
        hEt = findViewById(R.id.hour_text_edit);
        mEt = findViewById(R.id.minute_edit_text);
        sEt = findViewById(R.id.second_edit_text);
        //h = Integer.parseInt(hEt.getText().toString());
       // m = Integer.parseInt(mEt.getText().toString());
        //s = Integer.parseInt(sEt.getText().toString());
        btn = (Button) findViewById(R.id.Start_notification_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Sh = hEt.getText().toString();
                Sm = mEt.getText().toString();
                Ss = sEt.getText().toString();
                h = Integer.parseInt(Sh);
                m = Integer.parseInt(Sm);
                s = Integer.parseInt(Ss);
                if (h>24 || h<=0)
                    Toast.makeText(getApplicationContext() , "Ziua are 24 de ore" , Toast.LENGTH_LONG).show();
                else if (m>60 || m<0)
                    Toast.makeText(getApplicationContext() , "ora are 60 de minute" , Toast.LENGTH_LONG).show();
                else if (s>60 || s<0)
                    Toast.makeText(getApplicationContext() , "minutul are 60 de secunde" , Toast.LENGTH_LONG).show();
                else
                {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(Calendar.HOUR_OF_DAY , h);
                    calendar.set(Calendar.MINUTE , m);
                    calendar.set(Calendar.SECOND , s);

                    Intent intent3 = new Intent(DailyNotification.this , Notification_reciever.class);
                    intent3.setAction("MY_NOTIFICATION_MESSAGE");
                    PendingIntent pendingIntent2 = PendingIntent.getBroadcast(getApplicationContext() , 0 , intent3 , PendingIntent.FLAG_UPDATE_CURRENT);

                    AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                    alarmManager.setRepeating(AlarmManager.RTC_WAKEUP , calendar.getTimeInMillis() , AlarmManager.INTERVAL_DAY , pendingIntent2);
                    Toast.makeText(getApplicationContext() , "Notificare setata" , Toast.LENGTH_LONG).show();
                    Intent intent6 = new Intent(getApplicationContext() , MainActivity.class);
                    startActivity(intent6);
                }


            }
        });

    }
}
