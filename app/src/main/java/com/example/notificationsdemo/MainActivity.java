package com.example.notificationsdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText titleEditText;
    private EditText messageEditTExt;
    NotificationManagerCompat notifcationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleEditText = findViewById(R.id.title_text_view);
        messageEditTExt = findViewById(R.id.description_text_view);

        notifcationManager = NotificationManagerCompat.from(this);

    }

    public void sendNotification1(View view) {
        String title = titleEditText.getText().toString();
        CharSequence message = messageEditTExt.getText();

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        Intent intent2 = new Intent(this, ToastReceiver.class);
        intent2.putExtra("toastMessage","Hello from Receiver");
        PendingIntent pendingIntent2 = PendingIntent.getBroadcast(this, 0, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification1 = new NotificationCompat.Builder(this, App.CHANNEL_ID_1)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .addAction(R.mipmap.ic_launcher,"TOAST",pendingIntent2)
                .setContentIntent(pendingIntent)
                .setColor(Color.BLUE)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();
        notifcationManager.notify(1, notification1);
    }

    public void sendNotification2(View view) {
        String title = titleEditText.getText().toString();
        CharSequence message = messageEditTExt.getText();
        Notification notification2 = new NotificationCompat.Builder(this, App.CHANNEL_ID_2)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notifcationManager.notify(2, notification2);
    }
}
