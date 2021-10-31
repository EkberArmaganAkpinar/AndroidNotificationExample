package com.example.app6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFirebase();

        Intent intent=new Intent(getApplicationContext(),ResultReciver.class);

        intent.setAction(ResultReciver.ACTION_CLICK);

        Tools.with(getApplicationContext()).showNotification(
                "s","title","body",R.mipmap.ic_launcher,intent
        );


    }
    private void initFirebase() {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(command -> {
            String token = command.getResult();

            Log.d("Token", token);
        });
    }

    }


