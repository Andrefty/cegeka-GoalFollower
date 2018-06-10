package com.example.cristi.firstcegeka;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

class Notification_reciever extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {

       // Toast.makeText(context , "gay" , Toast.LENGTH_LONG).show();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Intent intent5 = new Intent (context , MainActivity.class);
        intent5.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context , 100 , intent5 , PendingIntent.FLAG_UPDATE_CURRENT);
        Uri sound = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.not_bad);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.robotboi)
                .setContentTitle("Se repeta zilnic")
                .setContentText("Vreau sa devin un baietel adevarat")
                .setSound(sound)
                .setAutoCancel(true);

        if (intent.getAction().equals("MY_NOTIFICATION_MESSAGE")) {
            notificationManager.notify(100, builder.build());
        }

    }

}
