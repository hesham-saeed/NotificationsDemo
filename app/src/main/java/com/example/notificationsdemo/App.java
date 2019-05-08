package com.example.notificationsdemo;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {
    public static final String CHANNEL_ID_1 = "channel1id";
    public static final String CHANNEL_ID_2 = "channel2id";

    @Override
    public void onCreate() {
        super.onCreate();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_ID_1,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH);

            NotificationChannel channel2 = new NotificationChannel(
                    CHANNEL_ID_2,
                    "Channel 2",
                    NotificationManager.IMPORTANCE_LOW);

            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel1);
            notificationManager.createNotificationChannel(channel2);

        }



    }
}
