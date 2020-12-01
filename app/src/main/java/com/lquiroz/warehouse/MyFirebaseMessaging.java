package com.lquiroz.warehouse;

import android.nfc.Tag;
import android.util.Log;
import java.util.Map;


import androidx.annotation.NonNull;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.lquiroz.warehouse.R;
import com.lquiroz.warehouse.MainActivity;

public class MyFirebaseMessaging extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";

    @Override
    public void onNewToken(@NonNull String token) {
        super.onNewToken(token);
        Log.d(TAG, "onNewToken: " + token);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d(TAG, "Mensaje recibido");
        Map<String, String> data = remoteMessage.getData();
        if (data.size() > 0) {
            Log.d(TAG, "data: " + data);
            String title = data.get("titulo");
            String msg = data.get("mensaje");
            sendNotification(title, msg);
    }else{
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        String title = notification.getTitle();
        String msg = notification.getBody();

        sendNotification(title, msg);
    }

}

    private void sendNotification(String title, String msg) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, MyNotification.NOTIFICATION_ID, intent, PendingIntent.FLAG_ONE_SHOT);

        MyNotification notification = new MyNotification(this, MyNotification.CHANNEL_ID_NOTIFICATIONS);
        notification.build(R.drawable.ic_baseline_mood_24, title, msg, pendingIntent);
        notification.addChannel("Notificaciones", NotificationManager.IMPORTANCE_DEFAULT);
        notification.createChannelGroup(MyNotification.CHANNEL_GROUP_GENERAL, R.string.common_google_play_services_notification_channel_name);
        notification.show(MyNotification.NOTIFICATION_ID);
    }
}

