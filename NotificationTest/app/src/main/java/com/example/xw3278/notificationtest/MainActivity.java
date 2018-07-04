package com.example.xw3278.notificationtest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.send_notice:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                    NotificationChannel mChannel = new NotificationChannel("default", "sendMessage", NotificationManager.IMPORTANCE_DEFAULT);
                    manager.createNotificationChannel(mChannel);

                    Intent intent = new Intent(this, NotificationActivity.class);
                    PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

                    Notification notification = new NotificationCompat.Builder(this, "default")
                            .setContentText("This is content text")
                            .setContentTitle("This is content title")
                            .setWhen(System.currentTimeMillis())
                            .setChannelId("default")
                            .setContentIntent(pIntent)
                            .setAutoCancel(true)
                            .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")))
                            .setVibrate(new long[] {0, 1000, 1000, 1000})
                            .setLights(Color.GREEN, 1000, 1000)
                            .setPriority(NotificationCompat.PRIORITY_MAX)
                            .setDefaults(NotificationCompat.DEFAULT_ALL)
                            .setSmallIcon(R.drawable.ic_launcher_background)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                    R.drawable.ic_launcher_foreground)).build();
                    manager.notify(1, notification);
                }

                break;
            default:
                break;
        }
    }
}
