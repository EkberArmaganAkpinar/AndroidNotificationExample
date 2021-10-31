package com.example.app6;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class Tools {
    private static Context contextt;
    private static String CHANNEL_ID="CHANNEL_ID";

    private static String CHANNEL_NAME= "CHANNEL_NAME";
    private static String value2;




    public Tools(Context contextt) {
        this.contextt=contextt;
    }

    public static Tools with(Context contextt){
        return new Tools(contextt);
    }



    private static NotificationManager getNotificationManager(){
        NotificationManager manager= (NotificationManager) contextt.getSystemService(Context.NOTIFICATION_SERVICE);
          if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
              NotificationChannel channel=new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH);
              channel.setShowBadge(true);
              channel.enableVibration(true);
              channel.enableLights(true);
              manager.createNotificationChannel(channel);
          }
    return manager;
    }
    public  static  void showNotification(String s, String title, String body,int icon, Intent resultIntent){
        resultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NO_ANIMATION);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(contextt,0,resultIntent,PendingIntent.FLAG_ONE_SHOT);
       //PushNotificationService ps=new PushNotificationService();

        if("value".equalsIgnoreCase(value2)){

            Intent inte= new Intent(contextt,MainActivity2.class);
            PendingIntent pi=  PendingIntent.getActivity(contextt, 0, inte, PendingIntent.FLAG_UPDATE_CURRENT);

            Notification.Builder builder;
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                builder=new Notification.Builder(contextt,CHANNEL_ID);

            }else{
                builder=new Notification.Builder(contextt);
                builder.setAutoCancel(true);
                builder.setContentTitle(title);
                builder.setContentText(body);
                builder.setSmallIcon(icon);
                builder.setContentIntent(pi);
                getNotificationManager().notify(25,builder.build());

            }
        }
        else {
            Notification.Builder builder;
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                builder=new Notification.Builder(contextt,CHANNEL_ID);

            }else{
                builder=new Notification.Builder(contextt);
                builder.setAutoCancel(true);
                builder.setContentTitle(title);
                builder.setContentText(body);
                builder.setSmallIcon(icon);
                builder.setContentIntent(pendingIntent);
                getNotificationManager().notify(25,builder.build());

            }

        }



    }

public static void keepvalue(String value){
        value2=value;
}
}
