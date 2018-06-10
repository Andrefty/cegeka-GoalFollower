package com.example.cristi.firstcegeka;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    ListView my_list ;
    String[] items;
    String[] price;
    String[] descrtiption;
    NotificationCompat.Builder notification ;
    private static final int uniqueID = 45612;
    private static  int uniqueId2 ;
    private NotificationCompat.Builder builder;
    private NotificationManager notm;
    private RemoteViews remoteViews ;
    Button button1;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        remoteViews = new RemoteViews(getPackageName() , R.layout.custom_notification);

        remoteViews.setImageViewResource(R.id.Notification_img , R.drawable.chites_bot);
        remoteViews.setTextViewText(R.id.Notification_txt , "Ce ati facut taranilor , v-a crescut mustata ?");

        button1 = (Button) findViewById(R.id.BigNotBtn);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent notintent = new Intent(MainActivity.this , MainActivity.class);
                PendingIntent pendIntent = PendingIntent.getActivity(MainActivity.this , 13 , notintent , PendingIntent.FLAG_UPDATE_CURRENT);
                Uri sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.not_bad);

                builder = new NotificationCompat.Builder(MainActivity.this);
                builder.setSmallIcon(R.drawable.chites_bot)
                        .setAutoCancel(true)
                        .setCustomBigContentView(remoteViews)
                        .setSound(sound)
                        .setContentIntent(pendIntent);

                uniqueId2 = (int)System.currentTimeMillis();
                notm.notify(uniqueId2 , builder.build());


            }
        });


            button2 = (Button) findViewById(R.id.New_btn);


            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent2 = new Intent(MainActivity.this , DailyNotification.class);
                    startActivity(intent2);
                }
            });


        notification = new NotificationCompat.Builder(this);

        Resources res = getResources();
        my_list = (ListView) findViewById(R.id.my_list);
        items = res.getStringArray(R.array.items);
        price = res.getStringArray(R.array.price);
        descrtiption = res.getStringArray(R.array.description);

        ItemAdapter itemAdapt =  new ItemAdapter(this , items , price , descrtiption);
        my_list.setAdapter(itemAdapt);

        my_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent detailIntent = new Intent (getApplicationContext() , DetailActivity_Image.class);
                detailIntent.putExtra("com.example.cristi.firstcegeka.Item" , position);
                startActivity(detailIntent);
            }
        });


    }

   public void ClickedNotButton (View view)
    {

        Intent intent = new Intent(this , MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this , 0, intent , PendingIntent.FLAG_UPDATE_CURRENT );


        notification = new NotificationCompat.Builder(this);
        notification.setSmallIcon(R.drawable.chites_bot);
        notification.addAction(R.drawable.chites_bot , "Action" , pendingIntent);
        notification.setColor(ContextCompat.getColor(MainActivity.this, R.color.magenta));
        notification.setTicker("ce-ai facut tarane ?");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("O fata frumoasa la tabla !");
        notification.setContentText("Cristishor la tabla !");
        notification.setAutoCancel(true);
        notification.setContentIntent(pendingIntent);



        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID , notification.build());
    }

}
