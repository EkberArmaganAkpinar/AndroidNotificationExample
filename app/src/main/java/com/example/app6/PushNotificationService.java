package com.example.app6;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class PushNotificationService extends FirebaseMessagingService {
    public  String value;

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        Map dataMap = remoteMessage.getData();
        String activityName = (String) dataMap.get("activity");
        Log.d("DATA", activityName == null ? "DATA BOŞ" : activityName);

        Tools.keepvalue(activityName);
        String title= remoteMessage.getNotification().getTitle();
        String test=remoteMessage.getNotification().getBody();
        Log.d("",title);
        Log.d("",test);

        super.onMessageReceived(remoteMessage);
    }
}
